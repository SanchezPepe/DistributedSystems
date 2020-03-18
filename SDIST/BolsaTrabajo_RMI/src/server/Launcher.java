/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Launcher {
    public static void main(String[] args) {
        
        try {
            Registry r = LocateRegistry.createRegistry(1099);
            
            SlaveNode s1 = new SlaveNode("Bioinformatics");
            SlaveNode s2 = new SlaveNode("DataMining");
            SlaveNode s3 = new SlaveNode("ImageProcessing");
            
            s1.deploy();
            s2.deploy();
            s3.deploy();
            
        } catch (RemoteException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
