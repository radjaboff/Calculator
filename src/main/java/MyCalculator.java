import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyCalculator extends TelegramLongPollingBot {
    MainControlleer controlleer=new MainControlleer();
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()){
            Message message = update.getMessage();
            SendMessage sendMessage = controlleer.sendMessage(message);
            sendMessage.setReplyMarkup(Utils.menu());
            send(sendMessage);
        } else if (update.hasCallbackQuery()) {

        }
    }

    private void send(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }

    @Override
    public String getBotUsername() {
        return "@radjaboff017_calculatebot";
    }

    @Override
    public String getBotToken() {
        return "8939828563:AAH94dmihwg2eBAJDVNJVV0MD3vGOQqeGc0";
    }
}
