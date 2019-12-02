package libs;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class CheckingMails {
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
    private static final String SMTP_AUTH_USER = "bce450@gmail.com";
    private static final String SMTP_AUTH_PWD = "Parol123";
    public static void check(/*String host, String storeType, String user,
                             String password*/) throws MessagingException, GeneralSecurityException, IOException {

        // -----------------
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);


        Properties props = new Properties();
        props.put("mail.imap.ssl.trust", "*");
        props.put("mail.imap.ssl.socketFactory", sf);

        Properties properties = new Properties();

        properties.setProperty("mail.pop3s.host", "pop.gmail.com");
        properties.setProperty("mail.pop3s.port", "995");
        properties.setProperty("mail.pop3s.starttls.enable", "true");
        properties.setProperty("mail.pop3s.ssl.trust", "*");
        properties.setProperty("mail.pop3s.auth", "true");
        properties.setProperty("mail.pop3s.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        Session emailSession = Session.getDefaultInstance(properties);

        //create the POP3 store object and connect with the pop server
        Store store = emailSession.getStore("pop3s");

        store.connect("pop.gmail.com", 995, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        int messageCount = inbox.getMessageCount();

        System.out.println(messageCount);
        Message[] messages = inbox.getMessages();
        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i].getMessageNumber() + " Subject " + i + " " + inbox.getMessages()[i].getSubject() + " To: " + inbox.getMessages()[i].getAllRecipients()[0]);
        }

        inbox.getMessage(3).setFlag(Flags.Flag.DELETED, true);


        messages = inbox.getMessages();
        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i].getMessageNumber() + " Subject " + i + " " + inbox.getMessages()[i].getSubject() + " Flags : " + inbox.getMessages()[i].getFlags().getSystemFlags().length);
        }

        Multipart mp = (Multipart) inbox.getMessage(3).getContent();
        Object p = mp.getBodyPart(0).getContent();
        String q = p.toString();
        System.out.println("EmailBody /n" + q); /// Email text
        Object p1 = mp.getBodyPart(1).getContent();
        String q1 = p1.toString();
        System.out.println("EmailBody /n" + q1); // Email HTML

        inbox.close(true);
        store.close();

    }

}
