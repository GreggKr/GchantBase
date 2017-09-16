package me.sirgregg.gchantbase.enchantsys;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum MaterialPresets {
	BOOTS(Arrays.asList(Material.LEATHER_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS));

	List<Material> applicable;

	MaterialPresets(List<Material> applicable) {
		this.applicable = applicable;
	}

	public List<Material> getApplicable() {
		return applicable;
	}
}
