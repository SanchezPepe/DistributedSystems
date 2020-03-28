/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sdist
 */
public class TCPServer {
    
    public static void main (String args[]) {
	try{
		int serverPort = 777; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			System.out.println("Waiting for messages..."); 
                        Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
			Connection c = new Connection(clientSocket);
                        c.start();
		}
	} catch(IOException e) {System.out.println("Listen :"+ e.getMessage());}
    }
   
}

class Connection extends Thread {
	ObjectInputStream in;
	ObjectOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
	    try {
		clientSocket = aClientSocket;
		in = new ObjectInputStream(clientSocket.getInputStream());
		out = new ObjectOutputStream(clientSocket.getOutputStream());
	     } catch(IOException e)  {System.out.println("Connection:" + e.getMessage());}
	}
        
        @Override
	public void run(){
	    try {
		Person p =(Person) in.readObject();	     
                p.setId(p.getId() + 1);
                out.writeObject(p);
	    } 
            catch(EOFException e) {
                System.out.println("EOF:"+e.getMessage());
	    } 
            catch(IOException e) {
                System.out.println("IO:"+e.getMessage());
	    } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e){
                    System.out.println(e);
                }
                }
            }
}
