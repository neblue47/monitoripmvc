package ao.co.smpip.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
	Email email;
	public EmailJava() {
		email = new SimpleEmail();
		configure();
	}

	private void configure()
	{
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setDebug(true);
		email.setAuthentication("sistemampip@gmail.com", "projectojsp");
		email.setSSLOnConnect(true);
	}
	public void EnviarMail(String from,String subj,String msg,String to){
		try { 		
			email.setFrom(from);
			email.setSubject(subj);
			email.setMsg(msg);
			email.addTo(to);
			email.addReplyTo(from);
			String ok = email.send();
			
			System.out.println("RESUK: "+ok);
		}
		catch (EmailException e) {
			System.out.println(e.getMessage() +" "+ e.getLocalizedMessage());
		}
		
	}

	
}
