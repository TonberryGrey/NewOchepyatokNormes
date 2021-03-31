import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class NewOchepyatokNormes extends AbilityBot {

    protected NewOchepyatokNormes(String botToken, String botUsername, DefaultBotOptions options) {
        super(botToken, botUsername, options);
    }

    public long creatorId() {
        return 0;
    }

    public Ability hello() {
        return Ability
                .builder()
                .name("hello")
                .info("says Нормес twice")
                .input(0)
                .locality(USER)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Нормес!", ctx.chatId()))
                .post(ctx -> silent.send("НОРМЕЕЕЕС", ctx.chatId()))
                .build();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            Message message = update.getMessage();

            if(message.hasText()){

                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString());
                sendMessageRequest.setText("Нормес");
                try {
                    execute(sendMessageRequest);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}