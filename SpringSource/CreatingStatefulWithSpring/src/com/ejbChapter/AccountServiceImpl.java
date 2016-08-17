package com.ejbChapter;

public class AccountServiceImpl implements AccountService
{
	private double balance;
	
	public void deposit(double amount) 
	{
		balance += amount;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void withdraw(double amount) 
	{
		balance -= amount;
	}
}
