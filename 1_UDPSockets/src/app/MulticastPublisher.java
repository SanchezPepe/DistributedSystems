import java.net.*;
import java.io.*;

public class MulticastPublisher {

    public static void multicastMessage(String multicastMessage) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            String gp = "230.0.0.0";
            InetAddress group = InetAddress.getByName(gp);
            byte[] buf = multicastMessage.getBytes();

            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            aSocket.send(packet);
            System.out.println("Sent message to group: " + gp);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        for (int i = 0; i < 5; i++) {
            multicastMessage("Message " + i);
            Thread.sleep(2000);
        }
        multicastMessage("end");
        


    }
}