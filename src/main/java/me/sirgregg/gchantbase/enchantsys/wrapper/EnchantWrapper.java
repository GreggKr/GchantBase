package me.sirgregg.gchantbase.enchantsys.wrapper;

import me.sirgregg.gchantbase.enchantsys.BaseEnchant;

public class EnchantWrapper {
	private BaseEnchant enchant;
	private int level;

	public EnchantWrapper(BaseEnchant enchant, int level) {
		this.enchant = enchant;
		this.level = level;
	}

	public BaseEnchant getEnchant() {
		return enchant;
	}

	public int getLevel() {
		return level;
	}
}
