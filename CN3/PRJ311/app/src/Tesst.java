import javax.swing.*;

public class Tesst {
    private JPanel panel1;
    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox comboBox1;
    private JPanel pEmp;
    private JButton hideButton;


    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Tesst().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void btExitActionPerformed(java.awt.ActiveEvent evt) {
        System.exit(0);
    }

    private void btHideShowActionPerfromed(java.awt.ActiveEvent evt) {
        if (this.hideButton.getText().equalsIgnoreCase("hide")) {
            this.pEmp.setVisible(false);
            this.hideButton.setText("Show");
        } else {
            this.pEmp.setVisible(true);
            this.hideButton.setText("Hide");
        }
    }
}
