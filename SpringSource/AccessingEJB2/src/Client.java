import javax.naming.InitialContext;

import com.ejbChapter.WeatherReporter;
import com.ejbChapter.WeatherReporterHome;

public class Client 
{
	public static void main(String[] args)throws Exception 
	{
		InitialContext context = new InitialContext();
		WeatherReporterHome home = (WeatherReporterHome) context.lookup("CoolReporter");
		WeatherReporter reporter = home.create();
		System.out.println(reporter.getTemperature("Chennai"));
	}
}
