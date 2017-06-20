package me.luras.prefixplus.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.luras.prefixplus.Main;

public class Prefix implements CommandExecutor {

	private static Main plugin = Main.getPlugin(Main.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Player can only use this command!");
			return true;
		}
		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("prefix")) {
			if (args.length == 0) {
				for (String msg : plugin.getConfig().getStringList("prefix-help")) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
				}
			}
		}
		return true;
	}
}
