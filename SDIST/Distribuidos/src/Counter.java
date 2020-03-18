
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdist
 */
public class Counter {
    private int n = 0;
    
    public Counter(int n){
        this.n = n;
    }
    private synchronized void inc(){
        n++;
        System.out.println(n + "\t" + Thread.currentThread().getName());
    }
    public void count10(){
        for (int i = 0; i < 10; i++) {
            inc();
        }
    }
}
