package com.ddup.activemq;

import javax.jms.ConnectionFactory;

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
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				USERNAME,
				PASSWORD,
				BROKERURL
				);
	}
}
