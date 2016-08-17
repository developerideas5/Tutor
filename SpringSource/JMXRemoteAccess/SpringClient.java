import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringClient 
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("server.xml");
	}
}
