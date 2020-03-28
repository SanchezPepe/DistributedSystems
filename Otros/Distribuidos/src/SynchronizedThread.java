/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdist
 */
public class SynchronizedThread implements Runnable{
    
    private Counter c;
    
    public SynchronizedThread(Counter c){
        this.c = c;
    }
    
    @Override
    public void run() {
        c.count10();
    }
    
}
