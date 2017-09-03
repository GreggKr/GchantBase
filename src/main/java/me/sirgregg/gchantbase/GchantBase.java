package me.sirgregg.gchantbase;

import me.sirgregg.gchantbase.enchantsys.EnchantManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GchantBase extends JavaPlugin {
	private static GchantBase instance;
	private static EnchantManager enchantManager;

	@Override
	public void onEnable() {
		instance = this;
		enchantManager = new EnchantManager();

		//registerConfig();

		enchantManager.setupEnchants();
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
	}

	public static GchantBase getInstance() {
		return instance;
	}

	public static EnchantManager getEnchantManager() {
		return enchantManager;
	}
}
