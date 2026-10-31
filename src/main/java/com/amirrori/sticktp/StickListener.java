package com.amirrori.sticktp;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.EquipmentSlot;

public class StickListener implements Listener {
    private static final int MAX_DISTANCE = 100;
    // each tick in minecraft is 0.05 seconds. 40 is 2 seconds in this case.
    private static final int COOLDOWN_TICKS = 40; 
    private final MagicStickItem stick;

    public StickListener(MagicStickItem stick) {
        this.stick = stick;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (e.getHand() != EquipmentSlot.HAND) {
            return;
        }
        if (!stick.isMagicStick(e.getItem())) {
            return;
        }

        e.setCancelled(true);
        Player player = e.getPlayer();


        if (!player.hasPermission("sticktp.use")) {
            player.sendActionBar(Component.text("You can't use the magic stick.", NamedTextColor.RED));
            return;
        }
        if (player.hasCooldown(Material.STICK)) {
            player.sendActionBar(Component.text("This item is on cooldown."));
            return;
        }

        Block target = player.getTargetBlockExact(MAX_DISTANCE);

        if (target == null) {
            player.sendActionBar(Component.text("Nothing in range.", NamedTextColor.RED));
            return;
        }

        Block feet = target.getRelative(BlockFace.UP);
        Block head = feet.getRelative(BlockFace.UP);
        if (!feet.isPassable() || !head.isPassable()) {
            player.sendActionBar(Component.text("No room to land there.", NamedTextColor.RED));
            return;
        }

        Location destination = feet.getLocation().add(0.5, 0, 0.5);

        destination.setYaw(player.getLocation().getYaw());
        destination.setPitch(player.getLocation().getPitch());

        player.teleport(destination);
        player.setCooldown(Material.STICK, COOLDOWN_TICKS);

        // float pitch = p.getLocation().getPitch();
        // float yaw = p.getLocation().getYaw();
        //
        // if(p.getInventory().getItemInMainHand().getType().equals(Material.STICK)){
        //         Block b = p.getTargetBlock((Set<Material>)null, 100);
        //         b.getLocation().setPitch(pitch);
        //         b.getLocation().setYaw(yaw);
        //         p.teleport(b.getLocation().add(0, 1, 0));
        //     }
        }
    }
