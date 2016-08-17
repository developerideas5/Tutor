package com.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:hello.xml");
		HelloWorld obj=(HelloWorld)context.getBean("hello");
		obj.toString();
		
	}

}
