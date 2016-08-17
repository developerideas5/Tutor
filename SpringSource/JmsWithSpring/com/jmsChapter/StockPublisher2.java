package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class StockPublisher2 extends JmsGatewaySupport
{
	public void publish(final double price)
	{
		getJmsTemplate().send(
				new MessageCreator()
				{
					@Override
					public Message createMessage(Session session)
							throws JMSException 
					{
						TextMessage txtMsg = session.createTextMessage();
						txtMsg.setText("Price : " + price);
						System.out.println("Published : " + price);
						return txtMsg;
					}
				});
	}
}
