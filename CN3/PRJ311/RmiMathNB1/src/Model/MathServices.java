package Model;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathServices extends Remote {
    double add(double x, double y) throws RemoteException;
    double subtract(double x, double y) throws RemoteException;
}
