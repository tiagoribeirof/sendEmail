package com.devservice.sendEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void send(String name, String recipientEmail){
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com", "springboot"));
			email.setSSLOnConnect(true);

			email.setFrom("springbootalura@gmail.com");
			email.setSubject("You were envited by Vip List");
			email.setMsg("Hello " + name + ". You were invited by Vip List.");
			email.addTo(recipientEmail);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
