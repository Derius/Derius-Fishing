package dk.muj.derius.fishing.reward;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.massivecore.util.MUtil;

import dk.muj.derius.api.player.DPlayer;
import dk.muj.derius.fishing.FishingSkill;

public class RewardMixinDefault implements RewardMixin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static RewardMixinDefault i = new RewardMixinDefault();
	public static RewardMixinDefault get() { return i; }
	public RewardMixinDefault() {}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public List<ItemStack> getRewards(DPlayer dplayer, PlayerFishEvent event)
	{
		List<ItemStack> ret = new ArrayList<>();
		
		for (Reward reward : FishingSkill.getRewards())
		{
			// Level must match
			if (reward.getMinimumLevel() > dplayer.getLvl(FishingSkill.get())) continue;
			if (reward.getMaximumLevel() < dplayer.getLvl(FishingSkill.get())) continue;
			
			// And they must be lucky.
			if (MUtil.probabilityRound(reward.getChance()) == 0) continue;
			
			ret.add(reward.getItem());
		}
		
		return ret;
	}
	
}
