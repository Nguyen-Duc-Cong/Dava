import javax.swing.*;
import java.rmi.Naming;
        import java.rmi.registry.LocateRegistry;

public class MathClient {
    String serviceName = "rmi://localhost:1098/MathServer";
    Mathmatician server;
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JButton bAdd;
    private JButton subtractButton;
    private JTextField textField3;

    public MathClient() {

    }
}
