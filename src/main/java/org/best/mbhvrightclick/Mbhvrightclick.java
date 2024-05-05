package org.best.mbhvrightclick;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public final class Mbhvrightclick extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerClickListener(), this);
        getServer().getPluginManager().registerEvents((Listener) new PlayerCommand(), this);
        // Check if the 'config.yml' file exists
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            // Create an empty 'config.yml' file
            saveDefaultConfig();
            getLogger().info("config.yml created successfully.");
        } else {
            getLogger().info("config.yml already exists.");
        }

        // Your other plugin initialization logic can go here
        // ...
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
