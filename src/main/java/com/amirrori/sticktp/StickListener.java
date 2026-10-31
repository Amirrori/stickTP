package com.amirrori.sticktp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class StickListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemStack magicStick = new ItemStack(Material.STICK);
        ItemMeta meta = magicStick.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_BLUE + "magic stick");

            List<String> lore = new ArrayList<>();
            lore.add("right click to teleport.");

            meta.setLore(lore);
            magicStick.setItemMeta(meta);
        }
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR));
            Player p = e.getPlayer();
            float pitch = p.getLocation().getPitch();
            float yaw = p.getLocation().getYaw();

            if(p.getInventory().getItemInMainHand().getType().equals(Material.STICK)){
                Block b = p.getTargetBlock((Set<Material>)null, 100);
                b.getLocation().setPitch(pitch);
                b.getLocation().setYaw(yaw);
                p.teleport(b.getLocation().add(0, 1, 0));
            }
        }
    }
