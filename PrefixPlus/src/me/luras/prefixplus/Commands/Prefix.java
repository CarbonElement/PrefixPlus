package me.luras.prefixplus.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.luras.prefixplus.Main;
import me.luras.prefixplus.Utility.MessageManager;

public class Prefix implements CommandExecutor {

	private static Main plugin = Main.getPlugin(Main.class);
	MessageManager msgManager = new MessageManager();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("consolenotallowed"));
			return true;
		}
		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("prefix")) {
			if(player.hasPermission("prefixplus.prefix")) {
				if (args.length == 0) {
					msgManager.sendPlayerHelpMessage(player);
				} else if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
						if(player.hasPermission("prefixplus.reload")) {
						plugin.reloadConfig();
						player.sendMessage(ChatColor.GREEN + "[Prefix+] Config has been reloaded");
						msgManager.consoleMessage(ChatColor.GREEN + "[Prefix+] Config has been reloaded");
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[Prefix+] &4You don't have permission to use this command"));
						}
				}
					
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[Prefix+] &4You don't have permission to use this command"));
				}
			}
		return true;
	}
}
