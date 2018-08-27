package bunkersprojectsvit;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * a simple class using SMTP protocol to send mail 
 * to the stiudent's on temp database
 */

public class SendMailForTemp {
	public SendMailForTemp(String topics, String subjectTaught, int hours, String emailAddress) {
		try
		{
			String host = "smtp.gmail.com";
			String user = "www.shashankreddy@gmail.com";
			String pass = "Shashank@1998";
			String to = emailAddress;
			String from = "www.shashankreddy@gmail.com";
			String subject = "Your ward did not attend" + " " + subjectTaught + " for" + Integer.toString(hours) + "hours" ;
			String messageText = "Topics Covered: \n"+topics;
			boolean sessionDebug = false;
			
			Properties props = System.getProperties();
			
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host",host);
			props.put("mail.smtp.port","587");
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.required","true");
			
//			java security
			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			
			Session mailSession = Session.getDefaultInstance(props,null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);
			
			Transport transport =  mailSession.getTransport("smtp");
			transport.connect(host,user,pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("Message sent successfully");
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
	}
}
