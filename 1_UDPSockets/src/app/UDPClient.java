
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

public class UDPClient {

	public static void messageOverUDP(String msg){
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();

			// Mensaje en bytes, dirección IP y puerto
			byte[] messageInBytes = msg.getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;

			// Instancia del DatagramPacket
			DatagramPacket request = new DatagramPacket(messageInBytes, messageInBytes.length, aHost, serverPort);

			// Envío del mensaje 
			aSocket.send(request);
			System.out.println("Sent over UDP: " + msg);

			// Buffer para la recepción del mensaje de respuesta del servidor UDP
			byte[] buffer = new byte[1000];

			// DatagramPacket para la recepción del mensaje
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);

			System.out.println("Reply from server: " + (new String(reply.getData())).trim());
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
		
	}

	public static void main(String args[]) { 

		messageOverUDP("This is a message sent over UDP");
		
	}
}