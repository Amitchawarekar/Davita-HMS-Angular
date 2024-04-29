package com.hms.HmsRestProject.serviceImpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.hms.HmsRestProject.service.EmailService;

@Service
public class JavaMailEmailService implements EmailService {

	@Override
	public boolean sendEmail(String to, String subject, String body) {

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		String username = "tanmaypatil0714@gmail.com";
		String password = "xlvdwcxtqzvfcoan";

		System.out.println("transport");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});
		boolean flag = false;
		try {

			Message message = new MimeMessage(session);

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject(subject);

			message.setText(body);

			Transport.send(message, username, password);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
