package com.amirrori.sticktp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicStickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.RED + "have fun!");

            ItemStack magicStick = new ItemStack(Material.STICK);
            ItemMeta meta = magicStick.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.DARK_RED + "magic stick");

                List<String> lore = new ArrayList<>();
                lore.add("right click to teleport.");

                meta.setLore(lore);
                magicStick.setItemMeta(meta);
            }
            player.getInventory().addItem(magicStick);
        }
        return true;
    }
}

