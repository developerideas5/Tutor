package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface AccountHome extends EJBHome
{
	public Account create() throws CreateException,RemoteException;
}
