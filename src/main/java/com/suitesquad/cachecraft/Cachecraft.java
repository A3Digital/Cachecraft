package com.suitesquad.cachecraft;

import com.suitesquad.cachecraft.commands.SpawnGeoCacheCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cachecraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spawngeocache").setExecutor(new SpawnGeoCacheCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
