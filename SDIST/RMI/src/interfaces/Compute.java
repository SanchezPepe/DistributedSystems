/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import client.Creds;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author sdist
 */
public interface Compute extends Remote{
    public double square(int n, Creds c) throws RemoteException;
    public double power(int n1, int n2, Creds c) throws RemoteException;
    
}
