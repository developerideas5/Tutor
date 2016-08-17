package com.txnChapter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


public class AccountService3 extends JdbcDaoSupport
{
	private TransactionTemplate txnTemplate;
	
	public void setTxnTemplate(TransactionTemplate txnTemplate) {
		this.txnTemplate = txnTemplate;
	}
	public void deposit(final int accountNumber,final double amount)
	{
		txnTemplate.execute(new TransactionCallback()
		{
			public Object doInTransaction(TransactionStatus status) 
			{
				try
				{
					getJdbcTemplate().update("update accounts set balance=balance+" + amount + " where account_number=" + accountNumber);
					getJdbcTemplate().execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Deposit')");
				}
				catch(Exception ex)
				{
					status.setRollbackOnly();
				}
				//Nothing to return
				return null;
			}
		});
	}
	public void withdraw(final int accountNumber,final double amount)
	{
		txnTemplate.execute(new TransactionCallback()
		{
			public Object doInTransaction(TransactionStatus status) 
			{
				try
				{
					getJdbcTemplate().update("update accounts set balance=balance-" + amount + " where account_number=" + accountNumber);
					getJdbcTemplate().execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Withdraw')");
				}
				catch(Exception ex)
				{
					status.setRollbackOnly();
				}
				//Nothing to return
				return null;
			}
		});
	}
}
