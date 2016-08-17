import java.util.ArrayList;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Main 
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		MBeanServer mBeanServer = (MBeanServer)context.getBean("mbeanServerBean");
		HtmlAdaptorServer htmlServer = new HtmlAdaptorServer(9000);
		mBeanServer.registerMBean(htmlServer, new ObjectName("Adaptor:type=html"));
		htmlServer.start();
	}
}
