package me.nurio.minecraft.essentials.modules.home;

import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.essentials.GrechEssentials;
import me.nurio.minecraft.essentials.modules.home.commands.HomeCommand;
import me.nurio.minecraft.essentials.modules.home.commands.SetHomeCommand;

import java.io.File;

public class HomeModule {

    public static void load() {
        GrechConfig homeConfig = new GrechConfig(GrechEssentials.getPlugin(), "home" + File.separator + "config");

        HomeStorage homeStorage = new HomeStorage();

        GrechEssentials.getPlugin().getCommand("home").setExecutor(new HomeCommand(homeStorage));
        GrechEssentials.getPlugin().getCommand("sethome").setExecutor(new SetHomeCommand(homeStorage));
    }

}
