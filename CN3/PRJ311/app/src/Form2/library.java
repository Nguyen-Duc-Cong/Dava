package Form2;

import javax.swing.*;

public class library {
    private JPanel card;
    private JTextField useName;
    private JPasswordField passwordText;
    private JButton button1;
    private JButton button2;
    private JMenu menu;
    private JPanel Window;
    private JTable table1;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new library().Window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void Login(){
        useName = new JTextField();
        passwordText = new JPasswordField();
        
    }


}
