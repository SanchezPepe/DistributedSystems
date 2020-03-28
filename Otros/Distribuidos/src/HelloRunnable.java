/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdist
 */
public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hola :)\t" + Thread.currentThread().getName());
    }
    
}
