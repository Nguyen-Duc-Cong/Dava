package Form;

import javax.swing.*;

public class LoginForm {
    private JTextField user;
    private JPasswordField password;
    private JButton loginButton;
    private JButton exitButton;
    private JPanel panelLogin;


    private void btExitActionPerformed(java.awt.ActiveEvent evt) {
        System.exit(0);
    }
    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new LoginForm().panelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
