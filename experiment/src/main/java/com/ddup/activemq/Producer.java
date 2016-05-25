package com.ddup.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	//用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	//密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	//broker的地址
	private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	//消息数
	private static final int SENDNUM = 10;
	
	
	public static void main(String[] args){
		//ActiveMQ is an open sourced implementation of JMS 1.1 as part of the J2EE 1.4 specification.
		
		//two messaging styles 
		//    point-to-point messaging using queues
		//    publish-and-subscribe messaging using topics
		
		
		//********************* JMS API
		
		//*** common APIs
		//Message,BytesMessage,MapMessage,ObjectMessage,StreamMessage,TextMessage
		//Queue for PTP; Topic for pub/sub
		//Destination is supertype of Queue and Topic
		
		//*** classic API interfaces
		//ConnectionFactory used by a client to create a Connection.
		//Connection is an active connection to a JMS provider.
		//Session is a single-threaded context for sending and receiving messages.
		//MessageProducer created by a Session that is used for sending messages to a queue or topic.
		//MessageConsumer created by a Session that is used for receiving messages sent to a queue or topic.
		
		//*** Simplified API interfaces   -- same classic but fewer interfaces
		//ConnectionFactory ...create a JMSContext.
		//JMSContext == Connection + Session
		//JMSProducer same MessageConsumer but created by JMSContext
		//JMSConsumer same MessageConsumer but created by JMSContext
		
		//client uses to create a connection with a JMS provider.
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				USERNAME,
				PASSWORD,
				BROKERURL
				);
		
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer messageProducer = null;
		MessageConsumer messageConsumer = null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			destination = session.createQueue("daily_news");
			
			messageProducer = session.createProducer(destination);
			
//			messageProducer.send(message);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
