package me.sirgregg.gchantbase.util;

import org.bukkit.ChatColor;

public class StringUtil {
    public static String colorify(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
