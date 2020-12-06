package co.zpdev.bots.rhino;

import co.zpdev.bots.ryno.lstnr.Ready;
import co.zpdev.core.discord.command.CommandHandler;
import co.zpdev.core.discord.util.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.AnnotatedEventManager;
import net.dv8tion.jda.core.utils.JDALogger;

import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;

/**
 * @author ZP4RKER
 */
public class Ryno {

    public static Config config;

    public static void main(String[] args) throws LoginException, InterruptedException, URISyntaxException {
        config = new Config("config.json");
        CommandHandler handler = new CommandHandler("/", "co.zpdev.bots.ryno.cmd");

        new JDABuilder(AccountType.BOT).setToken(config.data.getString("token"))
                .setEventManager(new AnnotatedEventManager())
                .addEventListener(handler, new Ready())
                .buildBlocking();
    }

    public static void info(Object message) {
        JDALogger.getLog("Ryno").info(message.toString());
    }

}
