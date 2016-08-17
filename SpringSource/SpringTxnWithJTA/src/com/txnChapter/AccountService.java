package com.txnChapter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountService 
{
	private JdbcTemplate accountsTemplate;
	private JdbcTemplate statementsTemplate;
	
	public void setAccountsTemplate(JdbcTemplate accountsTemplate) {
		this.accountsTemplate = accountsTemplate;
	}
	public void setStatementsTemplate(JdbcTemplate statementsTemplate) {
		this.statementsTemplate = statementsTemplate;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deposit(int accountNumber,double amount)
	{
		accountsTemplate.update("update accounts set balance=balance+" + amount + " where account_number=" + accountNumber);
		statementsTemplate.execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Deposit')");
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int accountNumber,double amount)
	{
		accountsTemplate.update("update accounts set balance=balance-" + amount + " where account_number=" + accountNumber);
		statementsTemplate.execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Withdrawsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss')");
	}
}
