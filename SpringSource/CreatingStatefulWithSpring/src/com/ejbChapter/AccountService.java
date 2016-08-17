package com.ejbChapter;

public interface AccountService
{
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
}
