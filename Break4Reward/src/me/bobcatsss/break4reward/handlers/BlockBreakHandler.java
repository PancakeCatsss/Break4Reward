package me.bobcatsss.break4reward.handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.bobcatsss.break4reward.reward.RewardManager;

public class BlockBreakHandler implements Listener {

	private final RewardManager manager;
	public BlockBreakHandler(RewardManager rewardManager) {
		this.manager = rewardManager;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBreak(BlockBreakEvent event) {
		if(event.isCancelled()) return;
		Player player = event.getPlayer();
		ItemStack inHand = player.getInventory().getItemInMainHand();
		if(manager.requiresTool() && !manager.isValidTool(inHand.getType())) return;
		if(manager.requiresGameMode() && manager.getRequiredGameMode() != player.getGameMode()) return;
		Material material = event.getBlock().getType();
		if(!manager.hasReward(material)) return;
		manager.getReward(material).run(event.getPlayer());
	}
}
