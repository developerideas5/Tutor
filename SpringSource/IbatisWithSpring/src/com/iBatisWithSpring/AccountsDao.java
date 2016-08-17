package com.iBatisWithSpring;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AccountsDao extends SqlMapClientDaoSupport
{
	public void createAccount(int accountNumber,String owner,double balance)
	{
		getSqlMapClientTemplate().insert("createAccount", new Account(accountNumber,owner,balance));
	}
	public Account getAccount(int accountNumber)
	{
		return (Account)getSqlMapClientTemplate().queryForObject("getAccount", accountNumber);
	}
	public void deleteAccount(int accountNumber)
	{
		getSqlMapClientTemplate().delete("deleteAccount", accountNumber);
	}
	public void updateBalance(int accountNumber,double newBalance)
	{
		Account acc = getAccount(accountNumber);
		acc.setBalance(newBalance);
		getSqlMapClientTemplate().update("modifyAccountBalance", acc);
	}
	public List<Account> getAllAccounts()
	{
		return getSqlMapClientTemplate().queryForList("getAllAccounts");
	}

}
