package me.greggkr.gchantbase.command;

import me.greggkr.gchantbase.enchantsys.BaseEnchant;
import me.greggkr.gchantbase.util.RomanNumeralUtil;
import me.greggkr.gchantbase.GchantBase;
import me.greggkr.gchantbase.util.file.LangFileUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.greggkr.gchantbase.util.StringUtil.colorify;

public class GchantCommand implements CommandExecutor {
    private LangFileUtil lang = LangFileUtil.getLang();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(colorify(lang.getString("player-only")));
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission("gchant.command.help")) {
                player.sendMessage(colorify(lang.getString("no-permission")));
                return true;
            }

            for (String string : lang.getStringList("gchant-command.help")) {
                player.sendMessage(colorify(string));
            }
        } else if (args[0].equalsIgnoreCase("enchant")) {
            if (!player.hasPermission("gchant.command.enchant")) {
                player.sendMessage(colorify(lang.getString("no-permission")));
                return true;
            }

			/*
            0 -> enchant
			1 -> enchant name
			2 -> level
			 */
            if (args.length < 3) {
                player.sendMessage(colorify(lang.getString("gchant-command.enchant.incorrect-args")));
                return true;
            }

            if (player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) {
                player.sendMessage(colorify(lang.getString("gchant-command.enchant.nothing-in-hand")));
                return true;
            }

            BaseEnchant enchant = GchantBase.getEnchantManager().getEnchant(args[1]);

            if (enchant == null) {
                player.sendMessage(colorify(lang.getString("gchant-command.enchant.invalid-enchant")));
                return true;
            }

            int level;

            try {
                level = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                player.sendMessage(colorify(lang.getString("gchant-command.enchant.incorrect-args")));
                return true;
            }

            if (level < enchant.getMinLevel() || level > enchant.getMaxLevel()) {
                player.sendMessage(colorify(lang.getString("gchant-command.enchant.invalid-level")
                        .replaceAll("%min-level%", Integer.toString(enchant.getMinLevel()))
                        .replaceAll("%max-level%", Integer.toString(enchant.getMaxLevel()))));
                return true;
            }

            ItemStack item = player.getItemInHand();
            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();

            if (lore == null) lore = new ArrayList<>();

            lore.add(lore.size() - 1, colorify(enchant.getColor() + enchant.getName() + " " + RomanNumeralUtil.encode(level))); // TODO: Add it to the bottom of the enchant list (to avoid weird formatting)

            meta.setLore(lore);
            item.setItemMeta(meta);

            player.sendMessage(colorify(lang.getString("gchant-command.enchant.enchanted")));
        } else if (args[0].equalsIgnoreCase("list")) {
            if (!player.hasPermission("gchant.command.list")) {
                player.sendMessage(colorify(lang.getString("no-permission")));
                return true;
            }

            for (BaseEnchant enchant : GchantBase.getEnchantManager().getRegisteredEnchants().values()) {
                player.sendMessage(enchant.getColor() + enchant.getName());
            }
        } else {
            if (!player.hasPermission("gchant.command.help")) {
                player.sendMessage(colorify(lang.getString("no-permission")));
                return true;
            }

            for (String string : lang.getStringList("gchant-command.help")) {
                player.sendMessage(colorify(string));
            }
        }
        return true;
    }
}
