package co.zpdev.bots.ryno.cmd;

import co.zpdev.core.discord.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ZP4RKER
 */
public class Info {

    @Command(aliases = "info", autodelete = true, description = "Displays information about the bot.")
    public void onCommand(Message message) {
        EmbedBuilder embed = new EmbedBuilder().setColor(Color.CYAN);x

        long used = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        long max = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        message.getChannel().sendMessage(used + "MB/" + max + "MB").queue(m -> new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                m.delete().queue();
            }
        }, 8000));
    }

}
