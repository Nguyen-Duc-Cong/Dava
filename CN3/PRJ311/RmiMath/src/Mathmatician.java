import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Mathmatician extends UnicastRemoteObject implements MathServices {
    protected Mathmatician() throws RemoteException {
    }

    @Override
    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }
}
