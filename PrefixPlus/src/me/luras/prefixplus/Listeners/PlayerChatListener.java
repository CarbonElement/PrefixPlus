package me.luras.prefixplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import me.luras.prefixplus.Main;
import net.md_5.bungee.api.ChatColor;

public class PlayerChatListener implements Listener {
	
	public static String message;

    Plugin plugin = Main.getPlugin(Main.class);
    
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(plugin.getConfig().getString("messageColor") == "true") {
            message = ChatColor.translateAlternateColorCodes('&', event.getMessage());
            } else {
            	message = event.getMessage();
            }
        if(!(plugin.getConfig().contains(player.getName()))) {
        	event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("defaultPrefix")) + ChatColor.DARK_GRAY + "]" + " " + ChatColor.GRAY + player.getDisplayName() + ": " + message);
        } else {
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(player.getName()));

        event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RESET + prefix + ChatColor.DARK_GRAY + "]"  + " " + ChatColor.GRAY + player.getDisplayName() + ": "  + message);
        }
    }
}
