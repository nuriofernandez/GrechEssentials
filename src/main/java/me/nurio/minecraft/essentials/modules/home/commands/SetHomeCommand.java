package me.nurio.minecraft.essentials.modules.home.commands;

import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.essentials.GrechEssentials;
import me.nurio.minecraft.essentials.modules.home.HomeStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class SetHomeCommand implements CommandExecutor {

    private final HomeStorage homeStorage;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage("Only players can execute this command.");
            return false;
        }

        Location location = player.getLocation();

        Bukkit.getScheduler().runTaskAsynchronously(GrechEssentials.getPlugin(), () -> saveHomeAsync(player, location));

        return true;
    }

    private void saveHomeAsync(Player player, Location home) {
        homeStorage.setHome(player.getUniqueId(), home);

        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aYou have saved this place as your home! &fUse &c/home &fto get teleported from now on."
        ));
    }

}