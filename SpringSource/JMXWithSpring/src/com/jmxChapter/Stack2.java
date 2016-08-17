package com.jmxChapter;

import java.util.Vector;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName="DataStructure:name=Stack")
public class Stack2
{
	private Vector<String> items = new Vector<String>();
	
	@ManagedAttribute
	public int getSize() 
	{
		return items.size();
	}

	@ManagedOperation
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
	
	@ManagedOperation
	public void pushItem(String item) 
	{
		items.add(item);
	}

	@ManagedOperation
	public void empty() 
	{
		items.clear();
	}
}

