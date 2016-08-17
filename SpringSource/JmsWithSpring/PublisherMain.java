import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jmsChapter.StockPublisher5;

public class PublisherMain 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans3.xml");
		StockPublisher5 publisher = (StockPublisher5)context.getBean("stockPublisherBean");
		double price = 0.0;
		while(true)
		{
			price = Math.random() * 1000;
			publisher.publish("ABC",price);
			try 
			{
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
