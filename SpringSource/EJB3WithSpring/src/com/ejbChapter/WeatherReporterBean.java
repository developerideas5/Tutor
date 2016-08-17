package com.ejbChapter;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName="MyWeatherReporter")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class WeatherReporterBean implements WeatherReporter
{
	@Autowired
	private TemperatureProvider temperatureProvider;
	
	public String getTemperature(String city)
	{
		return temperatureProvider.getTemperature(city);
	}
}
