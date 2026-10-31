package com.amirrori.sticktp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StickTp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Wyn's plugin tnt enabled.");
        this.getCommand("magicstick").setExecutor(new MagicStickCommand());
        Bukkit.getPluginManager().registerEvents(new StickListener(),this);
    }
}