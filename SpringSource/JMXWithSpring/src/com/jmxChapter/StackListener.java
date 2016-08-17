package com.jmxChapter;

import javax.management.Notification;
import javax.management.NotificationListener;

public class StackListener implements NotificationListener
{
	public void handleNotification(Notification notification, Object handback) 
	{
		System.out.println(notification.getMessage());
	}
}
