package com.suitesquad.cachecraft;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Commands extends JavaPlugin {
    Random rand = new Random();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player  = Bukkit.getPlayer(sender.getName());
        boolean isOp = player.isOp();

        if (command.getName().equalsIgnoreCase("spawngeocache") && sender instanceof Player && isOp) {
            ItemStack itemStack = new ItemStack(Material.DIRT,1);
            itemStack.getItemMeta().setDisplayName("Geocache");
            List<String> loresList = new ArrayList<String>();
            loresList.add(String.valueOf(rand.nextInt()));
            itemStack.getItemMeta().setLore(loresList);
            player.getInventory().addItem(itemStack);
            return true;
        }

        return false;

    }

}
