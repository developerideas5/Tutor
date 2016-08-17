package com.jmsChapter;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class StockPublisher5 extends JmsGatewaySupport
{
	public void publish(String symbol,double price)
	{
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		stock.setPrice(price);
		getJmsTemplate().convertAndSend(stock);
		System.out.println("Published : " + stock.getSymbol() + ", " + stock.getPrice());
	}
}
