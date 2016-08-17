package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StockPublisher 
{
	public void publish(double price)
	{
		try {
			InitialContext cnt = new InitialContext();
			TopicConnectionFactory tcFactory = (TopicConnectionFactory) cnt.lookup(
			        "ConnectionFactory");
			TopicConnection topicConnection = tcFactory.createTopicConnection();
			TopicSession publisherSession = topicConnection.createTopicSession(false,
			        Session.AUTO_ACKNOWLEDGE); //false for transacted
			Topic stockTopic = (Topic) cnt.lookup("topic/StockTopic");
			TopicPublisher publisher = publisherSession.createPublisher(stockTopic);
			topicConnection.start();
		    TextMessage textMessage = publisherSession.createTextMessage();
		    textMessage.setText("Price : " + price);
		    System.out.println("Published price :" + price);
		    publisher.publish(textMessage);
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
