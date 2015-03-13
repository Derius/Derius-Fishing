package dk.muj.derius.fishing.reward;

import java.util.List;

import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import dk.muj.derius.api.player.DPlayer;

public interface RewardMixin
{
	public List<ItemStack> getRewards(DPlayer dplayer, PlayerFishEvent event);
	
}
