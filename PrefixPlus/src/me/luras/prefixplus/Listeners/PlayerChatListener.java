package me.luras.prefixplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import me.luras.prefixplus.Main;
import net.md_5.bungee.api.ChatColor;

public class PlayerChatListener implements Listener {

    Plugin plugin = Main.getPlugin(Main.class);
    
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(player.getName()));
        String message = event.getMessage();

        event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RESET + prefix + ChatColor.DARK_GRAY + "]"  + " " + ChatColor.GRAY + player.getDisplayName() + ": "  +  message);
    }
}
