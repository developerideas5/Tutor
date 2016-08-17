package com.ejbChapter;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import org.springframework.context.access.ContextJndiBeanFactoryLocator;
import org.springframework.ejb.support.AbstractStatefulSessionBean;

public class AccountBean extends AbstractStatefulSessionBean implements AccountService
{
	private AccountService accountService;
	
	public void ejbCreate()throws CreateException
	{
		setBeanFactoryLocator(new ContextJndiBeanFactoryLocator());
		loadBeanFactory();
		accountService = (AccountService)getBeanFactory().getBean("accountServiceBean");
		System.out.println("***accountService : " + accountService);
		System.out.println("***** " + this);
	}
	
	public void ejbActivate() throws EJBException, RemoteException {
		setBeanFactoryLocator(new ContextJndiBeanFactoryLocator());
		loadBeanFactory();
		accountService = (AccountService)getBeanFactory().getBean("accountServiceBean");
		System.out.println("***Activated***");
	}
	public void ejbPassivate() throws EJBException, RemoteException {
		setBeanFactoryLocator(null);
		unloadBeanFactory();
		System.out.println("***Passivated***");
		
	}
	public void deposit(double amount) {
		accountService.deposit(amount);
		
	}

	public double getBalance() {
		return accountService.getBalance();
	}

	public void withdraw(double amount) {
		accountService.withdraw(amount);
	}
}
