package hello;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    RestClientSendMessage restClientSendMessage;
    private static final Logger logger = LogManager.getLogger(RestClientSendMessage.class);
    @RequestMapping("/")
    public String index() {
    	JSONObject obj = new JSONObject();
    	String text = "hola";
    	long chat_id=115591033;
    	text= text+Emoji.CRYING_CAT_FACE;
    	obj.put("chat_id", chat_id);
    	obj.put("text", text);   	
    	String resp=restClientSendMessage.peticion(obj.toString(), "POST");
    	logger.info("\n-------------------Message to----------------------\n"+" ->Chat_ID:"+chat_id+"\n ->Bot Message: "+text );
    	
    	logger.info("\n-------------------Bot father----------------------\n"+resp);
        return "Greetings from Spring Boot!";
    }
    
}
