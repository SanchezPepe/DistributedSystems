/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Task;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class MasterNode {
    public static void main(String[] args) {
        Task[] bioTasks, dataTasks, imgTasks;
        
        bioTasks = new Task[10];
        dataTasks = new Task[20];
        imgTasks = new Task[15];
        
        //Tasks vacias con solo duracion
        bioTasks[0] = new Task(5);
        bioTasks[1] = new Task(10);
        bioTasks[2] = new Task(15);
        bioTasks[3] = new Task(20);
        bioTasks[4] = new Task(30);
        bioTasks[5] = new Task(5);
        bioTasks[6] = new Task(10);
        bioTasks[7] = new Task(15);
        bioTasks[8] = new Task(20);
        bioTasks[9] = new Task(30);
        
        dataTasks[0] = new Task(5);
        dataTasks[1] = new Task(10);
        dataTasks[2] = new Task(15);
        dataTasks[3] = new Task(20);
        dataTasks[4] = new Task(30);
        dataTasks[5] = new Task(5);
        dataTasks[6] = new Task(10);
        dataTasks[7] = new Task(15);
        dataTasks[8] = new Task(20);
        dataTasks[9] = new Task(30);
        dataTasks[10] = new Task(5);
        dataTasks[11] = new Task(10);
        dataTasks[12] = new Task(15);
        dataTasks[13] = new Task(20);
        dataTasks[14] = new Task(30);
        dataTasks[15] = new Task(5);
        dataTasks[16] = new Task(10);
        dataTasks[17] = new Task(15);
        dataTasks[18] = new Task(20);
        dataTasks[19] = new Task(30);
        
        imgTasks[0] = new Task(5);
        imgTasks[1] = new Task(10);
        imgTasks[2] = new Task(15);
        imgTasks[3] = new Task(20);
        imgTasks[4] = new Task(30);
        imgTasks[5] = new Task(5);
        imgTasks[6] = new Task(10);
        imgTasks[7] = new Task(15);
        imgTasks[8] = new Task(20);
        imgTasks[9] = new Task(30);
        imgTasks[10] = new Task(5);
        imgTasks[11] = new Task(10);
        imgTasks[12] = new Task(15);
        imgTasks[13] = new Task(20);
        imgTasks[14] = new Task(30);
        
        System.out.println("Tasklists Created...");
        
        Thread t1 = new Thread(new ErrandThread("Bioinformatics", bioTasks));
        Thread t2 = new Thread(new ErrandThread("DataMining", dataTasks));
        Thread t3 = new Thread(new ErrandThread("ImageProcessing", imgTasks));
        System.out.println("Errand Threads Created...");
        
        long tic = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Errand Threads Running...");
        
        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println("Thread Run Time:\n" + Long.toString(System.currentTimeMillis() - tic));
        } catch (InterruptedException ex) {
            Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
