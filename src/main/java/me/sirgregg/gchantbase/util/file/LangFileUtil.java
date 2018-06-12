package me.sirgregg.gchantbase.util.file;

import me.sirgregg.gchantbase.GchantBase;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Level;

public class LangFileUtil extends YamlConfiguration {
    private static LangFileUtil lang;
    private final File file;

    private LangFileUtil() {
        file = new File(GchantBase.getInstance().getDataFolder(), "lang.yml");
        loadLang();
    }

    public static LangFileUtil getLang() {
        if (lang == null) {
            lang = new LangFileUtil();
        }
        return lang;
    }

    public void loadLang() {
        if (!file.exists()) {
            saveDefaultLang();
        }
        loadConfiguration(file);
        try {
            load(file);
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot load lang.yml", e);
        }
    }

    public void saveLang() {
        try {
            save(file);
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot save lang.yml", e);
        }
    }

    public void reloadLang() {
        loadLang();
    }

    public void saveDefaultLang() {
        if (!file.exists()) {
            GchantBase.getInstance().saveResource("lang.yml", false);
        }
    }
}
