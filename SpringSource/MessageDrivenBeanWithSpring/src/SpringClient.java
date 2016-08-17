import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class SpringClient 
{
	public static void main(String[] args) 
	{
		try
		{
			InitialContext cnt = new InitialContext();
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) cnt.lookup("ConnectionFactory");
			QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
			QueueSession senderSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); //false for transacted
			Queue stockQueue = (Queue) cnt.lookup("queue/StockQueue");
			QueueSender sender = senderSession.createSender(stockQueue);
			queueConnection.start();

			double temperature = 0.0;
			while(true)
			{
				temperature = Math.random() * 100;
				System.out.println("Temperature of Chennai : " + temperature);
					
				TextMessage textMessage = senderSession.createTextMessage();
				textMessage.setText("Temperature of Chennai : " + temperature);
				sender.send(textMessage);
				Thread.sleep(5000);
			}		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

	}
}
