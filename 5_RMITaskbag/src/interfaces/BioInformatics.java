package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Bioinformatics
 */
public interface BioInformatics extends Remote{

    public void executeBioTask(Task aTask) throws RemoteException;
}