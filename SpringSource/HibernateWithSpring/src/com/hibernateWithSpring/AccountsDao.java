package com.hibernateWithSpring;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AccountsDao extends HibernateDaoSupport 
{
	public void createAccount(int accountNumber,String owner,double balance)
	{
		Account account = new Account(accountNumber,owner,balance);
		getHibernateTemplate().save(account);
	}
	public void updateBalance(int accountNumber,double newBalance)
	{
		Account account = getHibernateTemplate().get(Account.class, accountNumber);
		if(account != null)
		{
			account.setBalance(newBalance);
		}
		getHibernateTemplate().update(account);
	}
	public void deleteAccount(int accountNumber)
	{
		Account account = getHibernateTemplate().get(Account.class, accountNumber);
		if(account != null)
			getHibernateTemplate().delete(account);
	}
	public List<Account> getAllAccounts()
	{
		return getHibernateTemplate().find("from Account");
	}
}
