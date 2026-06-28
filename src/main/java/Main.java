import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args)  {

        TelegramBotsApi telegramBotsApi= null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {

        }
        try {
            telegramBotsApi.registerBot(new MyCalculator());
        } catch (TelegramApiException e) {

        }

    }
}
