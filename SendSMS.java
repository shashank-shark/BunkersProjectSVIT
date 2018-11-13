import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

public class SendSMS {
	public void sendSMSTo(String getNumber, String messageFrom)
	{
		try {
			String myurl = "https://smsapi.engineeringtgr.com/send/?Mobile=9380021471&Password=lordvilgax&Message="+messageFrom+"&To="+getNumber+"&Key=www.szoFRB9jAMbcskN4vhiUQWES7";
//			https://smsapi.engineeringtgr.com/send/?Mobile=&Password=&Message=&To=&Key=
				
			System.out.println(myurl);
            URL url = new URL(myurl);
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response="";
            while ((i = stream.read()) != -1) {
                response+=(char)i;
            }
            if(response.contains("success")){
                System.out.println("Successfully send SMS");
                JOptionPane.showMessageDialog(null, "Message successfully sent");
                //your code when message send success
            }else{
                System.out.println(response);
                //your code when message not send
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}