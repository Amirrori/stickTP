package com.amirrori.sticktp;

import java.util.List;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

import org.bukkit.NamespacedKey;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicStickItem {

    private final NamespacedKey key;

    public MagicStickItem(JavaPlugin plugin) {
        key = new NamespacedKey(plugin, "magic_stick");
    }

    public ItemStack create() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName(Component.text("Magic stick", NamedTextColor.DARK_RED).decoration(TextDecoration.ITALIC, false));

        meta.lore(List.of(Component.text("Right click to teleport.")));
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        stick.setItemMeta(meta);
        return stick;
    }


    public boolean isMagicStick(ItemStack item) {
        return item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE);
    }
}

