/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.utility;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author thilina
 */
public class Mail {
//
//    public static void main(String args[]) throws AddressException, MessagingException, UnsupportedEncodingException {
//        generateAndSendEmail();
//        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
//    }
//
//    public static void generateAndSendEmail() throws AddressException, MessagingException, UnsupportedEncodingException {
//        Properties mailServerProperties;
//        Session getMailSession;
//        MimeMessage generateMailMessage;
//        // Step1
//        System.out.println("\n 1st ===> setup Mail Server Properties..");
//        mailServerProperties = System.getProperties();
//        mailServerProperties.put("mail.smtp.port", "587");
//        mailServerProperties.put("mail.smtp.auth", "true");
//        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//        System.out.println("Mail Server Properties have been setup successfully..");
//
//        // Step2
//        System.out.println("\n\n 2nd ===> get Mail Session..");
//        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
//        generateMailMessage = new MimeMessage(getMailSession);
//        generateMailMessage.setFrom(new InternetAddress("thilina.oss@otrwheel.com", "Thilina Ranathunga"));
////		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("thilina.oss@otrwheel.com"));
////		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("thilina.tss@trwlanka.com"));
//        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("r.thilina@gmail.com"));
//        generateMailMessage.setSubject("Greetings from OTR Lanka..");
//        String emailBody = "Test email by OTR System " + "<br><br> Regards, <br>Thilina Ranathunga";
//        generateMailMessage.setContent(emailBody, "text/html");
//        System.out.println("Mail Session has been created successfully..");
//
//        // Step3
//        System.out.println("\n\n 3rd ===> Get Session and Send mail");
//        Transport transport = getMailSession.getTransport("smtp");
//
//        // Enter your correct gmail UserID and Password
//        // if you have 2FA enabled then provide App Specific Password
//        transport.connect("smtp.gmail.com", "<----- Your GMAIL ID ----->", "<----- Your GMAIL PASSWORD ----->");
//
//        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//        transport.close();
//    }

    public void send(String email, String subject, String message) {
        List<String> emailList = new ArrayList<String>();
        emailList.add(email);
        send(emailList, subject, message);
    }

    public void send(List<String> emailList, String subject, String message) {
        new Thread(() -> {
            try {
                Properties mailServerProperties;
                Session getMailSession;
                MimeMessage generateMailMessage;
                // Step1
                System.out.println("\n 1st ===> setup Mail Server Properties..");
                mailServerProperties = System.getProperties();
                mailServerProperties.put("mail.smtp.port", "587");
                mailServerProperties.put("mail.smtp.auth", "true");
                mailServerProperties.put("mail.smtp.starttls.enable", "true");
                System.out.println("Mail Server Properties have been setup successfully..");

                // Step2
                System.out.println("\n\n 2nd ===> get Mail Session..");
                getMailSession = Session.getDefaultInstance(mailServerProperties, null);
                generateMailMessage = new MimeMessage(getMailSession);
                generateMailMessage.setFrom(new InternetAddress("admin.lanka@otrwheel.com", "System Administrator"));
                for (String email : emailList) {
                    generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                }
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("thilina.oss@otrwheel.com"));
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("thilina.tss@trwlanka.com"));
                generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("r.thilina@gmail.com"));
                generateMailMessage.setSubject(subject);
                String emailBody = message + "<br/><br/> Regards, <br/>System Administrator<br/><br/> -- Auto generated mail --";
                generateMailMessage.setContent(emailBody, "text/html");
                System.out.println("Mail Session has been created successfully..");

// Step3
                System.out.println("\n\n 3rd ===> Get Session and Send mail");
                Transport transport = getMailSession.getTransport("smtp");

// Enter your correct gmail UserID and Password
// if you have 2FA enabled then provide App Specific Password
                transport.connect("smtp.office365.com", "admin.lanka@otrwheel.com", "Kata9101");

                transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                transport.close();
                System.out.println("\n\n 3rd ===> Mail Sent");
            } catch (UnsupportedEncodingException | MessagingException ex) {
                Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }).start();
    }
}
