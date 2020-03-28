package server;

import java.rmi.RemoteException;
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
            System.out.println("ExecutingBioTask: " + t.taskId + ". Time: " + t.length + "s");
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
}