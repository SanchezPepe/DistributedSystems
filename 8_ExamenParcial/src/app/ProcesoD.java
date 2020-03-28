/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class ProcesoD implements Message {

    @Override
    public String processMsg(String s) throws RemoteException {
        String res = s;
        return res;
    }

    public static void start() {
        try {
            String name = "Message";
            ProcesoD cs = new ProcesoD();
            Message stub = (Message) UnicastRemoteObject.exportObject(cs, 0);

            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind(name, stub);
            System.out.println("ComputeServer - Message");

        } catch (RemoteException ex) {
            Logger.getLogger(ProcesoD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "src\\Procesos\\server.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        start();
    }

}
