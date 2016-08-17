package com.jmxChapter;

public interface IStack 
{
	void empty();
	int getSize();
	void pushItem(String item);
	String popItem();
}
