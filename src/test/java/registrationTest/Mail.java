package registrationTest;

import abstractParentTest.AbstractParentTest;
import libs.CheckingMails;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Mail extends AbstractParentTest {
    @Test
    public void connectToGmail() throws GeneralSecurityException, MessagingException, IOException {
        CheckingMails.check();
    }
}