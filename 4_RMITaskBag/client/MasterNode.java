package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import interfaces.*;

/**
 * MasterNode
 */
public class MasterNode {

    public static Task[] bioTask = new Task[15];
    public static Task[] dataMiningTask = new Task[20];
    public static Task[] imageTask = new Task[10];

    public static void fillBags() {
        int[] execTimes = { 5, 10, 15, 20, 30 };
        /* Instanciado de las bolsas */
        for (int i = 0; i < bioTask.length; i++) {
            bioTask[i] = new Task("B" + i, "BioTask", getRandom(execTimes));
        }
        for (int i = 0; i < dataMiningTask.length; i++) {
            dataMiningTask[i] = new Task("D" + i, "DataTask", getRandom(execTimes));
        }
        for (int i = 0; i < imageTask.length; i++) {
            imageTask[i] = new Task("I" + i, "ImageTask", getRandom(execTimes));
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

        fillBags();

        MasterThread bio_thread = new MasterThread(bioTask);
        MasterThread data_thread = new MasterThread(dataMiningTask);
        MasterThread img_thread = new MasterThread(imageTask);

        bio_thread.start();
        data_thread.start();
        img_thread.start();
    }
}

class MasterThread extends Thread {
    private Task task[];

    public MasterThread(Task[] t) {
        task = t;
    }

    public void run() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            for (Task t : task) {
                switch (t.getOutput()) {
                case ("BioTask"):
                    BioInformatics bio = (BioInformatics) registry.lookup("BIO");
                    bio.executeBioTask(t);
                    break;
                case ("DataTask"):
                    DataMining data = (DataMining) registry.lookup("DATA");
                    data.executeDataTask(t);
                    break;
                case ("ImageTask"):
                    ImageProcessing image = (ImageProcessing) registry.lookup("IMAGE");
                    image.executeImageTask(t);
                    break;
                }
                System.out.println(t.getOutput());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MasterThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MasterThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}