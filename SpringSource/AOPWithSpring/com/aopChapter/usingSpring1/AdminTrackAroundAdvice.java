package com.aopChapter.usingSpring1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdminTrackAroundAdvice implements MethodInterceptor
{
	public Object invoke(MethodInvocation invocation) throws Throwable 
	{
		if("build".equals(invocation.getMethod().getName()))
		{
			Programmer prog = (Programmer)invocation.getThis();
			if(!"Team Lead".equals(prog.getCategory()))
			{
				System.out.println("Build Request denied!!");
				return null;
			}
		}
		return invocation.proceed();
	}
}
