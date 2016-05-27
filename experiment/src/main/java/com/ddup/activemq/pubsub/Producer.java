package com.ddup.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	
	//broker的地址 
	private static final String BROKERURL = "failover:(tcp://139.129.132.252:61616)";
	
	public static void main(String[] args) {
		
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				BROKERURL
				);
		
		Connection connection = null;
		Session session = null;
		Destination topic = null;
		MessageProducer messageProducer = null;
		
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			topic = session.createTopic("notice.daily");
			messageProducer = session.createProducer(topic);
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			int i= 0;
			while (true) {
				i++;
				TextMessage message = session.createTextMessage("每日新闻来了：" + i);
				messageProducer.send(message);
				System.out.println(message.getText());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			
		} finally {
			if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
		}
	}
}
