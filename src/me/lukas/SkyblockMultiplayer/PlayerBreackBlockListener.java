package me.lukas.skyblockmultiplayer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreackBlockListener implements Listener {

	SkyblockMultiplayer plugin;

	public PlayerBreackBlockListener(SkyblockMultiplayer instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getPlayer().getWorld().equals(SkyblockMultiplayer.getSkyblockIslands())) { // Pr�fe ob der Spieler in SkyblockMultiplayer ist
			if (event.getBlock().getLocation().getBlockX() >= -20 && event.getBlock().getLocation().getBlockX() <= 20) {
				if (event.getBlock().getLocation().getBlockZ() >= -20 && event.getBlock().getLocation().getBlockZ() <= 20) {
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.RED + "You can not break that block!");
					return;
				}
			}
		}
	}
}
