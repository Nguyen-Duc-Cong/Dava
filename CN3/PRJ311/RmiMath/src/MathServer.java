import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MathServer {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/MathServer";
        Mathmatician server;
        try {
            server = new Mathmatician();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            Naming.rebind(serviceName, server);
            System.out.println("Service "+ serviceName + "is running");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
