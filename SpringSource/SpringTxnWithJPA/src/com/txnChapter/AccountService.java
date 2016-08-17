package com.txnChapter;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountService extends JpaDaoSupport
{
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void deposit(int accountNumber,double amount)
	{
		Account acc = (Account)getJpaTemplate().find(Account.class, accountNumber);
		acc.setBalance(acc.getBalance() + amount);
		getJpaTemplate().merge(acc);
		getJpaTemplate().persist(new Statement(accountNumber,"Deposit",amount));
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int accountNumber,double amount)
	{
		Account acc = (Account)getJpaTemplate().find(Account.class, accountNumber);
		acc.setBalance(acc.getBalance() - amount);
		getJpaTemplate().merge(acc);
		getJpaTemplate().persist(new Statement(accountNumber,"Withdraw",amount));
	}
}
