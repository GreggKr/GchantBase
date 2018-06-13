package me.greggkr.gchantbase;

import me.greggkr.gchantbase.command.GchantCommand;
import me.greggkr.gchantbase.enchantsys.EnchantManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GchantBase extends JavaPlugin {
    private static GchantBase instance;
    private static EnchantManager enchantManager;

    public static GchantBase getInstance() {
        return instance;
    }

    public static EnchantManager getEnchantManager() {
        return enchantManager;
    }

    @Override
    public void onEnable() {
        instance = this;
        enchantManager = new EnchantManager();

        registerCommands();
    }

    private void registerCommands() {
        getCommand("gchant").setExecutor(new GchantCommand());
    }
}
