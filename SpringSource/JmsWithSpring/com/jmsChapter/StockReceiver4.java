package com.jmsChapter;



public class StockReceiver4 
{
	public StockReceiver4()
	{
		System.out.println("*******************");
	}
	public void processResponse(String txtMsg)
	{
		System.out.println("Received : " + txtMsg);
	}
/*	public void processResponse(Map<String, Double> mapMsg)
	{
		System.out.println("Received : " + mapMsg.get("price"));
	}
*/
}
