package client;

import interfaces.Compute;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

/**
 * ComputeClient
 */
public class ComputeClient {

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            Compute comp = (Compute) registry.lookup(name);

            System.out.println("3^2 = " + comp.square(3));
            System.out.println("3^3 = " + comp.power(3,3));

        } catch (RemoteException e) {
            Logger.getLogger(e.toString());
        } catch (NotBoundException e){
            Logger.getLogger(e.toString());
        }
    }
}