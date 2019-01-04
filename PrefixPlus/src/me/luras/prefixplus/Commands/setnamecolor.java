package me.luras.prefixplus.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.luras.prefixplus.Main;

public class setnamecolor implements CommandExecutor {
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("consolenotallowed"));
            return false;
        }
		
		 Player player = (Player) sender;
		 
		 if (args.length < 2) {
	        	player.sendMessage(ChatColor.RED + "Invalid Usage");
	        	player.sendMessage(ChatColor.RED + "Usage: /setnamecolor <&colorcode(s)> <player>");
	        	return false;
		 } else if(args.length > 2) {
			 	player.sendMessage(ChatColor.RED + "Invalid Usage");
	        	player.sendMessage(ChatColor.RED + "Usage: /setnamecolor <&colorcode(s)> <player>");
	        	return false;
	     }
		 
		 String NameColor = ChatColor.translateAlternateColorCodes('&', args[0]);
		 
		 Player target = Bukkit.getPlayer(args[1]);

         if(target == null){
             player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("findplayererror")));
             return false;
         }
         
         if (cmd.getName().equalsIgnoreCase("setnamecolor")) {
         	if(player.hasPermission("prefixplus.setnamecolor")) {
         		  plugin.getConfig().set(target.getName() + "_NAMECOLOR", NameColor);
         		  plugin.saveConfig();
         		 player.sendMessage(ChatColor.GREEN + "[Prefix+] You have successfully changed " + target.getName() + "'s NameColor");
                 return true;
         	} else {
        		player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
        		return false;
        	}
         }
		return false;
	}

}
