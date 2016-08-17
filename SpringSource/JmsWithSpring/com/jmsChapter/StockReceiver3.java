package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class StockReceiver3 implements MessageListener
{
	@Override
	public void onMessage(Message msg) 
	{
		TextMessage txtMsg = (TextMessage)msg;
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
