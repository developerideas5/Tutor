package com.aopChapter.usingAspectJ;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdminTrack
{
	@Pointcut("execution(void Programmer.*(..))")
	public void logToFilePointcut()
	{}
	
	@Pointcut("execution(* Programmer.*(..))")
	public void sendMailPointcut()
	{}
	
	@Before("logToFilePointcut()")
	public void logToFile(JoinPoint jp)
	{
		System.out.println("Before calling "  + jp.getSignature() + " at Date Time : " + new Date());
	}
	
	@AfterReturning("sendMailPointcut()")
	public void sendMail(JoinPoint jp)
	{
		System.out.println("After calling "  + jp.getSignature() + " at Date Time : " + new Date());
	}
	
	@AfterThrowing(pointcut="execution(* *.build(..))",throwing="ex")
	public void placeAnUrgentCall(Exception ex)
	{
		System.out.println("Error!! " + ex.getMessage());
	}
	
	@Around("execution(* *.modifyUseCases(..))")
	public Object canModifyUseCases(ProceedingJoinPoint pjp) throws Throwable 
	{
		Programmer prog = (Programmer)pjp.getTarget();
		if(!"Module Lead".equals(prog.getCategory()))
		{
			System.out.println("Cannot modify use cases!!");
			return null;
		}
		return pjp.proceed();
}

}
