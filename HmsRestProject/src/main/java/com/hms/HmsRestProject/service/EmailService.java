package com.hms.HmsRestProject.service;

import javax.mail.MessagingException;

public interface EmailService {
	boolean sendEmail(String to, String subject, String text) throws MessagingException;
}
