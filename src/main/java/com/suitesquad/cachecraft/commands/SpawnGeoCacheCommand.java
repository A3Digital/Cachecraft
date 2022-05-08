package com.suitesquad.cachecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnGeoCacheCommand implements CommandExecutor {
    Random rand = new Random();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                ItemStack itemStack = new ItemStack(Material.DIRT,1);
                itemStack.getItemMeta().setDisplayName("Geocache");
                List<String> loresList = new ArrayList<String>();
                loresList.add(String.valueOf(rand.nextInt()));
                itemStack.getItemMeta().setLore(loresList);
                player.getInventory().addItem(itemStack);
            }
        }

        return true;

    }
}
