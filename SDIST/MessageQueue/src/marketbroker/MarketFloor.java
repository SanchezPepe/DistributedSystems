/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketbroker;

/**
 *
 * @author sdist
 */
public class MarketFloor {
    
    private static String[] subjects = {"Telecom", "Banks", "Transportation", "Food Supply", "Education"};
        
    public static void main(String[] args) {
        Thread t;
        for(String s: subjects){
            t = new Thread(new BrokerThread(s, 5));
            t.start();
        }
    }
}
