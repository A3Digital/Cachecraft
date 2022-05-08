package com.suitesquad.cachecraft;

import com.suitesquad.cachecraft.commands.SpawnGeoCacheCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public final class Cachecraft extends JavaPlugin implements Listener {


    InternalStorage internalStorage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spawngeocache").setExecutor(new SpawnGeoCacheCommand());

        //Create internal storage
        internalStorage = new InternalStorage(getInternalStorage());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String getInternalStorage(){
        File file = new File(getDataFolder(), "data.txt");
        //If the file already exists load the data
        if(file.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder stringBuilder = new StringBuilder();
                char[] buffer = new char[10];
                while (reader.read(buffer) != -1) {
                    stringBuilder.append(new String(buffer));
                    buffer = new char[10];
                }
                reader.close();

                String content = stringBuilder.toString();
                return content;
            } catch (IOException ex) {
                ex.printStackTrace();
                return getDefaultInternalData();
            }
        }
        else{
            return getDefaultInternalData();
        }
    }

    //Default internal data used to generate internal storage when error found or when no prior data exists
    public String getDefaultInternalData(){
        return "-1|0|0|0|";
    }
}
