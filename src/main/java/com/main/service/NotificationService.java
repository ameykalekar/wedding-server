/**
 * 
 */
package com.main.service;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Service;
/**
 * @author admin
 *
 */

@Service
public class NotificationService {
	 private static VelocityEngine velocityEngine= new VelocityEngine();
public void sendNotification(Mail mail) {
	  
	  velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	  velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	  velocityEngine.init();
	  Template template = velocityEngine.getTemplate("velocity/" + mail.getTemplateName());

	  
	  VelocityContext velocityContext = new VelocityContext();
	  
	  mail.getValues().forEach( (key,value) -> {
		  
		  velocityContext.put(key, value);
	  });
	  
	  StringWriter stringWriter = new StringWriter();
	  
	  template.merge(velocityContext, stringWriter);
	final String username = mail.getMailFrom();
	final String password = mail.getMailPassWord();

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mail.getMailTo()));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("sagarthakare1@gmail.com"));
		message.setSubject(mail.getMailSubject());
		MimeMultipart multipart = new MimeMultipart("related");
		  BodyPart emailbodypart = new MimeBodyPart();
		emailbodypart.setContent(stringWriter.toString(), "text/html");
		multipart.addBodyPart(emailbodypart);
		message.setContent(multipart);
		Transport.send(message);

		System.out.println("Mail Sent Succcessfully");

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}

		
	}

	
/*

		public static void main(String[] args) {

			
			 Mail mail = new Mail();
			  mail.setMailFrom("from@gmail.com");
			  mail.setMailTo("to@gmail.com");
			  mail.setMailSubject("Subject - Send Email using Spring Velocity Template");
			  mail.setTemplateName("login.vm");
			  
			  velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			  velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			  velocityEngine.init();
			  Template template = velocityEngine.getTemplate("velocity/" + mail.getTemplateName());

			  
			  VelocityContext velocityContext = new VelocityContext();
			  velocityContext.put("firstName", "Yashwant");
			  velocityContext.put("lastName", "Chavan");
			  velocityContext.put("location", "Pune");
			  velocityContext.put("username", "abc@gmail.com");
			  velocityContext.put("password", "asdfasdf");
			  
			  
			 
			  StringWriter stringWriter = new StringWriter();
			  
			  template.merge(velocityContext, stringWriter);
			final String username = "letsmakemymoney@gmail.com";
			final String password = "Unlock@66";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("letsmakemymoney@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("sagarthakare1@gmail.com"));
				message.setSubject("Testing Subject");
				MimeMultipart multipart = new MimeMultipart("related");
				  BodyPart emailbodypart = new MimeBodyPart();
				emailbodypart.setContent(stringWriter.toString(), "text/html");
				multipart.addBodyPart(emailbodypart);
				message.setContent(multipart);
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}*/
	}


