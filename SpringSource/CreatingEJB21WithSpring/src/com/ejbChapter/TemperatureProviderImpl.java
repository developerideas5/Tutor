package com.ejbChapter;

public class TemperatureProviderImpl implements TemperatureProvider 
{
	public String getTemperature(String city)
	{
		// Ideally we would find out what the temperature here (one server side)
		// is and report it. We will be lazy and generate a random number, instead.

		return "Temperatureee of " + city + " is : " + (Math.random() * 100 );
	}
}
