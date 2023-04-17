package me.nurio.minecraft.essentials;

import lombok.Getter;
import me.nurio.minecraft.essentials.modules.home.HomeModule;
import me.nurio.minecraft.essentials.modules.spawn.SpawnModule;
import org.bukkit.plugin.java.JavaPlugin;

public class GrechEssentials extends JavaPlugin {

    @Getter private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Load modules
        SpawnModule.load();
        HomeModule.load();
    }

}