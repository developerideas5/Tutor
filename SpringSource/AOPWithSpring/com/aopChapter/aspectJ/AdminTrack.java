package com.aopChapter.aspectJ;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class AdminTrack
{
	public void logToFile(JoinPoint jp)
	{
		System.out.println("Before calling "  + jp.getSignature() + " at Date Time : " + new Date());
	}
	
	public void sendMail(JoinPoint jp)
	{
		System.out.println("After calling "  + jp.getSignature() + " at Date Time : " + new Date());
	}
}
