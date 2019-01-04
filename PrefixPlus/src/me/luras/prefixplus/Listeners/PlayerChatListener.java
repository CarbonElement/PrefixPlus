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
        if(!(plugin.getConfig().contains(player.getName())) && !(plugin.getConfig().contains(player.getName() + "_NAMECOLOR"))) {
        	event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("defaultPrefix")) + ChatColor.DARK_GRAY + "]" + " " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("defaultNameColor")) + player.getDisplayName() + ChatColor.RESET + ": " + message);
        	
        } else if (!(plugin.getConfig().contains(player.getName() + "_NAMECOLOR"))) {
        	String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(player.getName()));
        	event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RESET + prefix + ChatColor.DARK_GRAY + "]"  + " " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("defaultNameColor")) + player.getDisplayName() + ChatColor.RESET + ": "  + message);
        } else if (!(plugin.getConfig().contains(player.getName() + ""))) {
        	String configNameColor = player.getName() + "_NAMECOLOR";
        	String NameColor = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(configNameColor));
        	event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("defaultPrefix")) + ChatColor.DARK_GRAY + "]" + " " + NameColor + player.getDisplayName() + ChatColor.RESET + ": " + message);
        } else {
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(player.getName()));
        String configNameColor = player.getName() + "_NAMECOLOR";
        String NameColor = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(configNameColor));
        event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RESET + prefix + ChatColor.DARK_GRAY + "]"  + ChatColor.RESET + " " + NameColor + player.getDisplayName() + ChatColor.RESET + ": "  + message);
        }
    }
    }

