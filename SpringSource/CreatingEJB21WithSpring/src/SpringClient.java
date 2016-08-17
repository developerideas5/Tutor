import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ejbChapter.WeatherReporter;

public class SpringClient 
{
	public static void main(String[] args) throws RemoteException
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		
		WeatherReporter reporter = (WeatherReporter)context.getBean("weatherReporterBean");
		System.out.println(reporter.getTemperature("Mumbai"));
	}
}
