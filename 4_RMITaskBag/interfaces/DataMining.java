package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * DataMining
 */
public interface DataMining extends Remote{

    public void executeDataTask(Task aTask) throws RemoteException;

}