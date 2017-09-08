package me.sirgregg.gchantbase;

import me.sirgregg.gchantbase.enchantsys.EnchantManager;
import me.sirgregg.gchantbase.enchantsys.wrapper.Wrapper;
import me.sirgregg.gchantbase.util.RomanNumberalUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class GchantBase extends JavaPlugin {
	private static GchantBase instance;
	private static Wrapper wrapper;
	private static EnchantManager enchantManager;
	private static RomanNumberalUtil romanNumberalUtil;

	@Override
	public void onEnable() {
		instance = this;
		enchantManager = new EnchantManager();
		wrapper = new Wrapper();

		//registerConfig();

		enchantManager.setupEnchants();
		romanNumberalUtil = new RomanNumberalUtil();
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
	}

	public static Wrapper getWrapper() {
		return wrapper;
	}

	public static GchantBase getInstance() {
		return instance;
	}

	public static EnchantManager getEnchantManager() {
		return enchantManager;
	}

	public static RomanNumberalUtil getRomanNumberalUtil() {
		return romanNumberalUtil;
	}
}
