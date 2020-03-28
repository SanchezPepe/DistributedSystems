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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class TCPConnectionThread implements Runnable{
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    AddressBook ad;

    public TCPConnectionThread(Socket clientSocket, AddressBook ad) {
        this.clientSocket = clientSocket;
        this.ad = ad;
        try {
            in = new DataInputStream(clientSocket.getInputStream());
            out =new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(TCPConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try{
            int id = in.readInt();
            Person p;
            while(id >= 0 && id <= 5){
                p = ad.getRecord(id);
                out.writeUTF(p.getName());
                id = in.readInt();
            }
	}catch(EOFException e) {
            System.out.println("EOF:"+e.getMessage());
	}catch(IOException e) {
            System.out.println("IO:"+e.getMessage());
	}finally{
            try {
                clientSocket.close();
            }catch (IOException e){
                System.out.println(e);
            }
        }   
    }
    
}
