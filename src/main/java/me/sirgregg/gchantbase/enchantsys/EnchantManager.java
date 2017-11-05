package me.sirgregg.gchantbase.enchantsys;

import org.bukkit.inventory.ItemStack;

import java.util.*;

public class EnchantManager {
    private HashMap<String, BaseEnchant> registeredEnchants = new HashMap<>();

    public int getLevel(ItemStack item, BaseEnchant enchant) {
        Objects.requireNonNull(enchant);

        return enchant.getLevel(item);
    }

    public void registerEnchant(BaseEnchant enchant) {
        if (!registeredEnchants.containsKey(enchant.getName())) {
            registeredEnchants.put(enchant.getName(), enchant);
        }
    }

    public void registerEnchants(BaseEnchant... enchants) {
        Arrays.stream(enchants).forEach(this::registerEnchant);
    }

    public void unregisterEnchant(BaseEnchant enchant) {
        if (registeredEnchants.containsKey(enchant.getName())) {
            registeredEnchants.remove(enchant.getName());
        }
    }

    public void unregisterEnchants(BaseEnchant... enchants) {
        Arrays.stream(enchants).forEach(this::unregisterEnchant);
    }

    public BaseEnchant getEnchant(String name) {
        if (registeredEnchants.containsKey(name)) return registeredEnchants.get(name);
        return null;
    }

    public HashSet<String> getAllEnchantNames() {
        return new HashSet<>(registeredEnchants.keySet());
    }

    public boolean hasEnchant(BaseEnchant enchant, ItemStack item) {
        Objects.requireNonNull(enchant);
        Objects.requireNonNull(item);

        return enchant.hasEnchant(item);
    }

    public Map<String, BaseEnchant> getRegisteredEnchants() {
        return Collections.unmodifiableMap(registeredEnchants);
    }
}
