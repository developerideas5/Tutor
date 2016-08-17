package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class StockReceiver2 extends JmsGatewaySupport
{
	public void receive()
	{
		TextMessage txtMsg = (TextMessage)getJmsTemplate().receive();
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
