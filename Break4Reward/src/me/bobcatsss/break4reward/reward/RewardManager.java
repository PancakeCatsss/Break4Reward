package me.bobcatsss.break4reward.reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.GameMode;
import org.bukkit.Material;

import me.bobcatsss.break4reward.Break4Reward;

public class RewardManager {
	
    private final Break4Reward plugin;
    private GameMode requiredGameMode = GameMode.SURVIVAL;
    private List<Material> requiredTool = new ArrayList<>();
    private Map<Material, Reward> rewards = new HashMap<>();
    
    public RewardManager(final Break4Reward pl) {
        plugin = pl;
        loadConfig();
    }
    
    public boolean hasReward(Material material) {
        return rewards.containsKey(material);
    }
    
    public Reward getReward(Material material) {
        return rewards.get(material);
    }
    
    public GameMode getRequiredGameMode() {
        return requiredGameMode;
    }
    
    public boolean requiresGameMode() {
        return requiredGameMode != null;
    }
    
    public boolean requiresTool() {
        return !requiredTool.isEmpty();
    }
    
    public boolean isValidTool(final Material material) {
        return requiredTool.contains(material);
    }
    
    public void reloadConfig() {
        rewards.clear();
        plugin.reloadConfig();
        loadConfig();
    }
    
    private void loadConfig() {
        List<String> tools = plugin.getConfig().getStringList("Required-Tool");
        for (String tool : tools) {
            if (!isValidMaterial(tool)) {
                plugin.getLogger().log(Level.WARNING, "Unable to load required tool: tool.");
                plugin.getLogger().log(Level.WARNING, "The Material " + tool + " is not valid.");
                continue;
            }
            requiredTool.add(Material.valueOf(tool));
        }
        if (plugin.getConfig().isSet("Required-GameMode")) {
            String gameMode = plugin.getConfig().getString("Required-GameMode");
            if (gameMode.equalsIgnoreCase("none") || !isValidGameMode(gameMode)) {
                requiredGameMode = null;
            } else {
                requiredGameMode = GameMode.valueOf(gameMode);
            }
        }
        if (!plugin.getConfig().isConfigurationSection("Rewards")) return;
        for (String key : plugin.getConfig().getConfigurationSection("Rewards").getKeys(false)) {
            if (!isValidMaterial(key)) {
                plugin.getLogger().log(Level.WARNING, "The Material " + key + " is not valid.");
                continue;
            }
            Material material = Material.valueOf(key);
            rewards.put(material, new Reward(plugin.getConfig().getStringList("Rewards." + key + ".Commands"), plugin.getConfig().getString("Rewards." + key + ".Message", null)));
        }
    }
    
    private boolean isValidGameMode(String gameMode) {
    	for(GameMode mode : GameMode.values()) {
    		if(mode.name().equalsIgnoreCase(gameMode)) return true;
    	}
    	return false;
    }
    
    private boolean isValidMaterial(final String material) {
    	for(Material mat : Material.values()) {
    		if(mat.name().equalsIgnoreCase(material)) return true;
    	}
    	return false;
    }

}
