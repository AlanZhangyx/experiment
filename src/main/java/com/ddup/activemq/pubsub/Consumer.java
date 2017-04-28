package com.ddup.activemq.pubsub;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	//broker的地址 
	private static final String BROKERURL = "failover:(tcp://139.129.132.252:61616)";
	
	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				BROKERURL
				);
		
		Connection connection = null;
		Session session = null;
		Destination topic = null;
		MessageConsumer messageConsumer = null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			topic = session.createTopic("notice.daily");
			messageConsumer = session.createConsumer(topic);
			
			messageConsumer.setMessageListener(new MessageListener(){
				public void onMessage(Message message) {
					TextMessage tm = (TextMessage) message;
					try {
						System.out.println("Received message: " + tm.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			
		} 
	}
}
