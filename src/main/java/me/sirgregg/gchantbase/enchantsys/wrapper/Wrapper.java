package me.sirgregg.gchantbase.enchantsys.wrapper;

import me.sirgregg.gchantbase.GchantBase;
import me.sirgregg.gchantbase.enchantsys.BaseEnchant;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Wrapper {
	private static final int COLOR_CODE_LENGTH = 2;

	/*
	Replaced in favor by BaseEnchant.getLevel().
	 */
	@Deprecated
	public List<EnchantWrapper> getWrappers(ItemStack item) {
		if (item == null) return null;
		if (!item.hasItemMeta()) return null;
		if (!item.getItemMeta().hasLore()) return null;

		List<EnchantWrapper> wrappers = new ArrayList<>();
		for (Map.Entry<String, BaseEnchant> entry : GchantBase.getEnchantManager().getRegisteredEnchants().entrySet()) {
			BaseEnchant enchant = entry.getValue();
			if (enchant.hasEnchant(item)) {
				System.out.println(45);
				for (String lore : item.getItemMeta().getLore()) {
					System.out.println(lore);
					if (lore.contains(enchant.getName())) {
						int level = GchantBase.getRomanNumberalUtil().decode(lore.substring(COLOR_CODE_LENGTH + enchant.getName().length() + 1));
						EnchantWrapper wrapper = new EnchantWrapper(enchant, level);
						wrappers.add(wrapper);
					}
				}
			}
		}

		return wrappers;
	}
}
