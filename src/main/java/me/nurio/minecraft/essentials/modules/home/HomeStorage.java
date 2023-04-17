package me.nurio.minecraft.essentials.modules.home;

import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.essentials.GrechEssentials;
import org.bukkit.Location;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeStorage {

    private Map<UUID, Location> homeCache = new HashMap<>();

    public boolean hasHome(UUID uuid) {
        if(homeCache.containsKey(uuid)) {
            return true;
        }

        GrechConfig playerConfig = new GrechConfig(GrechEssentials.getPlugin(), "home" + File.separator + "players" + File.separator + uuid);
        return playerConfig.getConfig().isSet("default");
    }

    public Location getHome(UUID uuid) {
        // Check if home is cached
        if(homeCache.containsKey(uuid)) {
            return homeCache.get(uuid);
        }

        // Lookup home from file storage
        GrechConfig playerConfig = new GrechConfig(GrechEssentials.getPlugin(), "home" + File.separator + "players" + File.separator + uuid);
        Location home = playerConfig.getLocation("default");
        homeCache.put(uuid, home);
        return home;
    }

    public void setHome(UUID uuid, Location location) {
        GrechConfig playerConfig = new GrechConfig(GrechEssentials.getPlugin(), "home" + File.separator + "players" + File.separator + uuid);
        playerConfig.setLocation("default", location);
        playerConfig.save();
        homeCache.put(uuid, location);
    }

}
