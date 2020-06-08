import javax.swing.*;

public class menu {
    private JPanel menuPanel;
    private JMenuBar MenuBar;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new menu().menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
