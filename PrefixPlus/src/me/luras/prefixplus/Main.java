package me.luras.prefixplus;

import org.bukkit.plugin.java.JavaPlugin;

import me.luras.prefixplus.Commands.Prefix;
import me.luras.prefixplus.Commands.setnamecolor;
import me.luras.prefixplus.Commands.setprefix;
import me.luras.prefixplus.Listeners.PlayerChatListener;
import me.luras.prefixplus.Utility.MessageManager;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		MessageManager msgMan = new MessageManager();
		
		getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
		
		getCommand("prefix").setExecutor(new Prefix());
		getCommand("setprefix").setExecutor(new setprefix());	
		getCommand("setnamecolor").setExecutor(new setnamecolor());
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		msgMan.consoleMessage(ChatColor.GREEN + "[Prefix+] Prefix+ by MrCoolKhaled has been activated!");
		msgMan.consoleMessage(ChatColor.GREEN + "[Prefix+] Please note that player info and data is stored in the config but that will be changed soon!");
	}
	
	public void onDisable() {
		MessageManager msgMan = new MessageManager();
		msgMan.consoleMessage(ChatColor.GREEN + "[Prefix+] Prefix+ by MrCoolKhaled has been disabled. Please report any errors to CarbonKA#4221 on Discord!");
	}

}
