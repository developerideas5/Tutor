package com.javaMailWithSpring;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailHelper 
{
	private SimpleMailMessage mailMessage;
	private JavaMailSender mailSender;
	
	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail()
	{
		mailSender.send(mailMessage);
	}
	
	public void sendMail(String from,String to,String subject,String body,String fileName,String location)
	{
		mailSender.send(new MessageBuilder(from,to,subject,body,fileName,location));
	}
}
