package com.ejbChapter;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface WeatherReporterLocalHome extends EJBLocalHome
{
	public WeatherReporterLocal create() throws CreateException,RemoteException;
}
