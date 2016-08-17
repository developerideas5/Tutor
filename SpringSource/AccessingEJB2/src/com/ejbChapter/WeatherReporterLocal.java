package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.EJBLocalObject;

public interface WeatherReporterLocal extends EJBLocalObject
{
	public String getTemperature(String city)throws RemoteException;
}
