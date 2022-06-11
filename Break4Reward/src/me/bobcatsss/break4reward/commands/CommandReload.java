package me.bobcatsss.break4reward.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.bobcatsss.break4reward.reward.RewardManager;
import me.bobcatsss.break4reward.utils.ChatUtils;

public class CommandReload implements CommandExecutor {
	
    private final RewardManager manager;
    
    public CommandReload(final RewardManager rewardManager) {
        this.manager = rewardManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (!sender.hasPermission("break4reward.command.reload")) {
            sender.sendMessage(ChatUtils.color("&cYou don't have permission to use this command&f."));
            return true;
        }
        manager.reloadConfig();
        sender.sendMessage(ChatUtils.color("&7[&aBreak4Reward&7] &2Config has been reloaded&f."));
        return true;
    }
}
