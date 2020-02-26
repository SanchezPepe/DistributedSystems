import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.*;
import server.SlaveNode;

/**
 * Starter
 */
public class Starter {

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "server/server.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            LocateRegistry.createRegistry(1099);
            System.out.println("Server Listening...");
            Registry registry = LocateRegistry.getRegistry();

            SlaveNode bioEngine = new SlaveNode();
            BioInformatics bioStub = (BioInformatics) UnicastRemoteObject.exportObject(bioEngine, 0);
            registry.rebind("BIO", bioStub);

            SlaveNode dataEngine = new SlaveNode();
            DataMining dataStub = (DataMining) UnicastRemoteObject.exportObject(dataEngine, 0);
            registry.rebind("DATA", dataStub);

            SlaveNode imageEngine = new SlaveNode();
            ImageProcessing imageStub = (ImageProcessing) UnicastRemoteObject.exportObject(imageEngine, 0);
            registry.rebind("IMAGE", imageStub);

        } catch (RemoteException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}