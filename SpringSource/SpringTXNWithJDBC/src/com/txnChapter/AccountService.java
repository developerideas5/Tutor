package com.txnChapter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountService extends JdbcDaoSupport
{
	@Transactional(propagation=Propagation.REQUIRED)
	public void deposit(int accountNumber,double amount)
	{
		getJdbcTemplate().update("update accounts set balance=balance+" + amount + " where account_number=" + accountNumber);
		getJdbcTemplate().execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Deposit')");
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int accountNumber,double amount)
	{
		getJdbcTemplate().update("update accounts set balance=balance-" + amount + " where account_number=" + accountNumber);
		getJdbcTemplate().execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Withdraw')");
	}
}
