/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Creds;
import interfaces.Compute;
import java.rmi.RemoteException;

/**
 *
 * @author sdist
 */
public class ComputeServer implements Compute{

    @Override
    public double square(int n, Creds c) throws RemoteException {
        System.out.println("Method Accesed by: \n" + c.toString());
        return n*n;
    }

    @Override
    public double power(int n1, int n2, Creds c) throws RemoteException {
        System.out.println("Method Accesed by: \n" + c.toString());
        return java.lang.Math.pow(n1, n2);
    }
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "file:/C:\\Users\\sdist.ITAM\\Desktop\\155766\\RMI\\src\\server\\server.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
    }
    
}
