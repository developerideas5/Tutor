import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.beans.Door;

public class DoorClient 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Door door = context.getBean("doorBean",Door.class);
		
		door.open();
		door.close();
	}
}
