package client;
/**
 * MasterNode
 */
public class MasterNode extends Thread{

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "4_RMITaskBag/JavaRMI/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            // Obtener el registro del RMI
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            Compute comp = (Compute) registry.lookup(name);

            /**
             * Definir las 3 bolsas de tareas
             *  - Para cada bolsa:
             *      - Crear hilo ejecutor(BoT, registro)
             *      - Iniciar hilo ejecutor
             */
            Task[] bioTask = new Task[30];
            Task[] dataMiningTask = new Task[30];
            Task[] imageTask = new Task[30];


        } catch (RemoteException e) {
            Logger.getLogger(e.toString());
        } catch (NotBoundException e){
            Logger.getLogger(e.toString());
        }
    }
    

    
}