package miu.edu.cse.adsdentalsurgeries.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailSender {
    public static void sendEmail(String recipient, String subject, String body) {
        log.info("Sending email to: {}", recipient);
        log.info("Subject: {}", subject);
        log.info("Body: {}", body);
    }
}
