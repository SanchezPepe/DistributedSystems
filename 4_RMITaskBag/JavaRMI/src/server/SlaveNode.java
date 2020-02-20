package server;

import java.rmi.RemoteException;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;

/**
 * SlaveNode
 */
public class SlaveNode implements BioInformatics, DataMining, ImageProcessing {

    public SlaveNode() throws RemoteException{
        super();
    }

    @Override
    public void executeBioTask(Task t) throws RemoteException{
        System.out.println("ExecutingBioTask");
    }

    @Override
    public double square(int number) throws RemoteException {
        return (number * number);
    }

    @Override
    public double power(int num1, int num2) throws RemoteException {
        return (java.lang.Math.pow(num1, num2));
    }

    
}