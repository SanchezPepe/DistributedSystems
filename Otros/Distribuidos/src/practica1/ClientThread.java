/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author sdist
 */
public class ClientThread implements Runnable{
    private String host;
    private int port, requests;

    public ClientThread(String host, int port, int requests) {
        this.host = host;
        this.port = port;
        this.requests = requests;
    }
    
    @Override
    public void run() {
        Socket s = null;
	    try {
	   	
                s = new Socket(host, port);    
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
                int id = 0;
                long sum = 0;
                long sum2 = 0;
                long tic, toc;
                Random rng = new Random();
                
                for (int i = 0; i < requests; i++) {
                    id = rng.nextInt(6);
                    tic = System.nanoTime();
                    out.writeInt(id);
                    in.readUTF();
                    toc = System.nanoTime() - tic;
                    sum += toc;
                    sum2 += toc * toc;
                }
                
                out.writeInt(-1);
                
                double avg = ((double) sum)/requests;
                double std = Math.sqrt(((double) sum2)/requests - avg*avg);
                System.out.println(Integer.toString(requests) + '\t' + Double.toString(avg) + '\t' + Double.toString(std));
                
       	    }
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO: "+e.getMessage());
            } finally {
                if(s!=null) 
                    try {
                        s.close();
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
            }
    }
    
}
