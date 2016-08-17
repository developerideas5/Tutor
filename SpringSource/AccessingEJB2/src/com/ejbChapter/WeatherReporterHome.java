package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface WeatherReporterHome extends EJBHome
{
	public WeatherReporter create() throws RemoteException,CreateException;
}
