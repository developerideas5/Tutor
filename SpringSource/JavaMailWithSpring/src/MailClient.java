import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.javaMailWithSpring.MailHelper;

public class MailClient 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/beans.xml");
		MailHelper mailHelper = context.getBean("mailHelperBean",MailHelper.class);
		mailHelper.sendMail();
		System.out.println("Mail sent successfully");
		
		String from = "prabhu@durasoftindia.com"; 
		String to = "iamprabhu@yahoo.com";

		mailHelper.sendMail(from,to,"Test Mail with attachments","This is a test mail with attachments","Sample File","C:/debug.log");
		System.out.println("Mailed attachments successfully");
	}
}
