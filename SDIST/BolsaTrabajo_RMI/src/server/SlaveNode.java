/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
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
public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing{
    String taskType;

    public SlaveNode(String taskType) {
        this.taskType = taskType;
    }
    
    public void deploy(){
        if(taskType.equals("Bioinformatics")){
            try {
                
                Bioinformatics stub = (Bioinformatics) UnicastRemoteObject.exportObject(this, 0);

                Registry r = LocateRegistry.getRegistry("localhost");
                r.rebind(taskType, stub);
                System.out.println("Bioinformatics Service up under name Bioinformatics");

            } catch (RemoteException ex) {
                Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(taskType.equals("DataMining")){
            try {
                
                DataMining stub = (DataMining) UnicastRemoteObject.exportObject(this, 0);

                Registry r = LocateRegistry.getRegistry("localhost");
                r.rebind(taskType, stub);
                System.out.println(taskType + "Service up under name " + taskType);

            } catch (RemoteException ex) {
                Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(taskType.equals("ImageProcessing")){
            try {
                
                ImageProcessing stub = (ImageProcessing) UnicastRemoteObject.exportObject(this, 0);

                Registry r = LocateRegistry.getRegistry("localhost");
                r.rebind(taskType, stub);
                System.out.println(taskType + "Service up under name " + taskType);

            } catch (RemoteException ex) {
                Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.err.println("Unsupported Task Type: " + taskType);
        }
    }

    @Override
    public Task executeBioTask(Task t) {
        t.setOutput("Processed BioTask");
        try {
            Thread.sleep(t.getLength()*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Task executeDataTask(Task t) {
        t.setOutput("Processed DataTask");
        try {
            Thread.sleep(t.getLength()*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Task executeImgTask(Task t) {
        t.setOutput("Processed ImgTask");
        try {
            Thread.sleep(t.getLength()*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "file:/C:\\Users\\sdist.ITAM\\Desktop\\155766\\BolsaTrabajo_RMI\\src\\server\\server.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
    }
}
