package com.txnChapter;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountService extends HibernateDaoSupport
{
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void deposit(int accountNumber,double amount)
	{
		Account acc = (Account)getHibernateTemplate().get(Account.class, accountNumber);
		acc.setBalance(acc.getBalance() + amount);
		getHibernateTemplate().update(acc);
		getHibernateTemplate().save(new Statement(accountNumber,"Deposit",amount));
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int accountNumber,double amount)
	{
		Account acc = (Account)getHibernateTemplate().get(Account.class, accountNumber);
		acc.setBalance(acc.getBalance() - amount);
		getHibernateTemplate().update(acc);
		getHibernateTemplate().save(new Statement(accountNumber,"Withdraw",amount));
	}
}
