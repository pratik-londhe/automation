package utils;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

public class EmailUtils {

    protected static final Map<String, String> configMap = null;
    private static final Logger logger = Logger.getLogger(EmailUtils.class);

    private EmailUtils() {
    }

    public static void sendEmail(int passedTestScript, int failedTestScript, int skippedTestScript, String exeSuiteName, String buildNumber) {
        // Create object of Property file
        int total = passedTestScript + failedTestScript + skippedTestScript;
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nt.1@forgeahead.io", "noodle@2018");
            }
        });
        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);// Set the from address
            message.setFrom(new InternetAddress("nt.1@forgeahead.io"));

            // Set the recipient address
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("pratik.londhe@forgeahead.io"));

            // Add the subject link
            message.setSubject("Project | " + exeSuiteName + " | " + buildNumber + " | " + getDate());
            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("Hello All," + "\n\nPlease find below sanity automation test execution summary. Refer attached execution report for more details." + "\n\n Total Test Script         :- " + total + "\n Passed Test Script    :- " + passedTestScript + "\n Failed Test Script      :- " + failedTestScript + "\n Skipped Test Script   :- " + skippedTestScript + "\n\n Thanks & Regards" + "\n Rahul Desai");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String filename = "Sanity Execution Report" + getDate() + ".html";
            String file = "ExtentReport.html";

            // Create data source and pass the filename
            DataSource source = new FileDataSource(file);

            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));

            // set the file
            messageBodyPart2.setFileName(filename);

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);
            logger.info("=====Email Sent=====");

        } catch (MessagingException e) {
            logger.info(e);
        }
    }

    public static String getDate() {
        String[] date = new Date().toString().split(" ");
        return date[0] + " " + date[1] + " " + date[2] + " " + date[5] + " " + date[3];
    }
}