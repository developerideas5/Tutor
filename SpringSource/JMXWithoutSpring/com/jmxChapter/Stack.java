package com.jmxChapter;

import java.util.Vector;

public class Stack implements StackMBean
{
	private Vector<String> items = new Vector<String>();
	
	@Override
	public int getSize() 
	{
		return items.size();
	}

	@Override
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

	@Override
	public void pushItem(String item) 
	{
		items.add(item);
	}

	@Override
	public void empty() 
	{
		items.clear();
	}

}
