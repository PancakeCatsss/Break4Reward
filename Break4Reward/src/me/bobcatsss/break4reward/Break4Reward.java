package me.bobcatsss.break4reward;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.bobcatsss.break4reward.commands.CommandReload;
import me.bobcatsss.break4reward.handlers.BlockBreakHandler;
import me.bobcatsss.break4reward.reward.RewardManager;

public class Break4Reward extends JavaPlugin {

    private RewardManager manager;
    
    public void onEnable() {
        saveDefaultConfig();
        manager = new RewardManager(this);
        registerHandlers();
        registerCommands();
    }
    
    private void registerCommands() {
        getCommand("break4reward").setExecutor(new CommandReload(manager));
    }
    
    private void registerHandlers() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockBreakHandler(manager), this);
    }
}
