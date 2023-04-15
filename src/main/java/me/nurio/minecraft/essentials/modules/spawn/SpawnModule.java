package me.nurio.minecraft.essentials.modules.spawn;

import lombok.Getter;
import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.essentials.GrechEssentials;
import me.nurio.minecraft.essentials.modules.spawn.commands.SpawnCommand;
import org.bukkit.Location;

import java.io.File;

public class SpawnModule {

    @Getter
    private static Location spawnLocation;

    public static void load() {
        GrechConfig spawnConfig = new GrechConfig(GrechEssentials.getPlugin(), "spawn" + File.separator + "config");
        spawnLocation = spawnConfig.getLocation("location");

        GrechEssentials.getPlugin().getCommand("spawn").setExecutor(new SpawnCommand());
    }

}
