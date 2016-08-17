package com.ejbChapter;

import javax.ejb.CreateException;
import org.springframework.ejb.support.AbstractStatelessSessionBean;

public class WeatherReporterBean extends AbstractStatelessSessionBean implements TemperatureProvider
{
	private TemperatureProvider temperatureProvider;

	protected void onEjbCreate() throws CreateException 
	{
		temperatureProvider = (TemperatureProvider)getBeanFactory().getBean("temperatureProviderBean");
		System.out.println("********weatherReporterService : " + temperatureProvider);

	}

	@Override
	public String getTemperature(String city) 
	{
		return temperatureProvider.getTemperature(city);
	}
	
}
