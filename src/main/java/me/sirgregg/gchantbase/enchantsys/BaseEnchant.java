package me.sirgregg.gchantbase.enchantsys;

import me.sirgregg.gchantbase.GchantBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Objects;

public class BaseEnchant implements Listener {
	private String name;
	private List<Material> applicable;
	private EnchantType type;
	int minLevel, maxLevel;

	public BaseEnchant(String name, int minLevel, int maxLevel, List<Material> applicable, EnchantType type) {
		this.name = name;
		this.applicable = applicable;
		this.type = type;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;

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

	public int getLevel(ItemStack item) {
		Objects.requireNonNull(item);

		if (!hasEnchant(item)) return -1;

		for (String line : item.getItemMeta().getLore()) {
			if (line.startsWith(ChatColor.GRAY + name)) {
				return GchantBase.getRomanNumberalUtil().decode(line.substring(name.length() + 3));
			}
		}

		return -1;
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

	public int getMaxLevel() {
		return maxLevel;
	}

	public int getMinLevel() {
		return minLevel;
	}
}
