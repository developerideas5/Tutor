import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main 
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans2.xml");
		MBeanServer mbeanServer = (MBeanServer)context.getBean("mbeanServerBean");
		MBeanInfo mbeanInfo = mbeanServer.getMBeanInfo(new ObjectName("DataStructure:name=Stack"));
		MBeanOperationInfo[] operations = mbeanInfo.getOperations();
		for (int i = 0; i < operations.length; i++) 
		{
			System.out.println(operations[i].getName());
		}
		
		/*HtmlAdaptorServer htmlServer = (HtmlAdaptorServer)context.getBean("htmlServerBean");
		htmlServer.start();*/
	}
}
