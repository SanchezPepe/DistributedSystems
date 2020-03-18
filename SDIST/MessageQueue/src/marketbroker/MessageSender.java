/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketbroker;

/**
 *
 * @author JGUTIERRGARC
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jmstopicamq.*;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String[] subjects = {"Telecom", "Banks", "Transportation", "Food Supply", "Education"};     

    public void produceMessages() {
        MessageProducer[] mp = new MessageProducer[5];
        TextMessage textMessage;
        Random rng = new Random();
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Destination[] destinations = new Destination[5];
            
            for(int i=0; i<5; i++){
                destinations[i] = session.createTopic(subjects[i]);
                mp[i] = session.createProducer(destinations[i]);
            }
            
            int cat, lvl;
            textMessage = session.createTextMessage();
            for(int i=0; i<50; i++){
                cat = rng.nextInt(5);
                lvl = rng.nextInt(10) + 1;
                
                textMessage.setText(Integer.toString(lvl));
                System.out.println("News. Level: " + lvl + ". Category: " + subjects[cat]);
                mp[cat].send(textMessage);
                
                Thread.sleep(1000);
            }
            
            System.out.println("Finished");
            textMessage.setText("-1");
            
            
            for(MessageProducer m: mp){
                m.send(textMessage);
                m.close();
            }
            
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
