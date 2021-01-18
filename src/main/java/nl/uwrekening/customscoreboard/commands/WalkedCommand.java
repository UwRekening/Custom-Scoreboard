package nl.uwrekening.customscoreboard.commands;

import nl.uwrekening.customscoreboard.Data.Walked;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalkedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§7Je hebt: " + "§6§l" + Walked.getWalked(player) + "m" +" §7gelopen");
            return false;
            }
        if (player.hasPermission("project-A.WalkedCommand")) {
            if (args[0].equalsIgnoreCase("add")) {
                if (args.length == 3) {
                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                    if (target.isOnline()) {
                        Walked.setWalked(player.getPlayer(), Walked.getWalked(player.getPlayer())+Integer.valueOf(args[2]));
                        player.sendMessage("§aSuccesvol de score van " + "§6§l" + target.getName() + " §averanderd naar " + "§6§l" + Walked.getWalked(player.getPlayer()));
                    } else {
                        player.sendMessage("§cSpeler niet online of niet gevonden!");
                    }
                }
            }
            if (args[0].equalsIgnoreCase("remove")) {
                if (args.length == 3) {
                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                    if (target.isOnline()) {
                        Walked.setWalked(player.getPlayer(), Walked.getWalked(player.getPlayer()) - Integer.valueOf(args[2]));
                        player.sendMessage("§aSuccesvol de score van " + "§6§l" + target.getName() + " §averanderd naar " + "§6§l" + Walked.getWalked(player.getPlayer()));
                    } else {
                        player.sendMessage("§cSpeler niet online of niet gevonden!");
                    }
                }
            }
            if (args[0].equalsIgnoreCase("reset")) {
                if (args.length == 2) {
                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                    if (target.isOnline()) {
                        Walked.resetWalked(player.getPlayer());
                        player.sendMessage("§aSuccesvol de score van " + "§6§l" + target.getName() + " §agereset!");
                    } else {
                        player.sendMessage("§cSpeler niet online of niet gevonden!");
                    }
                }
            }
        }
        return true;
    }
}
