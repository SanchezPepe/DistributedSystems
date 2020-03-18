/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;

/**
 *
 * @author sdist
 */
public class ProcesoB {

    // Recibe mensaje por UDP
    public static String receiveMessage() {
        DatagramSocket aSocket = null;
        String message = null;
        try {
            int serverPort = 6789;
            aSocket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[1000]; // buffer encapsulará mensajes
            Boolean received = false;
            while (!received) {
                System.out.println("Waiting for messages UDP...");
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                DatagramPacket reply = new DatagramPacket(request.getData(),
                        request.getLength(),
                        request.getAddress(),
                        request.getPort());
                if(reply != null){
                    received = true;
                    message = new String(request.getData());
                }

                System.out.println("Server received a request from " + request.getAddress());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
        return message;
    }

    // Envía Mensaje por TCP
    public static void sendMessage(String msg) {
        Socket s = null;
        try {
            int serverPort = 7896;

            s = new Socket("localhost", serverPort);
            //   s = new Socket("127.0.0.1", serverPort);    
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out
                    = new DataOutputStream(s.getOutputStream());
            out.writeUTF(msg);        	// UTF is a string encoding 

            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
                System.out.println("Mensaje enviado por TCP");
            }
        }
    }

    public static void main(String args[]) {
        String s = receiveMessage();
        if(s != null){
            System.out.println("Recibí por UDP: " + s);
            sendMessage(s);
        } else{
            System.out.println("Error al recibir mensaje por UDP");
        }
    }
}
