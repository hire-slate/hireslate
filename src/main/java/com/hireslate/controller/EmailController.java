package com.hireslate.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/send")
public class EmailController {

	@Value("${aws.accessToken}")
	private String accessToken;
	@Value("${aws.secretKey}")
	private String secretKey;
	@Value("${aws.bucket}")
	private String bucket1;
	@Value("${aws.url}")
	private String awsUrl;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String sendMail() throws AddressException, MessagingException, IOException {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		   
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("hireslate@gmail.com", "hesoyamtrojan@123");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("hireslate@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("17ce010@charusat.edu.in"));
		   msg.setSubject("TEST SUBJECT");
		   msg.setContent("Wassup again broooooo", "text/html");
		   msg.setSentDate(new Date());

		   Transport.send(msg);  
		   return "mail sent";
	}
	
	@RequestMapping(value="/aws",method=RequestMethod.GET)
	public String testaws() {
		return bucket1;
	}
}