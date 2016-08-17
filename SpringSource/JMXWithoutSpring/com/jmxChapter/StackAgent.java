package com.jmxChapter;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class StackAgent 
{
	public static void main(String[] args) throws Exception
	{
		ObjectName name = new ObjectName("DataStructure:type=Stack");
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		server.createMBean("com.jmxChapter.Stack", name);
		HtmlAdaptorServer htmlServer = new HtmlAdaptorServer(9000);
		server.registerMBean(htmlServer, new ObjectName("Adaptor:name=html"));
		htmlServer.start();
	}
}
