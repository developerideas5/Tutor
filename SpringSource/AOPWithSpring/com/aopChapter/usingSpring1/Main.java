package com.aopChapter.usingSpring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("com/aopChapter/usingSpring1/beans.xml");
		Programmer prog = (Programmer)context.getBean("programmerBean");
		prog.code();
		prog.runTestCases();
		prog.build();
	}
}
