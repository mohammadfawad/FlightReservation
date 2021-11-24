package com.passengerManagement.com.flightReservation.Utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	private static final Logger emailLOGGER =LoggerFactory.getLogger(EmailUtility.class);
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendItinerary(String receiverEmail, String filePath) {
		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(receiverEmail);
			mimeMessageHelper.setSubject("Itinerary Flight Document");
			mimeMessageHelper.setText("Itinerary Document is Attached, Find And Download Attachment!.");
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			this.javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			EmailUtility.emailLOGGER.info("Method:sendItinerary()->Email Sending Exception!"+ e.toString());
			e.printStackTrace();
		}
	}
}
