import com.jmsChapter.StockReceiver;

public class ReceiverMain 
{
	public static void main(String[] args) 
	{
		StockReceiver receiver = new StockReceiver();
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
