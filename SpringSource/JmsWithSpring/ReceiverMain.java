import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jmsChapter.StockReceiver5;

public class ReceiverMain
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans4.xml");
		StockReceiver5 receiver = (StockReceiver5)context.getBean("stockReceiverBean");

		while(true)
		{
			receiver.receive();
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
