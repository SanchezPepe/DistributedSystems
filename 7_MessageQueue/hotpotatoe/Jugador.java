/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author Jose Sanchez
 */
public class Jugador extends Thread{
    
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    String id, queue1, queue2;

    public Jugador(String id, String queue1, String queue2) {
        this.id = id;
        this.queue1 = queue1;
        this.queue2 = queue2;
    }
    
    @Override
    public void run() {
        MessageProducer messageProducer;
        ObjectMessage msg, msg2;
        Random rng = new Random();
        try {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Destination destination = session.createQueue(queue1);
            messageProducer = session.createProducer(destination);
            
            destination = session.createQueue(queue2);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            
            
            msg = session.createObjectMessage();
            
            Papa p = new Papa(rng.nextInt(10) + 2);
            msg.setObject(p);
            messageProducer.send(msg);
            System.out.println(id + " empieza con " + p.getCounter());
            boolean lost = false;
            int c;
            
            while(!lost){
                msg2 = (ObjectMessage) messageConsumer.receive();
                if(msg != null){
                    p =(Papa) msg2.getObject();
                    c = p.getCounter();
                    if(c == -1){
                      System.out.println(id + " ganó");
                      lost = true;
                    }
                    else if(c == 1){
                        System.out.println(id + " perdió");
                        p.setCounter(-1);
                        msg.setObject(p);
                        messageProducer.send(msg);
                        // Para dejar las colas limpias
                        do{
                            msg2 = (ObjectMessage) messageConsumer.receive();
                        }while(msg2 == null);
                        
                        lost = true;
                    }else{
                        System.out.println(id + " recibió " + c);
                        p.setCounter(c - 1);
                        msg.setObject(p);
                        messageProducer.send(msg);
                    }
                }
            }
            
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    
}
