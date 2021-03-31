import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.bots.DefaultBotOptions;

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
}