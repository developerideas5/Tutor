package com.jmxChapter;

import java.util.Vector;

public class Stack
{
	private Vector<String> items = new Vector<String>();
	
	public int getSize() 
	{
		return items.size();
	}
	public String popItem()
	{
		if(items.size() != 0)
		{
			String item = items.elementAt(items.size() - 1);
			items.remove(item);
			return item;
		}
		return "Stack is empty";
	}

	public void pushItem(String item) 
	{
		items.add(item);
	}

	public void empty() 
	{
		items.clear();
	}
}

