package com.aopChapter.usingAspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("com/aopChapter/usingAspectJ/beans.xml");
		Programmer prog = (Programmer) context.getBean("programmerBean");
		/*System.out.println("***Class generated : " + prog.getClass().getName());
		System.out.println("***Base Class is : " + prog.getClass().getSuperclass().getName());*/
	
		System.out.println();
		prog.code();
		prog.runTestCases();
		prog.modifyUseCases();
	}
}
