package com.amirrori.sticktp;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StickTp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        MagicStickItem stick = new MagicStickItem(this);
        Objects.requireNonNull(getCommand("magicstick")).setExecutor(new MagicStickCommand(stick));
        
        getServer().getPluginManager().registerEvents(new StickListener(stick), this);

        getLogger().info("StickTP enabled.");


        // this.getCommand("magicstick").setExecutor(new MagicStickCommand());
        // Bukkit.getPluginManager().registerEvents(new StickListener(),this);
    }
}
