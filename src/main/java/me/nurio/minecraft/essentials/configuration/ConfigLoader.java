package me.nurio.minecraft.essentials.configuration;

import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.essentials.GrechEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConfigLoader {

    public static void loadAll() {
    }

    /**
     * Obtains a list of world areas configuration files.
     *
     * @return List of YAML world areas configuration files.
     */
    public static List<File> getWorldAreasFiles() {
        File folder = new File(GrechEssentials.getPlugin().getDataFolder() + File.separator + "areas");
        if (!folder.exists()) folder.mkdirs();
        return Arrays.stream(folder.listFiles())
            .filter(file -> file.getName().endsWith(".yml"))
            .collect(Collectors.toList());
    }

    public static void parse(File file) {
        Bukkit.getLogger().info("Loading world area: " + file.getPath());

        GrechConfig config = new GrechConfig(GrechEssentials.getPlugin(), "areas" + File.separator + file.getName());

        String name = config.getConfig().getString("name");
        UUID uuid = UUID.fromString(config.getConfig().getString("uuid"));

        List<String> blockAreas = new ArrayList<>();
        for (String areaId : config.getConfig().getConfigurationSection("areas").getKeys(false)) {
            Bukkit.getLogger().info("Loading BlockArea '"+name+"'@'"+areaId+"'...");

            Location start = config.getLocation("areas."+areaId+".start");
            Location end = config.getLocation("areas."+areaId+".end");
            blockAreas.add("");
        }

    }

}