package com.ejbChapter;

import java.rmi.RemoteException;

public class WeatherService 
{
	private WeatherReporter weatherReporter;

	public void setWeatherReporter(WeatherReporter weatherReporter) {
		this.weatherReporter = weatherReporter;
	}
	public String getTemperature(String city)throws RemoteException
	{
		return weatherReporter.getTemperature(city);
	}
}
