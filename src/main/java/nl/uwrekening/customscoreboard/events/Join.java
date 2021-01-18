package nl.uwrekening.customscoreboard.events;

import nl.uwrekening.customscoreboard.Data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if (!PlayerData.existsPlayerData(player)){
            PlayerData.createPlayerData(player);
        }
    }
}
