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

/**
 * Created by pratik.londhe on 9/20/2018.
 */
public class EmailUtils {

    protected static final Map<String, String> configMap = null;
    private static final Logger logger = Logger.getLogger(EmailUtils.class);
    static List<String> ccEmail = new ArrayList();

    public EmailUtils() {

    }

    public static void sendEmail(int passedTestScript, int failedTestScript, int skippedTestScript, String executionEnv, String exeSuiteName, String buildNumber) {
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
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("automationck12@gmail.com", "Test@123");
            }
        });
        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);// Set the from address
            message.setFrom(new InternetAddress("automationck12@gmail.com"));

            // Set the recipient address
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("galina.ilchenco@ck12.org"));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("pratik.londhe@ck12.org,shaju.balakrishnan@ck12.org,tanmay.kashettiwar@ck12.org,karthick.balasubramanian@ck12.org"));

            // Add the subject link
            message.setSubject("CK12 | " + exeSuiteName + " | " + executionEnv + " | " + buildNumber + " | " + getDate());
            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("Hello All," + "\n\n Please find following details regarding sanity test suite execution," + "\n\nTotal Test Script         :- " + total + "\n Passed Test Script    :- " + passedTestScript + "\n Failed Test Script      :- " + failedTestScript + "\n Skipped Test Script   :- " + skippedTestScript + "\n\n PFA." + "\n\n Thanks & Regards" + "\n Pratik Londhe");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String filename = "Regression Suite Execution Report" + getDate() + ".html";
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