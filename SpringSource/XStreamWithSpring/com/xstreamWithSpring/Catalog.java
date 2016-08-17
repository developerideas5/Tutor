package com.xstreamWithSpring;

import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Catalog")
public class Catalog 
{
	@XStreamAsAttribute()
	private int id;
	
	@XStreamImplicit(itemFieldName="Book")
	private List<Book> books = new ArrayList<Book>();
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
