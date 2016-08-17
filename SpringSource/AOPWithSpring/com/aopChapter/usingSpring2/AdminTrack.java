package com.aopChapter.usingSpring2;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

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
	
	public void placeAnUrgentCall(Exception ex)
	{
		System.out.println("Error!! " + ex.getMessage());
	}
	
	public Object canBuild(ProceedingJoinPoint pjp) throws Throwable 
	{
		Programmer prog = (Programmer)pjp.getTarget();
		if(!"Team Lead".equals(prog.getCategory()))
		{
			System.out.println("Build Request denied!!");
			return null;
		}
		return pjp.proceed();
	}
}
