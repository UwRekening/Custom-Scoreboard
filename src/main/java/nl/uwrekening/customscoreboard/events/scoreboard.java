package nl.uwrekening.customscoreboard.events;

import nl.uwrekening.customscoreboard.Data.Walked;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.*;

public class scoreboard implements Listener {

    public static int Walked = 0;


    @EventHandler
    public void walk(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("Walked", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("§6HRA Project-A");

        Score space = o.getScore("");
        Score space2 = o.getScore(" ");
        Score walked = o.getScore("Walked: " + "§6§l" + nl.uwrekening.customscoreboard.Data.Walked.getWalked(player));
        space2.setScore(3);
        space.setScore(1);
        walked.setScore(2);

        player.setScoreboard(b);

        if ((int) event.getFrom().getX() != (int) event.getTo().getX() || (int) event.getFrom().getZ() != (int) event.getTo().getZ()) {
            Walked = +1;
            nl.uwrekening.customscoreboard.Data.Walked.setWalked(player.getPlayer(), nl.uwrekening.customscoreboard.Data.Walked.getWalked(player.getPlayer()) + Integer.valueOf(Walked));
        }
    }
}
