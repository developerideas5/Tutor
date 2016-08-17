package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface WeatherReporter extends EJBObject
{
	public String getTemperature(String city)throws RemoteException;
}
