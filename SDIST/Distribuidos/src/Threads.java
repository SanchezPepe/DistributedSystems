/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdist
 */
public class Threads {
    public static void main(String[] args) {
        HelloThread th1 = new HelloThread();
        Thread th2 = new Thread(new HelloRunnable());
        
        th1.start();
        th2.start();
        
        Counter c = new Counter(0);
        
        Thread th3 = new Thread(new SynchronizedThread(c));
        Thread th4 = new Thread(new SynchronizedThread(c));
        
        th3.start();
        th4.start();
    }
}
