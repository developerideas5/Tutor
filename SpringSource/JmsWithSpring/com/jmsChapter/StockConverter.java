package com.jmsChapter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class StockConverter implements MessageConverter
{
	public Object fromMessage(Message msg) throws JMSException,
			MessageConversionException 
	{
		MapMessage mapMsg = (MapMessage)msg;
		Stock stock = new Stock();
		stock.setSymbol(mapMsg.getString("symbol"));
		stock.setPrice(mapMsg.getDouble("price"));
		return stock;
	}

	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException 
	{
		Stock stock = (Stock)obj;
		MapMessage mapMsg = session.createMapMessage();
		mapMsg.setDouble("price", stock.getPrice());
		mapMsg.setString("symbol", stock.getSymbol());
		return mapMsg;
	}
}
