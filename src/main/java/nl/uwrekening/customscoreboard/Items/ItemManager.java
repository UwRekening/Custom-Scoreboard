package nl.uwrekening.customscoreboard.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager implements Listener {

    public static ItemStack coin;

    public void createCoin(){

        ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Coin");
        List<String> lore = new ArrayList<>();
        lore.add("§7Dit Is Een Zelf Gemaakte Coin!");
        lore.add("§7Waarde: §6€10");
        meta.setLore(lore);
        item.setItemMeta(meta);
        coin = item;

        ShapedRecipe sr = new ShapedRecipe(item);

        sr.shape("   "
                ," G "
                ," A ");
        sr.setIngredient('G', Material.GOLD_INGOT);
        sr.setIngredient('A', Material.ANVIL);
        Bukkit.getServer().addRecipe(sr);
    }
}
