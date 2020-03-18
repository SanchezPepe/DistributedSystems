/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Compute;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class ComputeClient {
    
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "file:/C:\\Users\\sdist.ITAM\\Desktop\\155766\\RMI\\src\\client\\client.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        String name = "Compute";
        Registry r;
        try {
            Creds id = new Creds("Miguel", "DF", "123", 1996);
            r = LocateRegistry.getRegistry("localhost");
            Compute c = (Compute) r.lookup(name);
            System.out.println(c.square(8, id));
        } catch (RemoteException ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
