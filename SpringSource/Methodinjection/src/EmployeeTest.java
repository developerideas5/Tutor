
import java.io.FileInputStream;



import sun.misc.Resource;

import com.emp.Employee;

public class EmployeeTest
{
	public static void main(String[] args) 
	{
		try
		{
			//following line is traditional way of creating an Employee
			//Employee emp = new Employee("Amit");

			Resource resource = new FileSystemResource(".\\config\\employees.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
            Employee emp = (Employee) factory.getBean("employee");
           

			System.out.println("The Details of created Employee is :: "+ emp);
			
			emp.printDiscription();

		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}
