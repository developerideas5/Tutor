import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ejbChapter.Account;
import com.ejbChapter.AccountHome;

public class SpringClient 
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		AccountHome home = (AccountHome)context.getBean("accountHomeBean");
		Account account = home.create();
		account.deposit(100);
		System.out.println(account.getBalance());
		System.in.read();
		account.deposit(100);
		System.out.println(account.getBalance());
	}
}
