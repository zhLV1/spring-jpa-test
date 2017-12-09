package com.test.springjpatest.mail;

public interface MailService {

	void sendSimpleMail(String to, String subject, String content);
}
