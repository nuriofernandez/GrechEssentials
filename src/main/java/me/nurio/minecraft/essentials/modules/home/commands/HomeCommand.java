package me.nurio.minecraft.essentials.modules.home.commands;

import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.essentials.GrechEssentials;
import me.nurio.minecraft.essentials.modules.home.HomeModule;
import me.nurio.minecraft.essentials.modules.home.HomeStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class HomeCommand implements CommandExecutor {

    private final HomeStorage homeStorage;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage("Only players can execute this command.");
            return false;
        }

        Bukkit.getScheduler().runTaskAsynchronously(GrechEssentials.getPlugin(), () -> teleportAsync(player));

        return true;
    }

    private void teleportAsync(Player player) {
        if (homeStorage.hasHome(player.getUniqueId())) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cYour home is not set yet! &fYou can set it with: &c/sethome"
            ));
            return;
        }

        Location home = homeStorage.getHome(player.getUniqueId());
        Bukkit.getScheduler().runTask(GrechEssentials.getPlugin(), () -> player.teleport(home));

        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aYou have been teleported to your home!"
        ));
    }

}