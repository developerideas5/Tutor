import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.txnChapter.AccountService2;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans4.xml");
		AccountService2 accService = (AccountService2) context.getBean("accountServiceBean");
		accService.deposit(1001, 1000);
		//accService.withdraw(1001, 100);
	}
}
