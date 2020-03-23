/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketbroker;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author sdist
 */
public class BrokerThread implements Runnable{
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    int sensitivity;
    String category;

    public BrokerThread(String category, int sensitivity) {
        this.category = category;
        this.sensitivity = sensitivity;
    }
    
    @Override
    public void run() {
        System.out.println("Agente de: " + category);
        boolean goodByeReceived = false;

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(category);

            MessageConsumer messageConsumer = session.createConsumer(destination);
            int lvl;
            while (!goodByeReceived) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null) {
                    lvl = Integer.parseInt(textMessage.getText());
                    if(textMessage.getText().equals("-1")){
                        goodByeReceived = true;
                    }else if(lvl < sensitivity){
                        System.out.println(category + " news Recieved..." + "Level: " + lvl + ". Hold");
                    }else{
                        System.out.println(category + " news Recieved..." + "Level: " + lvl + ". Sell");
                    }
                }
            }

            messageConsumer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
