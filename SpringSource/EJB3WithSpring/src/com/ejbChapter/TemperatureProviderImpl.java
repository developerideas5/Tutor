package com.ejbChapter;

public class TemperatureProviderImpl implements TemperatureProvider
{
	public String getTemperature(String city) 
	{
		return "Temperature of  " + city + " is " + Math.random()*100;
	}
}
