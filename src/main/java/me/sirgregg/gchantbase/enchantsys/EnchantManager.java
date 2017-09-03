package me.sirgregg.gchantbase.enchantsys;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EnchantManager {
	private HashMap<String, BaseEnchant> registeredEnchants = new HashMap<>();

	public void setupEnchants() {
	}

	public void registerEnchant(BaseEnchant enchant) {
		if (!registeredEnchants.containsKey(enchant.getName())) {
			registeredEnchants.put(enchant.getName(), enchant);
		}
	}

	public void unregisterEnchant(BaseEnchant enchant) {
		if (registeredEnchants.containsKey(enchant.getName())) {
			registeredEnchants.remove(enchant.getName());
		}
	}

	public BaseEnchant getEnchant(String name) {
		if (registeredEnchants.containsKey(name)) return registeredEnchants.get(name);
		return null;
	}

	public String[] getAllEnchantNames() {
		return new String[] {
				String.valueOf(registeredEnchants.keySet())
		};
	}

	public boolean hasEnchant(BaseEnchant enchant, ItemStack item) {
		if (item == null || enchant == null) return false;
		if (!item.hasItemMeta()) return false;
		if (!item.getItemMeta().hasLore()) return false;

		for (String string : item.getItemMeta().getLore()) {
			if (string.startsWith(ChatColor.GRAY + enchant.getName())) return true;
			break;
		}
		return false;
	}

	public Map<String, BaseEnchant> getRegisteredEnchants() {
		return Collections.unmodifiableMap(registeredEnchants);
	}
}
