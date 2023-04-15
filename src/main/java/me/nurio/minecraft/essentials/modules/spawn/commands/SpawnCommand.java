package me.nurio.minecraft.essentials.modules.spawn.commands;

import me.nurio.minecraft.essentials.modules.spawn.SpawnModule;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage("Only players can execute this command.");
            return false;
        }

        player.teleport(SpawnModule.getSpawnLocation());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aYou have been teleported to the spawn!"
        ));
        return true;
    }

}