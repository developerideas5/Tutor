package com.jmsChapter;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class StockReceiver5 extends JmsGatewaySupport
{
	public void receive()
	{
		Stock stock = (Stock)getJmsTemplate().receiveAndConvert();
		System.out.println("Received : " + stock.getSymbol() + " : " + stock.getPrice());
	}
}
