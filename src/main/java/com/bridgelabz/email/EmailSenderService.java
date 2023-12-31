package com.bridgelabz.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.MidiMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("abhishek.magdum.07@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send ...");
    }

    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("abhishek.magdum.07@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource filesytem = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(filesytem.getFilename(),filesytem);
        mailSender.send(mimeMessage);
        System.out.println("Mail send .....");
    }
}
