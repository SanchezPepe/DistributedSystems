/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotpotatoe;

/**
 *
 * @author sdist
 */
public class juego {
    public static void main(String[] args) {
        String id1 = "Jugador 1";
        String id2 = "Jugador 2";
        String queue1 = "HPQueue1";
        String queue2 = "HPQueue2";
        
        Thread t1 = new Thread(new Jugador(id1, queue1, queue2));
        Thread t2 = new Thread(new Jugador(id2, queue2, queue1));
        
        System.out.println("Empezando el juego!!");
        t1.start();
        t2.start();
    }
}
