import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jmxChapter.IStack;


public class MainClient 
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("client.xml");
		IStack stack = (IStack)context.getBean("stackBean");
		stack.pushItem("A");
		System.out.println(stack.getSize());
		
		MBeanServerConnection conn = (MBeanServerConnection)context.getBean("mbeanServerConnectionBean");
		
		
		conn.invoke(new ObjectName("DataStructure:Name=Stack"), "pushItem",new Object[]{"A"},new String[]{"java.lang.String"});
		int size = (Integer)conn.getAttribute(new ObjectName("DataStructure:Name=Stack"), "Size");
		System.out.println(size);
		
		
/*		ArrayList<MBeanServer> mbeanServers = MBeanServerFactory.findMBeanServer(null);
		System.out.println(mbeanServers.size());
		Iterator<MBeanServer> itr = mbeanServers.iterator();
		MBeanServer myDomainServer = null;
		while(itr.hasNext())
		{
			MBeanServer temp = itr.next();
			if("MyDomain".equals(temp.getDefaultDomain()))
			{
				myDomainServer = temp;
				break;
			}
		}
		System.out.println(myDomainServer);
		if(myDomainServer != null)
		{
			 ObjectInstance inst = myDomainServer.getObjectInstance(new ObjectName("DataStructure:name=Stack"));
			 System.out.println(inst);
			 
		}*/
	}
}
