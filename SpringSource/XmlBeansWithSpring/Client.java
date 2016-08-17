import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.stream.StreamResult;
import noNamespace.BookType;
import noNamespace.CatalogDocument;
import noNamespace.CatalogDocument.Catalog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.oxm.Marshaller;


public class Client 
{
	public static void main(String[] args)throws IOException 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Marshaller marshaller = (Marshaller)context.getBean("xmlBeansMarshallerBean");

		CatalogDocument catalogDoc =  CatalogDocument.Factory.newInstance();
		Catalog catalog = catalogDoc.addNewCatalog();
		catalog.setId(8973);
		
		BookType book1 = catalog.addNewBook();
		book1.setTitle("XYZ");
		book1.setAuthor("ABC");
		book1.setPrice(2345);
		
		BookType book2 = catalog.addNewBook();
		book2.setTitle("XYZ2");
		book2.setAuthor("CDE");
		book2.setPrice(100);
		
		catalog.setBookArray(new BookType[]{book1,book2});
		catalogDoc.setCatalog(catalog);
		
		FileWriter fw = new FileWriter("catalog.xml");
		marshaller.marshal(catalogDoc,new StreamResult(fw));
		fw.close();
		System.out.println("Created Successfully");
		
	}
}
