import javax.swing.*;

public class nemu {

    private JPanel paint;
    private JPanel menuPanel;
    private JPanel centerPanel;
    private JMenuBar menuBar;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new nemu().paint);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
