package me.greggkr.gchantbase.enchantsys;

import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

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
        for (String key : registeredEnchants.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                return registeredEnchants.get(key);
            }
        }

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
