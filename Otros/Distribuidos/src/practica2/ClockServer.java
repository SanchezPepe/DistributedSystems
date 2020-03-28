/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class ClockServer {
    public static void main(String[] args) {
        MulticastSocket s = null;
        
   	 try {
                
                InetAddress group = InetAddress.getByName("228.229.230.231");
	    	s = new MulticastSocket(777);
	   	s.joinGroup(group); 
                
                String date;
                byte[] m;
                DatagramPacket messageOut;
                while (true) {
                    date = (new Date()).toString();
                    m = date.getBytes();
                    messageOut = new DatagramPacket(m, m.length, group, 777);
                    s.send(messageOut);
                    Thread.sleep(1000);
                }
	
 	    }
         catch (SocketException e){
             System.out.println("Socket: " + e.getMessage());
	 }
         catch (IOException e){
             System.out.println("IO: " + e.getMessage());
         } catch (InterruptedException ex) {
            Logger.getLogger(ClockServer.class.getName()).log(Level.SEVERE, null, ex);
        }
	 finally {
             
            if(s != null) {
                s.close();
            }
        }
    }
         
}
