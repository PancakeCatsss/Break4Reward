package me.bobcatsss.break4reward.reward;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.bobcatsss.break4reward.utils.ChatUtils;

public class Reward {

    private List<String> commands;
    private String playerMessage;
    
    public Reward(List<String> cmds, String message) {
        commands = new ArrayList<String>();
        playerMessage = message;
        commands = cmds;
    }
    
    public void run(final Player player) {
        commands.forEach(str -> Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), str.replace("{player}", player.getName())));
        if (playerMessage != null) {
            player.sendMessage(ChatUtils.color(playerMessage));
        }
    }
}
