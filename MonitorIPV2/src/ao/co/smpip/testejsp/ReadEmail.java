package ao.co.smpip.testejsp;


import javax.mail.*;

import java.util.Properties;

public class ReadEmail {
    public static void main(String[] args) throws Exception {
        //
        // 1. Setup properties for the mail session.
        //
        Properties props = new Properties();
        props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.pop3.socketFactory.fallback", "false");
        props.put("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.host", "pop.gmail.com");
        props.put("mail.pop3.user", "diwidijoao");
        props.put("mail.store.protocol", "pop3");

        //
        // 2. Creates a javax.mail.Authenticator object.
        //
        Authenticator auth = null;

        //
        // 3. Creating mail session.
        //
        Session session = Session.getDefaultInstance(props, auth);

        //
        // 4. Get the POP3 store provider and connect to the store.
        //
        Store store = session.getStore("pop3");
        store.connect("pop.gmail.com", "diwidijoao", "fracasso");

        //
        // 5. Get folder and open the INBOX folder in the store.
        //
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        //
        // 6. Retrieve the messages from the folder.
        //
        Message[] messages = inbox.getMessages();
        for (int i = messages.length-1; i > 0; i--) {
        	Message message = messages[i];
        	System.out.println("---------------------------------");
        	System.out.println("Email Number " + (i + 1));
        	System.out.println("Subject: " + message.getSubject());
        	System.out.println("From: " + message.getFrom()[0]);
        	System.out.println("Text: " + message.getContent().toString());
           }

        //
        // 7. Close folder and close store.
        //
        inbox.close(false);
        store.close();
    }
}