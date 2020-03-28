/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class ProcesoC {

    // Recibe mensaje por TCP
    public static String receiveMessage() {
        String msg = null;
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            Boolean received = false;
            while (!received) {
                System.out.println("Waiting for messages TCP...");
                Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
                Connection c = new Connection(clientSocket);
                c.corre();
                if(c.msg != null){
                    received = true;
                    msg = c.msg;
                }
                
            }
            listenSocket.close();
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
        return msg;
    }

    // RMI Client
    public static void rmiClient(String msg) {
        System.setProperty("java.security.policy", "src\\Procesos\\client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry r;
        try {
            r = LocateRegistry.getRegistry("localhost");
            Message m = (Message) r.lookup("Message");
            System.out.println(m.processMsg(msg));
        } catch (RemoteException ex) {
            Logger.getLogger(ProcesoC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProcesoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String ans = receiveMessage();
        if (ans != null) {
            System.out.println("Recibí mensaje por TCP: " + ans);
            rmiClient(ans);
        } else {
            System.out.println("Error al recibir mensaje por TCP");
        }
    }
    

}

class Connection{

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    String msg = null;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void corre() {
        try {			                 // an echo server
            String data = in.readUTF();
            System.out.println("Message received from: " + clientSocket.getRemoteSocketAddress() + data);
            out.writeUTF(data);
            msg = data;
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
