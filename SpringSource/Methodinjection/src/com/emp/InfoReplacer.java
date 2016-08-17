package com.emp;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class InfoReplacer implements MethodReplacer 
{

	public Object reimplement(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
	//	System.out.println(arg2.length);
		//System.out.println(arg2[0]);
		//System.out.println(arg2[1]);
		//System.out.println(arg1.getReturnType());
		return " not only technical skills but management skills as well";
	}

}
