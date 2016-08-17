package com.txnChapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account
{
	@Id
	@Column(name="account_number")
	private int accountNumber;
	@Column(name="owner")
	private String owner;
	@Column(name="balance")
	private double balance;
	
	public Account() {}
	
	public Account(int accountNumber, String owner, double balance) 
	{
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
