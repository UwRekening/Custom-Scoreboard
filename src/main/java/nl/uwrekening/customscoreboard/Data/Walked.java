package nl.uwrekening.customscoreboard.Data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Walked {

    public static int getWalked(Player p){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        return Integer.parseInt(config.get("Walked").toString());
    }
    public static void setWalked(Player p, int Walked){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("Walked", Walked);
        try {
            config.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void resetWalked(Player p){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("Walked", 0);
        try {
            config.save(f);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
