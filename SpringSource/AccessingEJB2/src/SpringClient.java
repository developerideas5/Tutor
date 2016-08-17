import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ejbChapter.WeatherService;

public class SpringClient 
{
	public static void main(String[] args) throws RemoteException
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		WeatherService weatherService = (WeatherService)context.getBean("weatherServiceBean");
		System.out.println(weatherService.getTemperature("Chennai"));
	}
}
