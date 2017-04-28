package com.ddup.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	
	//用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	//密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	//broker的地址 
	private static final String BROKERURL = "failover:(tcp://139.129.132.252:61616)";
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				/*USERNAME,
				PASSWORD,*/
				BROKERURL
				);
		
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer messageConsumer = null;
		try {
			connection = connectionFactory.createConnection();
			
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("daily_news");
			messageConsumer = session.createConsumer(destination);
			connection.start();
			while (true) {
				TextMessage message = (TextMessage)messageConsumer.receive(10000);
				if (message !=null ) {
					System.out.println("收到" + message.getText());
				}else{
					break;
				}
			}
			
		} catch (JMSException e) {
			e.printStackTrace();
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
