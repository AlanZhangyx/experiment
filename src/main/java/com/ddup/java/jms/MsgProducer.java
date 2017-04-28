package com.ddup.java.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgProducer {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "failover://tcp://139.129.132.252:61616"
                );
        
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("QUEUE_BUY_TICKET");
        MessageProducer messageProducer = session.createProducer(destination);
        connection.start();
        //send message
        for (int i = 1; i < 10; i++) {
            String msg = "我是第 -- ： " + i + "个！";
            System.out.println(msg);
            Message message = session.createTextMessage(msg);
            messageProducer.send(message);
        }
        session.commit();
        connection.close();
    }

}
