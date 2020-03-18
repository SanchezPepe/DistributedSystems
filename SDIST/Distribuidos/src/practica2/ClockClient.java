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
/**
 *
 * @author sdist
 */
public class ClockClient {
    public static void main(String[] args) {
        MulticastSocket s =null;
   	try {
                InetAddress group = InetAddress.getByName("228.229.230.231"); // destination multicast group 
	    	s = new MulticastSocket(777);
	   	s.joinGroup(group); 

	    	byte[] buffer = new byte[1000];
                System.out.println("Waiting for messages");
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
 		s.receive(messageIn);
                System.out.println("Message: " + new String(messageIn.getData())+ " from: "+ messageIn.getAddress());
	    	s.leaveGroup(group);		
 	    }
         catch (SocketException e){
             System.out.println("Socket: " + e.getMessage());
	 }
         catch (IOException e){
             System.out.println("IO: " + e.getMessage());
         }
	 finally {
            if(s != null) s.close();
        }
    }
}
