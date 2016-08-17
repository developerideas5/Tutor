package com.jmsChapter;


public class StockReceiver6 
{
	{
		System.out.println("*********");
	}
	public void processResponse(Stock stock)
	{
		System.out.println("Received : " + stock.getSymbol() + " : " + stock.getPrice());
	}
}
