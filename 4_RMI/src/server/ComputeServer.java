package server;

import interfaces.Compute;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

/**
 * ComputeServer
 */
public class ComputeServer implements Compute {

    public ComputeServer() throws RemoteException {
        super();
    }

    @Override
    public double square(int number) throws RemoteException {
        return (number * number);
    }

    @Override
    public double power(int num1, int num2) throws RemoteException {
        return (java.lang.Math.pow(num1, num2));
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "3_RemoteInvocation/JavaRMI/src/server/server.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            LocateRegistry.createRegistry(1099);
            System.out.println("Server Listening...");

            String name = "Compute";
            ComputeServer engine = new ComputeServer();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);

        } catch (RemoteException e) {
            Logger.getLogger(e.toString());
        }
    }
}