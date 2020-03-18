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
public class TCPClient {
    public static void main(String[] args) {
        Socket s = null;
	    try {
	    	int serverPort = 777;
	   	
                s = new Socket("localhost", serverPort); 
                ObjectOutputStream out = new ObjectOutputStream( s.getOutputStream());
		ObjectInputStream in = new ObjectInputStream( s.getInputStream());
		Person p = new Person(0, "Miguel");
		out.writeObject(p); 
		p = (Person) in.readObject();	      
                System.out.println("Received: "+ p) ;      
       	    } 
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO:"+e.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                if(s!=null) 
                    try {
                        s.close();
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
            }
    }
}
