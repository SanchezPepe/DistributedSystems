/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.Compute;
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
public class Start {
    public static void main(String[] args) {
        try {
            String name = "Compute";
            ComputeServer cs = new ComputeServer();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(cs, 0);
            
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind(name, stub);
            System.out.println("ComputeServer up under name Compute");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
