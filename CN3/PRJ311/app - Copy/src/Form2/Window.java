package Form2;

import Model.Book.Book;
import Model.Book.BookDB;
import Model.Book.ConnectDB;
import Model.Employee;
import Model.EmployeeDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Window extends Component {
    private JPanel pWindow;
    private JTextField txtBookID;
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtKeywork;
    private JTable table;
    private JTextField txtSearch;
    private JButton searchButton;
    private JButton newEmp;
    private JButton updateEmp;
    private JButton deleteEmp;
    private JButton printBook;
    private JButton exitEmp;
    private JButton newButton;
    private JButton viewAllButton;
    private JButton exitButton;
    private JTextField txtEmpID;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtFirstName;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JPanel pInfo;
    private JPanel pEmp;
    private JPanel pBook;
    private JPanel pInput;
    private JPanel pOutput;
    private JPanel pTable;
    private JPanel pFull;
    private JPanel pSwitch;
    private JComboBox jCategory;
    private JButton switchEmp;
    private JButton switchBook;
    private JComboBox jSearch;
    private JMenuItem fExit;
    private boolean empOpen = false;

    public Window() {
        view();
        {
            radMale.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radMale.isSelected()) radFemale.setSelected(false);
                }
            });
            radFemale.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radFemale.isSelected()) radMale.setSelected(false);
                }
            });
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnNewEmpActionPerformed(e);
                }
            });
            viewAllButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnViewActionPerformed(e);
                }
            });
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnExitActionPerformed(e);
                }
            });
        }

        {
            switchBook.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    empOpen = true;
                    show(e);
                    view();
                    btnViewActionPerformed(e);
                }
            });
            switchEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    empOpen = false;
                    show(e);
                    view();
                    btnViewActionPerformed(e);
                }
            });
        }

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                SearchTable(e);
            }
        });
        {
            printBook.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnViewActionPerformed(e);
                }
            });

            newEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnNewBookActionPerformed(e);
                }
            });
            deleteEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            updateEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchTable(e);
                }
            });
            deleteEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btmDeleteBook(e);
                }
            });
            if (!empOpen) {
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mouseClickTbale(e);
                    }
                });
            }
        }

        updateEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAction(e);
            }
        });
    }


    String lfMetal = "javax.swing.plaf.metal.MetalLookAndFeel";
    String lfWindow = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    String lfMotif = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

    private void btnMetalActionPreformed(java.awt.event.ActionEvent evt) {
        try {
            UIManager.setLookAndFeel(lfMetal);
            SwingUtilities.updateComponentTreeUI(this);
            JOptionPane.showMessageDialog(this, "Message", "Title", JOptionPane.QUESTION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("D").log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger("D").log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger("D").log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger("D").log(Level.SEVERE, null, ex);
        }
    }


    //------------------------------------------pInput-------------------------------------
    EmployeeDB empDB = new EmployeeDB();
    BookDB bDB = new BookDB();
    Vector<String> header = new Vector<>();
    Vector data = new Vector();

    public void view() {
        initComponents();
        if (empOpen) {
            header.clear();
            header.add("Employee ID");
            header.add("Last Name");
            header.add("First Name");
            header.add("Gender");
            header.add("Email");
            this.radMale.setSelected(true);
            empOpen = true;
        } else {
            header.clear();
            header.add("bookID");
            header.add("title");
            header.add("author");
            header.add("category");
            header.add("keyword");
            empOpen = false;
        }
    }

    private void initComponents() {
    }

    private void btnNewEmpActionPerformed(java.awt.event.ActionEvent evt) { //Lấy dữ liệu nhập vào
        String empID = this.txtEmpID.getText();
        String lastName = this.txtLastName.getText();
        String firstName = this.txtFirstName.getText();
        String email = this.txtEmail.getText();
        String gender = this.radMale.isSelected() ? "M" : "F";
        if (!empID.matches("^DE\\d{6}$")) JOptionPane.showMessageDialog(null, "Employee ID: DE + 6 digits.");
        else if (!email.matches("^[a-z][a-z0-9_\\.]{5,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$"))
            JOptionPane.showMessageDialog(null, "Email: characters + @ + characters + .com");
        else {
            Employee employee = empDB.getEmployee(empID);//Kiểm tra trùng khóa if (employee == null) {
            if (empDB.newEmp(empID, lastName, firstName, gender, email) == 1) {
                btnViewActionPerformed(null);
            } else
                JOptionPane.showMessageDialog(this, "Add employee failure!");
        }
        JOptionPane.showMessageDialog(this, "Duplicate key!");
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) { //Lấy dữ liệu nhập vào
        String bookID = this.txtBookID.getText();
        String title = this.txtTitle.getText();
        String author = this.txtAuthor.getText();
        String category = "CS";
        switch (jCategory.getSelectedItem().toString()) {
            case "Computer Science":
                category = "CS";
                break;
            case "Lập trình":
                category = "LT";
                break;
            case "Magazine":
                category = "MA";
                break;
            case "Programming":
                category = "PR";
                break;
            case "Reference":
                category = "RF";
                break;
            case "Textbook":
                category = "TX";
                break;
            default:
        }
        String keyword = this.txtKeywork.getText();
        Model.Book.Book book = bDB.getBook(bookID);
        Model.Book.Book b = new Book(bookID, title, author, category, keyword);
        bDB.addNewBook(b);
    }

    private void btmDeleteBook(ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (table.getSelectedRow() == -1) {
            if (table.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty");
            } else {
                JOptionPane.showMessageDialog(this, "You must choose table");
            }
        } else {
            try {
                BookDB.deleteBook(txtBookID.getText());
                JOptionPane.showMessageDialog(this, "Add employee failure!");
                JOptionPane.showMessageDialog(this, "Delete successfully");
                model.removeRow(table.getSelectedRow());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bDB.deleteBook(txtBookID.getText());
    }
    private void updateAction(ActionEvent evt){
        if (table.getSelectedRow() == -1) {
            if (table.getSelectedRow()== 0) {
                JOptionPane.showMessageDialog(this, "Table is empty");
            } else {
                JOptionPane.showMessageDialog(this, "You must choose table");
            }
        }
        else {
            String Tit = this.txtTitle.getText();
            String Aut = this.txtAuthor.getText();
            String Key = this.txtKeywork.getText();
            String cat = (String) this.jCategory.getSelectedItem();
            int selectBook= table.getSelectedRow();
            String BkID = (table.getModel().getValueAt(selectBook, 0).toString());
            if (txtBookID.getText().isEmpty() || txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty()
                    || txtKeywork.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fileds not empty!");
            }
            if(BkID != null){
                bDB.updateBook(BkID, Tit, Aut, cat, Key);
                show(evt);
                JOptionPane.showMessageDialog(this, "Update Book Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Can not update in this index");
            }
        }
    }
    //------------------------------------------pOutput-------------------------------------
    private void SearchTable(KeyEvent evt) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) this.table.getModel();
        switch (jSearch.getSelectedItem().toString()) {
            case "BookID":
                tblModel.setDataVector(bDB.searchByBookID(txtSearch.getText()), header);
                break;
            case "Title":
                tblModel.setDataVector(bDB.searchByTitle(txtSearch.getText()), header);
                bDB.searchByTitle(txtSearch.getText());
                break;
            case "Author":
                tblModel.setDataVector(bDB.searchByAuthor(txtSearch.getText()), header);
                bDB.searchByAuthor(txtSearch.getText());
                break;
            case "Category":
                tblModel.setDataVector(bDB.searchByCategory(txtSearch.getText()), header);
                bDB.searchByCategory(txtSearch.getText());
                break;
            case "keywork":
                tblModel.setDataVector(bDB.searchByKeyword(txtSearch.getText()), header);
                bDB.searchByKeyword(txtSearch.getText());
                break;
        }
    }

    private void SearchTable(ActionEvent e) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) this.table.getModel();
        switch (jSearch.getSelectedItem().toString()) {
            case "BookID":
                tblModel.setDataVector(bDB.searchByBookID(txtSearch.getText()), header);
                break;
            case "Title":
                tblModel.setDataVector(bDB.searchByTitle(txtSearch.getText()), header);
                bDB.searchByTitle(txtSearch.getText());
                break;
            case "Author":
                tblModel.setDataVector(bDB.searchByAuthor(txtSearch.getText()), header);
                bDB.searchByAuthor(txtSearch.getText());
                break;
            case "Category":
                tblModel.setDataVector(bDB.searchByCategory(txtSearch.getText()), header);
                bDB.searchByCategory(txtSearch.getText());
                break;
            case "keywork":
                tblModel.setDataVector(bDB.searchByKeyword(txtSearch.getText()), header);
                bDB.searchByKeyword(txtSearch.getText());
                break;
        }
    }

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel) this.table.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }

    private void show(java.awt.event.ActionEvent evt) {
        if (empOpen) {
            clearTable();
            pInput.removeAll();
            pInput.add(pEmp);
            pInput.repaint();
            pInput.revalidate();
        } else {
            clearTable();
            pInput.removeAll();
            pInput.add(pBook);
            pInput.repaint();
            pInput.revalidate();
        }
    }

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {
        if (empOpen) {
            data = empDB.getList();
            DefaultTableModel tblModel;
            tblModel = (DefaultTableModel) this.table.getModel();
            tblModel.setDataVector(data, header);
        } else {
            data = bDB.getAllBook();
            DefaultTableModel tblModel;
            tblModel = (DefaultTableModel) this.table.getModel();
            tblModel.setDataVector(data, header);
        }
    }

    private void mouseClickTbale(MouseEvent evt) {
        int i = table.getSelectedRow();
        TableModel model = table.getModel();
        txtBookID.setText(model.getValueAt(i, 0).toString());
        txtTitle.setText(model.getValueAt(i, 1).toString());
        txtAuthor.setText(model.getValueAt(i, 2).toString());
        String category = model.getValueAt(i, 3).toString();
        switch (category) {
            case "Computer Science":
                jCategory.setSelectedIndex(1);
                break;
            case "Lập trình":
                jCategory.setSelectedIndex(2);
                break;
            case "Magazine":
                jCategory.setSelectedIndex(3);
                break;
            case "Programming":
                jCategory.setSelectedIndex(4);
                break;
            case "Reference":
                jCategory.setSelectedIndex(5);
                break;
            case "Textbook":
                jCategory.setSelectedIndex(6);
                break;
            default:
        }
        txtKeywork.setText(model.getValueAt(i, 4).toString());
    }

    //------------------------------------------Main-------------------------------------
    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Window().pFull);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}