package co.zpdev.bots.ryno.lstnr;

import co.zpdev.bots.ryno.Ryno;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author ZP4RKER
 */
public class Ready {

    @SubscribeEvent
    public void onReady(ReadyEvent event) {
        Ryno.info("v" + Ryno.class.getPackage().getImplementationVersion() + " started successfully!");

        startGameLoop(event.getJDA());
    }

    private void startGameLoop(JDA jda) {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String[] games = {
                        "v" + Ryno.class.getPackage().getImplementationVersion() + " | WIP",
                        jda.getGuilds().size() + " guilds",
                        jda.getTextChannels().size() + " channels",
                        jda.getUsers().size() + " users",
                        "made by ZP4RKER#3333"
                };

                Game game = jda.getPresence().getGame();
                if (game == null || game.getName().equals(games[4])) game = Game.playing(games[0]);
                else if (game.getName().equals(games[3])) game = Game.playing(games[4]);
                else if (game.getName().equals(games[2])) game = Game.playing(games[3]);
                else if (game.getName().equals(games[1])) game = Game.playing(games[2]);
                else game = Game.playing(games[1]);

                jda.getPresence().setGame(game);
            }
        }, 0, TimeUnit.SECONDS.toMillis(20));
    }

}
