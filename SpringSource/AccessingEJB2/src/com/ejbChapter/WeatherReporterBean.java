package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class WeatherReporterBean implements SessionBean
{
	public String getTemperature(String city) 
	{
		// Ideally we would find out what the temperature here (one server side)
		// is and report it. We will be lazy and generate a random number, instead.

		return "Temperature of " + city + " is : " + (Math.random() * 100 );
	}

	public void ejbCreate()
	{}
	
	public void ejbActivate() throws EJBException, RemoteException 
	{}

	public void ejbPassivate() throws EJBException, RemoteException 
	{}

	public void ejbRemove() throws EJBException, RemoteException 
	{}

	public void setSessionContext(SessionContext arg0) throws EJBException,	RemoteException 
	{}
}
