package hello;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author hmendoza
 *
 * 
 */

@Service("RestClientConex")
public class RestClientSendMessage {
	 private static final Logger logger = LogManager.getLogger(RestClientSendMessage.class);
	public String  peticion(String json,String method){
		String respuesta="";
		try {
			
			String ruta="https://api.telegram.org/bot399238071:AAEwNO9nA2f50JT7MW1ss3GgNhvcgtFlmB0/sendMessage";		
			URL url = new URL(ruta);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type","application/json");
			

			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes(Charset.forName("UTF-8")));
			os.flush();
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
				
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				
				respuesta=respuesta+output;
			}
			
			conn.disconnect();
			
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
		
		return respuesta;
		
	}

}
