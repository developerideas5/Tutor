import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.configuration.Person;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Person person1 = context.getBean(Person.class);
		System.out.println(person1 + ", " + person1.getCars().size());
		Person person2 = context.getBean(Person.class);
		System.out.println(person2 + ", " + person2.getCar());
	}
}
