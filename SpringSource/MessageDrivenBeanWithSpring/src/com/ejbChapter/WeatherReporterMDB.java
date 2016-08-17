package com.ejbChapter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.springframework.ejb.support.AbstractJmsMessageDrivenBean;


public class WeatherReporterMDB extends AbstractJmsMessageDrivenBean
{
	WeatherReporterService weatherReporterService;
	protected void onEjbCreate() 
	{
		weatherReporterService = (WeatherReporterService)getBeanFactory().getBean("weatherReporterServiceBean");
		System.out.println("*** " + weatherReporterService + " *********");
	}

	public void onMessage(Message msg)
	{
		TextMessage txtMsg = (TextMessage)msg;
		try 
		{
			String info =  txtMsg.getText();
			weatherReporterService.processTemperatureInfo(info);
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
