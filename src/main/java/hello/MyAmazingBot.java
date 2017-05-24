package hello;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {

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
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();

			SendMessage message = new SendMessage() // Create a message object
													// object
					.setChatId(chat_id).setText(message_text);
			try {
				sendMessage(message); // Sending our message object to user
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "399238071:AAEwNO9nA2f50JT7MW1ss3GgNhvcgtFlmB0";
	}

}
