import java.net.*;

import javax.sound.sampled.SourceDataLine;

import java.io.*;

public class MulticastReceiver {

    public static void main(String[] args) {
        byte[] buf = new byte[256];
        MulticastSocket aSocket = null;
        try {
            aSocket = new MulticastSocket(4446);
            String gp = "230.0.0.0";
            InetAddress group = InetAddress.getByName(gp);
            aSocket.joinGroup(group);
            System.out.println("Joined group: " + gp);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                aSocket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Recieved message: " + received);
                if ("end".equals(received)) {
                    System.out.println("Received end instruction");
                    break;
                }
            }
            aSocket.leaveGroup(group);
            aSocket.close();
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