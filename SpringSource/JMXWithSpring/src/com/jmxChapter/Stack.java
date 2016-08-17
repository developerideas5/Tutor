package com.jmxChapter;

import java.util.Vector;

import javax.management.Notification;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class Stack implements NotificationPublisherAware
{
	private NotificationPublisher notificationPublisher;
	@Override
	public void setNotificationPublisher(NotificationPublisher publisher) 
	{
		this.notificationPublisher = publisher;
	}

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
			Notification notification = new Notification("stack.size",this,0,"Size of the stack : " + items.size());
			notificationPublisher.sendNotification(notification);
			return item;
		}
		return "Stack is empty";
	}

	public void pushItem(String item) 
	{
		items.add(item);
		Notification notification = new Notification("stack.size",this,0,"Size of the stack : " + items.size());
		notificationPublisher.sendNotification(notification);
	}

	public void empty() 
	{
		items.clear();
	}
}

