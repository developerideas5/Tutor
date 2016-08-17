import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.txnChapter.AccountService;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		AccountService accService = (AccountService) context.getBean("accountServiceBean");
		System.out.println(accService.getClass());
		//accService.deposit(1001, 1000);
		accService.withdraw(1001, 100);
	}
}
