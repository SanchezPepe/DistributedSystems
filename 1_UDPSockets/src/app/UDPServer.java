
// "contenido", localhost

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

public class UDPServer {

    public static void main(String args[]) {
        DatagramSocket aSocket = null;

        try {
            int serverPort = 6789;
            // Creación del socket
            aSocket = new DatagramSocket(serverPort);

            // Buffer para encapsulamiento de mensajes
            byte[] buffer = new byte[1000];

            while (true) {
                System.out.println("UDP Server up. Waiting for messages...");

                // DatagramPacket de recepción 
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                // Se arma el response con los parámetros del DatagramPacket recibido
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());

                System.out.println("Server received a request from: " + request.getAddress());

                // Se envía response
                aSocket.send(reply);
                System.out.println("Sent response");
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}
