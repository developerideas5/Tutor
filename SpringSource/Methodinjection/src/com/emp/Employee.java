package com.emp;

import com.util.MyDate;

public class Employee 
{
	private String firstname="dude";
	private String lastname="dude";
	private MyDate birthdate=null;
	private String info;

	public Employee()
	{
		System.out.println("inside default constructor of Employee()");
	}

    
	public void setFirstname(String name)
	{
		firstname = name;
	}

	public void setLastname(String name)
	{
		lastname = name;
	}

    public void setBirthdate(MyDate bday)
	{
		birthdate = bday;
	}

    public void setInfo(String info)
    {
    	this.info = info;
    }
    
    public String getInfo()
    {
    	return this.info;
    }
    
    public void printDiscription()
    {
    	System.out.println("The Detailed info about an Employee is :: " + getInfo());
    }

	public String toString()
	{
		return "FullName :: "+ this.firstname + this.lastname + "\n" + "BirthDate :: " + this.birthdate.toString();
	}

	
}