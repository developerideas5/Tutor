package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class StockPublisher 
{
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public void publish(final double price)
	{
		jmsTemplate.send(
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
