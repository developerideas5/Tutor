import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.jdbcWithSpring.Employee;
import com.jdbcWithSpring.EmployeesDao;

public class JdbcClient 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		EmployeesDao empDao = context.getBean("employeesDaoBean",EmployeesDao.class);
		empDao.addEmployee(101, "Sam", "Thomas", "Systems Engineer");
		empDao.addEmployee(102, "Ram", "Karan", "Business Analyst");
		empDao.addEmployee(103, "Suchitra", "Jain", "Test Engineer");
		System.out.println("**Created Employees***");
		
		System.out.println("Total Number of Employees : " + empDao.getEmployeeCount());
		System.out.println("***List of Employees***");
		List<Employee> employees = empDao.getAllEmployees();
		for (int i = 0; i < employees.size(); i++) 
		{
			Employee employee = employees.get(i);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " : " + employee.getDesignation());
		}
		System.out.println("***Deleting an employee***");
		empDao.deleteEmployee(102);
		System.out.println("Total Number of Employees after deletion: " + empDao.getEmployeeCount());
	}
}
