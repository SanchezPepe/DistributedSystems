/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main (String args[]) {

	Socket s = null;
	    try {
	    	int serverPort = 7896;
                s = new Socket("localhost", serverPort);    
                FileOutputStream fos = new FileOutputStream("temp.tmp");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                Person p = new Person(3123, "Jose");

                oos.writeObject(p);
                oos.close();
                System.out.println("Se mandó : "+ p.getName()) ;      
       	    } 
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO:"+e.getMessage());
            } finally {
                if(s!=null) 
                    try {
                        s.close();
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
                    }
            }
}
