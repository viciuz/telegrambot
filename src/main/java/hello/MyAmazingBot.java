package hello;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.vdurmont.emoji.EmojiParser;
//@Component
public class MyAmazingBot extends TelegramLongPollingBot  {
	private static final Logger logger = LogManager.getLogger(MyAmazingBot.class);

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "ziuvic";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String user_first_name = update.getMessage().getChat().getFirstName();
			String user_last_name = update.getMessage().getChat().getLastName();
			String user_username = update.getMessage().getChat().getUserName();
			long user_id = update.getMessage().getChat().getId();
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();

			// boot answer
			SendMessage answer = new SendMessage() // Create a message object
					// object
					.setChatId(chat_id).setText(message_text);
			

			

			try {
				sendMessage(answer); // Sending our message object to user
				logger.info("\n-------------------Message from----------------------\n" + "Name:" + user_first_name
						+ " Last Name:" + user_last_name + " User name:" + user_username + " User_ID:" + user_id+ " Chat_ID:"+chat_id
						+ "\n ->Message: " + message_text + "\n ->Bot answer: " + answer.getText());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}
	public void sendMessage(String text, long chat_id){
		text= EmojiParser.parseToUnicode(text+" :smile");
		SendMessage answer= new SendMessage();
		answer.setChatId(chat_id);
		answer.setText(text);
		try {
			sendMessage(answer); // Sending our message object to user
			logger.info("\n-------------------Message to----------------------\n"+" ->Chat_ID:"+chat_id+"\n ->Bot Message: "+answer.getText() );
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "399238071:AAEwNO9nA2f50JT7MW1ss3GgNhvcgtFlmB0";
	}

}
