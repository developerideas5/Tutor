package com.txnChapter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans3.xml");
		AccountService accService = (AccountService) context.getBean("accountServiceBean");
		accService.withdraw(1001, 2000);
	}
}
