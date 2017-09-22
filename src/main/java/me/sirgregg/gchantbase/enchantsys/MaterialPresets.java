package me.sirgregg.gchantbase.enchantsys;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum MaterialPresets {
	HELMETS(Arrays.asList(Material.LEATHER_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET)),
	CHESTPLATES(Arrays.asList(Material.LEATHER_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE)),
	LEGGINGS(Arrays.asList(Material.LEATHER_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS)),
	BOOTS(Arrays.asList(Material.LEATHER_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS)),
	ARMOR(Arrays.asList(Material.LEATHER_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET,
			Material.LEATHER_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE,
			Material.LEATHER_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS,
			Material.LEATHER_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS)),

	SWORDS(Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD)),
	PICKAXES(Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE)),
	SHOVELS(Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE)),
	AXES(Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE)),
	TOOLS(Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD,
			Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE,
			Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE,
			Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE));

	List<Material> applicable;

	MaterialPresets(List<Material> applicable) {
		this.applicable = applicable;
	}

	public List<Material> getApplicable() {
		return applicable;
	}
}
