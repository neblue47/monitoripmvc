package ao.co.smpip.testejsp;


 


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailFactory {
	
	private String mailSTMPServer;
	private String mailSTMPServerPort;
	private String mailSTMPServerSenha;
	
	
	public void sendMail(String from, String to, String subject, String msg){
		
		Properties props = new Properties();
		mailSTMPServer = "smtp.googlemail.com";
		mailSTMPServerPort = "465";
		mailSTMPServerSenha = "reservas";
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host",mailSTMPServer);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", from);
		props.put("mail.debug", "true");
		props.put("mail.smtp.port",mailSTMPServerPort);
		props.put("mail.smtp.socketFactory.port", mailSTMPServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		SimpleAuth aut = new SimpleAuth(from,mailSTMPServerSenha);
		
		Session ss = Session.getDefaultInstance(props,aut);
		ss.setDebug(true);
		
		Message mms = new MimeMessage(ss);
		
		try {
			mms.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mms.setFrom(new InternetAddress(from));
			mms.setSubject(subject);
			mms.setContent(msg,"text/area");
		} catch (Exception e) {
			System.out.println("Nao Enviado: "+e.getMessage());
		}
		Transport tr;
		
		try {
			tr = ss.getTransport("smtp");
			tr.connect(mailSTMPServer,from,mailSTMPServerSenha);
			mms.saveChanges();
			tr.sendMessage(mms,mms.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			System.out.println("ERRO: "+e.getMessage());
		}

	}
}

class SimpleAuth extends Authenticator {
	
	public String username = null;
	public String password = null;
	
	public SimpleAuth(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	protected PasswordAuthentication getPasswordAutentication(){
		return new PasswordAuthentication(username,password);
	}
}