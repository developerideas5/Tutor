package com.javaMailWithSpring;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MessageBuilder implements MimeMessagePreparator
{
	private String from;
	private String to;
	private String body;
	private String subject;
	private String fileName;
	private String location;
	
	public MessageBuilder(String from,String to,String subject, String body,String fileName,String location)
	{
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.fileName = fileName;
		this.location = location;
	}
	
	public void prepare(MimeMessage msg) throws Exception 
	{
		MimeMessageHelper helper = new MimeMessageHelper(msg,true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.addAttachment(fileName,new File(location));
		helper.setText(body);
	}
}
