package me.sirgregg.gchantbase.enchantsys;

import me.sirgregg.gchantbase.GchantBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BaseEnchant implements Listener {
	private String name;
	private List<Material> applicable;
	private HashMap<UUID, ArrayList<ItemStack>> running = new HashMap<>();
	private EnchantType type;

	public BaseEnchant(String name, List<Material> applicable, EnchantType type) {
		this.name = name;
		this.applicable = applicable;
		this.type = type;

		Bukkit.getPluginManager().registerEvents(this, GchantBase.getInstance());
	}

	public boolean isApplicable(ItemStack item) {
		return applicable.contains(item.getType());
	}

	public boolean hasEnchant(ItemStack item) {
		if (item == null) return false;
		if (!item.hasItemMeta()) return false;
		if (!item.getItemMeta().hasLore()) return false;

		for (String string : item.getItemMeta().getLore()) {
			if (string.startsWith(ChatColor.GRAY + name)) return true;
			break;
		}
		return false;
	}

	public boolean itemsHaveEnchants(ItemStack[] items) {
		for (ItemStack item : items) {
			if (hasEnchant(item)) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public List<Material> getApplicable() {
		return applicable;
	}

	public EnchantType getType() {
		return type;
	}

	public HashMap<UUID, ArrayList<ItemStack>> getRunning() {
		return running;
	}
}
