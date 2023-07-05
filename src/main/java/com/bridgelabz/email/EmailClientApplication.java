package com.bridgelabz.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailClientApplication {
	@Autowired
	private EmailSenderService service;
	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		service.sendEmailWithAttachment("smartsourav33@gmail.com",
				"This is the Email Body with attachment",
				"This email has attachment",
		"E:/GIF.mp4");

	}

}
