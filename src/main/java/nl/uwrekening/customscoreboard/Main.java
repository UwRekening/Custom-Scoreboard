package nl.uwrekening.customscoreboard;

import nl.uwrekening.customscoreboard.Data.Walked;
import nl.uwrekening.customscoreboard.Items.ItemManager;
import nl.uwrekening.customscoreboard.commands.WalkedCommand;
import nl.uwrekening.customscoreboard.events.Join;
import nl.uwrekening.customscoreboard.events.scoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ItemManager items = new ItemManager();
        items.createCoin();
        getServer().getPluginManager().registerEvents(new scoreboard(), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        getCommand("walkedcommand").setExecutor(new WalkedCommand());
    }

    @Override
    public void onDisable() {
        plugin = null;

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}