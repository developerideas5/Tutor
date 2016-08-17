package com.jpaWithSpring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AccountsClient 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		AccountsDao accountsDao = context.getBean("accountsDaoBean",AccountsDao.class);
		
		accountsDao.createAccount(110, "Ram", 1000);
		accountsDao.createAccount(111, "Sam", 2300);
		System.out.println("Accounts created");
		
		accountsDao.updateBalance(111, 1345);
		System.out.println("Account balance updated");
		
		accountsDao.deleteAccount(111);
		System.out.println("Account deleted");
		
		List<Account> accounts = accountsDao.getAllAccounts();
		for (int i = 0; i < accounts.size(); i++) 
		{
			Account acc = accounts.get(i);
			System.out.println(acc.getAccountNumber() + " : " + acc.getOwner() + " (" + acc.getBalance() + ")");
		}
	}
}
