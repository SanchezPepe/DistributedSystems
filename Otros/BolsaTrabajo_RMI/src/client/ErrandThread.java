/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class ErrandThread implements Runnable{
    String serviceName;
    Task[] taskList;

    public ErrandThread(String serviceName, Task[] taskList) {
        this.serviceName = serviceName;
        this.taskList = taskList;
    }
    
    
    @Override
    public void run() {
        System.setProperty("java.security.policy", "file:/C:\\Users\\sdist.ITAM\\Desktop\\155766\\BolsaTrabajo_RMI\\src\\client\\client.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
            Registry r = LocateRegistry.getRegistry("localhost");
            
            if(serviceName.equals("Bioinformatics")){
                
                Bioinformatics service = (Bioinformatics) r.lookup(serviceName);
                for(Task t:taskList){
                    t = service.executeBioTask(t);
                }
                
            }else if(serviceName.equals("DataMining")){
                
                DataMining service = (DataMining) r.lookup(serviceName);
                for(Task t:taskList){
                    t = service.executeDataTask(t);
                }
                
            }else if(serviceName.equals("ImageProcessing")){
                
                ImageProcessing service = (ImageProcessing) r.lookup(serviceName);
                for(Task t:taskList){
                    t = service.executeImgTask(t);
                }
                
            }else{
                System.err.println("Service not foud: " + serviceName);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ErrandThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ErrandThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
