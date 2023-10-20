public class MyEmailService implements EmailService {
    @Override
    public void send(Email email) {
        System.out.println("Sending email: " + email.getSubject());
        if (email.isHtml()) {
            System.out.println("HTML content");
        } else {
            System.out.println("Plain text content");
        }

        if (email.isExternal()) {
            System.out.println("Adding disclaimer");
        }

        if (email.isEncryptedWithAES()) {
            System.out.println("Encrypting with AES");
        }

        if (email.isEncryptedWithDES()) {
            System.out.println("Encrypting with DES");
        }

        // Simulate sending with retries
        for (int retry = 1; retry <= 3; retry++) {
            if (sendEmailToRecipient(email)) {
                System.out.println("Email sent successfully.");
                break;
            } else {
                System.out.println("Email sending failed, retrying (attempt " + retry + ")");
            }
        }
    }

    private boolean sendEmailToRecipient(Email email) {
        // Simulate email sending, return true if successful, false otherwise
        return Math.random() < 0.8; // 80% success rate for simulation
    }

    public static void main(String[] args) {
        // Scenario 1: Sending a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
        Email email1 = new Email("Plain Text Email", "This is a plain text email.", false, true, false, false);
        MyEmailService emailService = new MyEmailService();
        emailService.send(email1);

        // Scenario 2: Sending an HTML email to an internal server, encrypted with DES, with the retry functionality
        Email email2 = new Email("HTML Email to Internal Server", "<html><body>This is an HTML email.</body></html>", true, false, false, true);
        emailService.send(email2);

        // Scenario 3: Sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
        Email email3 = new Email("HTML Email to External Resource", "<html><body>This is an HTML email.</body></html>", true, true, true, false);
        emailService.send(email3);

        // Scenario 4: Sending a plain text email to an outside resource and encrypted first with DES and then with AES
        Email email4 = new Email("Plain Text Email", "This is a plain text email.", false, true, true, true);
        emailService.send(email4);
    }
}
