package com.jdbcWithSpring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class EmployeesDao extends SimpleJdbcDaoSupport 
{
	public void addEmployee(int id,String fName,String lName,String desg)
	{
		getSimpleJdbcTemplate().update("insert into employees values(?,?,?,?)", id,fName,lName,desg);
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = null;
		employees = getSimpleJdbcTemplate().query("select * from employees", 
				new RowMapper<Employee>() 
				{
					@Override
					public Employee mapRow(ResultSet rs, int rowNum)throws SQLException 
					{
						Employee emp = new Employee();
						emp.setId(rs.getInt("id"));
						emp.setFirstName(rs.getString("first_name"));
						emp.setLastName(rs.getString("last_name"));
						emp.setDesignation(rs.getString("designation"));
						return emp;
					}
		});
		return employees;
	}
	public void deleteEmployee(int id)
	{
		getSimpleJdbcTemplate().update("delete from employees where id=?", id);
	}
	public int getEmployeeCount()
	{
		return getSimpleJdbcTemplate().queryForInt("select count(*) from employees");
	}
}
