package com.amirrori.sticktp;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;
public class StickListener implements Listener {
    private final MagicStickItem stick;

    public StickListener(MagicStickItem stick) {
        this.stick = stick;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
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
