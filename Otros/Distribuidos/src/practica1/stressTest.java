/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author sdist
 */
public class stressTest {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 666;
        int requests = 200;
        int clients = 40;
        
        for (int i = 0; i < clients; i++) {
            Thread c = new Thread(new ClientThread(host, port, requests));
            c.start();
        }
    }
}
