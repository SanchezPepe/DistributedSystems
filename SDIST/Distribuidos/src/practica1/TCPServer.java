/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.net.*;
import java.io.*;

/**
 *
 * @author sdist
 */
public class TCPServer {

    public static void main(String[] args) {
        AddressBook directorio = new AddressBook();
        
        try {
            int serverPort = 1025;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true){
                System.out.println("Esperando nuevo cliente...");
                Socket clientSocket = listenSocket.accept();
                Thread c = new Thread(new TCPConnectionThread(clientSocket, directorio));
                c.start();
            }
                    
        }catch(IOException e){
            System.out.println("Listen :"+ e.getMessage());
        }
    }
}
