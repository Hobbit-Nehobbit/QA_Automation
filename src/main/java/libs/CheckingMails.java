package libs;

import com.sun.mail.util.MailSSLSocketFactory;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

import javax.mail.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


public class CheckingMails {
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private static Store store;
    private static final String POP_HOST_NAME = "spop.gmail.com";
    private static final String POP_HOST_PORT = "965";

    private static final String PART_OF_SUBJECT = "https://test.megalot.emict.net";


    public static String check() throws MessagingException, GeneralSecurityException, IOException {

        Folder inbox = getInBoxGmailFolder();

        Message[] messages = inbox.getMessages();

        printMessageToConsole(messages, PART_OF_SUBJECT);

        List<Message> collectMail = getListOfMessageWithPartSubject(messages, PART_OF_SUBJECT);


        System.out.println("-----------------");

//        setDeletedFlag(collectMail);

        String linkForRegistartion = "" ;
        // Get registration link and print it
        if (collectMail.size() > 0) {
            String mailBodyAsString = getMailBodyAsString(collectMail.get(0));

            System.out.println(mailBodyAsString);
            String[] splitedMail = mailBodyAsString.split("\r");
            List<String> lines = Arrays.stream(splitedMail)
                    .filter(m -> m.contains("https"))
                    .map(m -> m.replace("\n", "").replace("\t", ""))
                    .collect(Collectors.toList());


            linkForRegistartion = lines.get(0);
            System.out.println(linkForRegistartion);
        }

        // Delete reader file and close folder
        inbox.close(true);
        store.close();

        return linkForRegistartion;

    }

    private static String getMailBodyAsString(Message mail) throws IOException, MessagingException {
        Multipart mp = (Multipart) mail.getContent();
        Object p = mp.getBodyPart(0).getContent();
        return p.toString();
    }

    private void setDeletedFlag(List<Message> collectMail) {
        collectMail
                .forEach(a -> {
                    try {
                        a.setFlag(Flags.Flag.DELETED, true);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static List<Message> getListOfMessageWithPartSubject(Message[] messages, String partOfSubject) {
        return Arrays.stream(messages)
                .filter(m -> {
                    try {
                        return m.getSubject().contains(partOfSubject);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    private static void printMessageToConsole(Message[] messages, String partOfSubject) {
        Arrays.stream(messages)
                .filter(m -> {
                    try {
                        return m.getSubject().contains(partOfSubject);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .forEach(m -> {
                    try {
                        System.out.println("Subject :: "  +m.getSubject() +  " To :: " + Arrays.toString(m.getAllRecipients()));
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                });
    }


    private static Folder getInBoxGmailFolder() throws GeneralSecurityException, MessagingException {
        return getGmailFolder("INBOX");
    }

    private static Folder getGmailFolder(String folderName) throws GeneralSecurityException, MessagingException {
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        Properties properties = new Properties();

        properties.setProperty("mail.pop3s.host", POP_HOST_NAME);
        properties.setProperty("mail.pop3s.port", POP_HOST_PORT);
        properties.setProperty("mail.pop3s.starttls.enable", "true");
        properties.setProperty("mail.pop3s.ssl.trust", "*");
        properties.setProperty("mail.pop3s.auth", "true");
        properties.setProperty("mail.pop3s.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        Session emailSession = Session.getDefaultInstance(properties);

        //create the POP3 store object and connect with the pop server
        store = emailSession.getStore("pop3s");

        store.connect("pop.gmail.com", 995,
                configProperties.GMAIL_ACCOUNT(), configProperties.GMAIL_ACCOUNT_PASS());

        Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_WRITE);
        return folder;
    }


}
