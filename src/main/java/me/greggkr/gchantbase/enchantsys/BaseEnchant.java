package me.greggkr.gchantbase.enchantsys;

import me.greggkr.gchantbase.util.RomanNumeralUtil;
import me.greggkr.gchantbase.GchantBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

public class BaseEnchant implements Listener {
    public BaseEnchant() {
        GchantBase.getEnchantManager().registerEnchant(this);
        Bukkit.getPluginManager().registerEvents(this, GchantBase.getInstance());
    }


    public boolean isApplicable(ItemStack item) {
        for (Material mat : getApplicable()) {
            if (mat == item.getType()) return true;
        }

        return false;
    }

    public boolean hasEnchant(ItemStack item) {
        if (item == null) return false;
        if (!item.hasItemMeta()) return false;
        if (!item.getItemMeta().hasLore()) return false;

        for (String string : item.getItemMeta().getLore()) {
            if (string.startsWith(getColor() + getName())) return true;
        }
        return false;
    }

    public boolean itemsHaveEnchants(ItemStack[] items) {
        return Arrays.stream(items).anyMatch(item -> getLevel(item) != -1);
    }

    public int getLevel(ItemStack item) {
        Objects.requireNonNull(item);

        if (!hasEnchant(item)) return -1;

        for (String line : item.getItemMeta().getLore()) {
            if (line.startsWith(getColor() + getName())) {
                return RomanNumeralUtil.decode(line.substring(getName().length() + 3));
            }
        }

        return -1;
    }

    public Enchant getInfo() {
        return getClass().getAnnotation(Enchant.class);
    }

    public String getName() {
        return getInfo().name();
    }

    public ChatColor getColor() {
        return getInfo().color();
    }

    public Material[] getApplicable() {
        return getInfo().applicable();
    }

    public int getMinLevel() {
        return getInfo().minLevel();
    }

    public int getMaxLevel() {
        return getInfo().maxLevel();
    }
}
