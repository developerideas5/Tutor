import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.stream.StreamResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.oxm.Marshaller;

import com.xstreamWithSpring.Book;
import com.xstreamWithSpring.Catalog;

public class Client 
{
	public static void main(String[] args)throws IOException 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Marshaller marshaller = (Marshaller)context.getBean("xstreamMarshallerBean");
		Catalog catalog = new Catalog();
		catalog.setId(101);
		
		Book book1 = new Book();
		book1.setTitle("XYZ");
		book1.setPrice(2345);
		book1.setAuthor("ABC");
		catalog.addBook(book1);
		
		Book book2 = new Book();
		book2.setTitle("XYZ2");
		book2.setPrice(100);
		book2.setAuthor("CDE");
		catalog.addBook(book2);
		
		marshaller.marshal(catalog, new StreamResult(new FileWriter("catalog.xml")));
		System.out.println("Created Successfully");
	}
}
