package com.ejbChapter;

import javax.ejb.Remote;

@Remote
public interface WeatherReporter extends TemperatureProvider
{
	
}