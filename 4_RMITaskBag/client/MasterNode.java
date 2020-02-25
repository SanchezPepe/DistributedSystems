package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;
import java.util.Random;

import interfaces.*;

/**
 * MasterNode
 */
public class MasterNode{

    public Task[] bioTask = new Task[15];
    public Task[] dataMiningTask = new Task[20];
    public Task[] imageTask = new Task[10];

    public void fillBags(){
        int[] execTimes = { 5, 10, 15, 20, 30 };
        /* Instanciado de las bolsas */
        for (int i = 0; i < bioTask.length; i++){
            bioTask[i] = new Task("B"+i, "BioTask" , getRandom(execTimes));
        }
        for (int i = 0; i < dataMiningTask.length; i++){
            dataMiningTask[i] = new Task("D"+i, "DataTask" , getRandom(execTimes));
        }
        for (int i = 0; i < imageTask.length; i++){
            imageTask[i] = new Task("I"+i, "ImageTask" , getRandom(execTimes));
        }
    }
    
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            // Obtener el RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            String name = "Compute";
            Compute comp = (Compute) registry.lookup(name);

            long start = System.currentTimeMillis();

            System.out.println("3^2 = " + comp.square(3));
            System.out.println("3^3 = " + comp.power(3,3));

            long end = System.currentTimeMillis();
            System.out.println("Tiempo total: " + (end - start));

        } catch (RemoteException e) {
            Logger.getLogger(e.toString());
        }
    }

}