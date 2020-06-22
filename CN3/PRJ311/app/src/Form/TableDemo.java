package Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TableDemo {
    private JTable TblEmployee;
    private JPanel panel1;
    private JPanel panel2;

    Vector<String> header = new Vector<>();
    Vector data = new Vector();


    public TableDemo(){
        //initComponents();
        header.add("ID");
        header.add("Name");
        header.add("Department");
        Vector row1= new Vector();
        row1.add("DE140085");
        row1.add("Nguyen Trung Hieu");
        row1.add("MAE");
        data.add(row1);

        Vector row2= new Vector();
        row2.add("DE140084");
        row2.add("Tran Phi Anh");
        row2.add("PRJ");
        data.add(row2);
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel= (DefaultTableModel) this.TblEmployee.getModel();
        tblModel.setDataVector(data,header);


        JComboBox cb = new JComboBox();
        cb.addItem("IT");
        cb.addItem("CSE");
        cb.addItem("HR");
        DefaultCellEditor editor = new DefaultCellEditor(cb);
        this.TblEmployee.getColumnModel().getColumn(2).setCellEditor(editor);
    }
    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new TableDemo().panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
