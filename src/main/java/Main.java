
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    //private static String PROXY_HOST = "66.232.9.252" /* proxy host */;
    //private static Integer PROXY_PORT = 1080 /* proxy port */;
    //private static String PROXY_USER = "..." /* proxy user */;
    //private static String PROXY_PASSWORD = "..." /* proxy password */;


    public static void main(String[] args) {
        MessageSettingsDAO.createDBStructure();
        String botToken = Utils.getProperty("token");
        String botName = Utils.getProperty("bot_name");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            DefaultBotOptions botOptions = new DefaultBotOptions();
            //botOptions.setProxyHost(PROXY_HOST);
            //botOptions.setProxyPort(PROXY_PORT);
            //botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

            NewOchepyatokNormes bot = new NewOchepyatokNormes(botToken, botName, botOptions);

            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}