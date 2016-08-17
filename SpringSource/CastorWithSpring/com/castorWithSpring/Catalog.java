package com.castorWithSpring;

import java.util.ArrayList;
import java.util.List;

public class Catalog 
{
	private int id;
	
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
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	public List<Book> getBooks() 
	{
		return books;
	}
}
