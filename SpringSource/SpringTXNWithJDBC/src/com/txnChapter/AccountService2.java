package com.txnChapter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class AccountService2 extends JdbcDaoSupport
{
	public void deposit(int accountNumber,double amount)
	{
		getJdbcTemplate().update("update accounts set balance=balance+" + amount + " where account_number=" + accountNumber);
		getJdbcTemplate().execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Deposit')");
	}
	public void withdraw(int accountNumber,double amount)
	{
		getJdbcTemplate().update("update accounts set balance=balance-" + amount + " where account_number=" + accountNumber);
		getJdbcTemplate().execute("insrt into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Withdraw')");
	}
}
