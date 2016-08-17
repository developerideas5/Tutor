package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class StockReceiver
{
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void receive()
	{
		TextMessage txtMsg = (TextMessage)jmsTemplate.receive();
		try 
		{
			System.out.println("Received : " + txtMsg.getText());
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
