package com.passengerManagement.flightReservation.Utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	@Value("${com.passengerManagement.flightReservation.itinerary.emailSubject}")
	private String EMAIL_SUBJECT;
	@Value("${com.passengerManagement.flightReservation.itinerary.emailBody}")
	private String EMAIL_BODY;
	private static final Logger emailLOGGER =LoggerFactory.getLogger(EmailUtility.class);
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendItinerary(String receiverEmail, String filePath) {
		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(receiverEmail);
			mimeMessageHelper.setSubject(this.EMAIL_SUBJECT);
			mimeMessageHelper.setText(this.EMAIL_BODY);
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			this.javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			EmailUtility.emailLOGGER.info("Method:sendItinerary()->Email Sending Exception!"+ e.toString());
			e.printStackTrace();
		}
	}
}
