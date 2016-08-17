import com.jmsChapter.StockPublisher;

public class PublisherMain 
{
	public static void main(String[] args) 
	{
		StockPublisher publisher = new StockPublisher();
		double price = 0.0;
		while(true)
		{
			price = Math.random() * 1000;
			publisher.publish(price);
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
