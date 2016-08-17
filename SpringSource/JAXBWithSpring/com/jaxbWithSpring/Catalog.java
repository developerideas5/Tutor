package com.jaxbWithSpring;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Catalog")
public class Catalog
{
	private int id;
		
	private List<Book> books = new ArrayList<Book>();
	
	@XmlAttribute(name="id")
	public int getId() {
		return id;
	}
	
	public void addBook(Book book)
	{
		books.add(book);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(name="Book",type=Book.class)
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
