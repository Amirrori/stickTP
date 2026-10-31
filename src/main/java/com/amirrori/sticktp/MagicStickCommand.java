package com.amirrori.sticktp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class MagicStickCommand implements CommandExecutor {
    private final MagicStickItem stick;
    public MagicStickCommand(MagicStickItem stick) {
        this.stick = stick;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can use this command."));
            return true;
        }
        player.sendMessage(Component.text("Have fun!", NamedTextColor.RED));
            
        player.getInventory().addItem(stick.create());
        return true;
    }
}

