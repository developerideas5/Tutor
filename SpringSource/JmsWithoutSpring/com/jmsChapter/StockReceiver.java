package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StockReceiver 
{
	public void receive()
	{
		 try 
		 {
			InitialContext ctx = new InitialContext();
			 TopicConnectionFactory tcFactory = (TopicConnectionFactory) ctx.lookup(
			         "ConnectionFactory");
			 TopicConnection topicConnection = tcFactory.createTopicConnection();
			 TopicSession subscriberSession = topicConnection.createTopicSession(false,
			         Session.AUTO_ACKNOWLEDGE); 
			 Topic stockTopic = (Topic) ctx.lookup("topic/StockTopic");
			 TopicSubscriber subscriber = subscriberSession.createSubscriber(stockTopic);
			 subscriber.setMessageListener(new StockListener());
			 topicConnection.start();
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
class StockListener implements MessageListener
{
	public void onMessage(Message msg) {
        try {
            if (msg instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) msg;
                System.out.println("Received :" + textMessage.getText());
            } else {
                System.out.println("Received :" + msg);
            }
        } catch (JMSException e) {
            System.out.println("Error:" + e);
        }
    }

}