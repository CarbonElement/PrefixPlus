package me.luras.prefixplus;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.luras.prefixplus.Commands.Prefix;

public class Main extends JavaPlugin {

	public static Plugin getPlugin;

	public void onEnable() {
		getPlugin = this;
		getCommand("prefix").setExecutor(new Prefix());
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}

}
