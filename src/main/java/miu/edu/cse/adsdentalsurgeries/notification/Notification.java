package miu.edu.cse.adsdentalsurgeries.notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Notification {
    public static void sendEmail(String recipient, String subject, String body) {
        log.info("Sending email to: {}", recipient);
        log.info("Subject: {}", subject);
        log.info("Body: {}", body);
    }
}
