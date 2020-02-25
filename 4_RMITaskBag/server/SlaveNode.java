package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

import interfaces.*;

/**
 * SlaveNode
 */
public class SlaveNode implements BioInformatics, DataMining, ImageProcessing {

    public SlaveNode() throws RemoteException {
        super();
    }

    @Override
    public void executeBioTask(Task t) throws RemoteException {
        try {
            System.out.println("ExecutingBioTask: " + t.taskId);
            Thread.sleep(t.length*1000);
        } catch (InterruptedException e){
            Logger.getLogger(SlaveNode.class.getName());
        }
    }

    @Override
    public void executeDataTask(Task t) throws RemoteException {
        try {
            System.out.println("ExecutingDataTask: " + t.taskId);
            Thread.sleep(t.length*1000);
        } catch (InterruptedException e){
            Logger.getLogger(SlaveNode.class.getName());
        }
    }

    @Override
    public void executeImageTask(Task t) throws RemoteException {
        try {
            System.out.println("ExecutingImageTask: " + t.taskId);
            Thread.sleep(t.length*1000);
        } catch (InterruptedException e){
            Logger.getLogger(SlaveNode.class.getName());
        }
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "server/server.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            LocateRegistry.createRegistry(1099);
            System.out.println("Server Listening...");

            SlaveNode engine = new SlaveNode();
            Registry registry  = LocateRegistry.getRegistry();;
            int taskId = 3;
            switch (taskId) {
                case 1:
                    BioInformatics bioStub = (BioInformatics) UnicastRemoteObject.exportObject(engine, 0);
                    registry.rebind("BioInformatics", bioStub);
                    break;
                case 2:
                    DataMining dataStub = (DataMining) UnicastRemoteObject.exportObject(engine, 0);
                    registry.rebind("DataMining", dataStub);
                    break;
                case 3:
                    ImageProcessing imageStub = (ImageProcessing) UnicastRemoteObject.exportObject(engine, 0);
                    registry.rebind("ImageProcessing", imageStub);
                    break;
                default:
                    System.out.println("Method not defined");
            }
        } catch (RemoteException e) {
            Logger.getLogger(e.toString());
        }
    }

}