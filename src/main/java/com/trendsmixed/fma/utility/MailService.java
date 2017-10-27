package com.trendsmixed.fma.utility;

import com.trendsmixed.fma.module.mailconfiguration.MailConfiguration;
import com.trendsmixed.fma.module.mailconfiguration.MailConfigurationService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thilina
 */
@Service
public class MailService {

    @Autowired
    private MailConfigurationService mailConfigurationService;

    public void send(String email, String subject, String message) {
        List<String> emailList = new ArrayList<>();
        emailList.add(email);
        send(emailList, subject, message);
    }

    public void send(List<String> emailList, String subject, String message) {
        new Thread(() -> {
            try {
                Properties mailServerProperties;
                Session getMailSession;
                MimeMessage generateMailMessage;

                // should be updated to get only default configuration
                MailConfiguration mailConfiguration;
                Iterable<MailConfiguration> mailConfigurations = mailConfigurationService.findAll();
                if (mailConfigurations.iterator().hasNext()) {
                    mailConfiguration = mailConfigurations.iterator().next();
                } else {
                    System.out.println("Mail Configurations not found");
                    return;
                }

                // Step1
                System.out.println("\n 1st ===> setup Mail Server Properties..");
                mailServerProperties = System.getProperties();
                mailServerProperties.put("mail.smtp.port", mailConfiguration.getPort());//"587"
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
                transport.connect(mailConfiguration.getHost(), mailConfiguration.getUser(), mailConfiguration.getPassword());//("smtp.yourMailServer.com", "emailAddressHere", "passwordHere")

                transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                transport.close();
                System.out.println("\n\n 3rd ===> Mail Sent");
            } catch (UnsupportedEncodingException | MessagingException ex) {
                Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }).start();
    }
}
