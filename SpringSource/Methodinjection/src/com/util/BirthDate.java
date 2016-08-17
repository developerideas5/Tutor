package com.util;

public class BirthDate implements MyDate
{
	private int date;
	private int month;
	private int year;

	public BirthDate()
	{ 
		System.out.println("inside default constructor BirthDate()");	
	}

	public int getMonth()
	{
		return this.month;
	}
	public int getDate()
	{
		return this.date;
	}
	public int getYear()
	{
		return this.year;
	}


	public void setMonth(int month)
	{
		this.month = month;
	}

    public void setDate(int date)
	{
		this.date = date;
	}

    public void setYear(int year)
	{
		this.year = year;
	}

	public String toString()
	{
		return "Date: " + getDate() + "Month: " + getMonth() + "Year: " + getYear();  
	}
}
