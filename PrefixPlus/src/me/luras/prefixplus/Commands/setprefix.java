package me.luras.prefixplus.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.luras.prefixplus.Main;
import me.luras.prefixplus.Listeners.PlayerChatListener;

public class setprefix implements CommandExecutor  {

        private Plugin plugin = Main.getPlugin(Main.class);
		Prefix prefix = new Prefix();
		PlayerChatListener chat = new PlayerChatListener();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("consolenotallowed"));
            return false;
        }
        
        Player player = (Player) sender;  
        
        if (args.length < 2) {
        	player.sendMessage(ChatColor.RED + "Invalid Usage");
        	player.sendMessage(ChatColor.RED + "Usage: /setprefix <prefix> <player>");
        	return false;
        } else if(args.length > 2) {
        	player.sendMessage(ChatColor.RED + "Invalid Usage");
        	player.sendMessage(ChatColor.RED + "Usage: /setprefix <prefix> <player>");
        	return false;
        }
        String prefix = ChatColor.translateAlternateColorCodes('&', args[0]);
        
        Player target = Bukkit.getPlayer(args[1]);
        
        
         if(target == null){
             player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("findplayererror")));
             return false;
         }
        
        if (cmd.getName().equalsIgnoreCase("setprefix")) {
        	if(player.hasPermission("prefixplus.setprefix")) {
                plugin.getConfig().set(target.getName(), prefix);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GREEN + "[Prefix+] You have successfully changed your prefix to: " + prefix);
                return true;
        	} else {
        		player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
        		return false;
        	}
        }
		return false;
    }
}