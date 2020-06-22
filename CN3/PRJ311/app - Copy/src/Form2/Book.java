package Form2;

import Model.Employee;
import Model.EmployeeDB;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book extends Component {// Component la gi
    private JPanel pWindow;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTable tableEmp;
    private JTextField textField6;
    private JTextField textField7;
    private JButton searchButton;
    private JButton newEmp;
    private JButton updateEmp;
    private JButton deleteEmp;
    private JButton printEmp;
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
    private JMenu fEdit;
    private JPanel pSwitch;
    private JMenu fFile;
    private JMenuItem fExit;

    public Book() {
        EmpView();
        showEmp();
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
                btnNewActionPerformed(e);
            }
        });
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnViewActionPerformed(e);
            }
        });
//        fEdit.addMenuListener(new MenuListener() {
//            @Override
//            public void menuSelected(MenuEvent e) {
//                btnExitActionPerformed(e);
//            }
//
//            @Override
//            public void menuDeselected(MenuEvent e) {
//
//            }
//
//            @Override
//            public void menuCanceled(MenuEvent e) {
//
//            }
//        });
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
    Vector<String> header = new Vector<>();
    Vector data = new Vector();// chuyen thanh Array list duoc ko

    public void EmpView() {
        initComponents();
//Thêm header
        header.add("Employee ID");
        header.add("Last Name");
        header.add("First Name");
        header.add("Gender");
        header.add("Email");
        this.radMale.setSelected(true);
    }

    private void initComponents() {
    }

    //Thêm Emp
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) { //Lấy dữ liệu nhập vào
        String empID = this.txtEmpID.getText();
        String lastName = this.txtLastName.getText();
        String firstName = this.txtFirstName.getText();
        String email = this.txtEmail.getText();
        String gender = this.radMale.isSelected() ? "M" : "F";
//Kiểm tra ID hợp lệ
        if (!empID.matches("^DE\\d{6}$")) JOptionPane.showMessageDialog(null, "Employee ID: DE + 6 digits.");
//Kiểm tra email hợp lệ
        else if (!email.matches("^[a-z][a-z0-9_\\.]{5,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$"))
            JOptionPane.showMessageDialog(null, "Email: characters + @ + characters + .com");
        else {
            Employee employee = empDB.getEmployee(empID);//Kiểm tra trùng khóa if (employee == null) {
            if (empDB.newEmp(empID, lastName, firstName, gender, email) == 1) {
//Hiển thị lại dữ liệu mới nếu thêm thành công
                btnViewActionPerformed(null);
            } else //Không thêm được
                JOptionPane.showMessageDialog(this, "Add employee failure!");
        }
        //else
        //Trùng khóa
        JOptionPane.showMessageDialog(this, "Duplicate key!");
    }

    //Lấy tất cả dữ liệu hiển thị ra table
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) { //Lấy dữ liệu Emp
        data = empDB.getList();
//Hiển thị ra table
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) this.tableEmp.getModel();
        tblModel.setDataVector(data, header);
    }

    //Thoát
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnExitActionPerformed(MenuEvent MenuEvent) {
        System.exit(0);
    }

    private void showEmp() {
        pInput.removeAll();
        pInput.add(pEmp);
        pInput.repaint();
        pInput.revalidate();
    }

    //------------------------------------------pOutput-------------------------------------
    private void tableOutput() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) this.tableEmp.getModel();
        tblModel.setDataVector(empDB.getList(), header);
    }


    //------------------------------------------Main-------------------------------------
    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Book().pFull);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}