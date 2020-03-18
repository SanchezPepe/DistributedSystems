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
public class ProcesoA {

    // Envía mensaje por UDP
    public static void sendMessage(String msg) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte[] m = msg.getBytes();

            InetAddress aHost = InetAddress.getByName("localhost");
            // InetAddress aHost = InetAddress.getByAddress("localhost", new byte[]
            // {(byte)148, (byte)205, (byte)199 ,(byte) 100});
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + (new String(reply.getData())).trim());
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }

    public static void main(String args[]) {
        sendMessage("Estoy enviando un mensaje por UDP");

    }

}
