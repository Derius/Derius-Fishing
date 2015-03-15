package dk.muj.derius.fishing;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.massivecraft.massivecore.EngineAbstract;

import dk.muj.derius.api.DeriusAPI;
import dk.muj.derius.api.VerboseLevel;
import dk.muj.derius.api.player.DPlayer;
import dk.muj.derius.api.util.AbilityUtil;
import dk.muj.derius.api.util.SkillUtil;

public class EngineFishing extends EngineAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
   
	private static EngineFishing i = new EngineFishing();
	public static EngineFishing get() { return i; }
	private EngineFishing() { }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Plugin getPlugin()
	{
		return DeriusFishing.get();
	}

	// -------------------------------------------- //
	// EVENT
	// -------------------------------------------- //
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void giveExp_and_Rewards(PlayerFishEvent event)
	{	
		// Get objects
		Player player = event.getPlayer();
		DPlayer dplayer = DeriusAPI.getDPlayer(player);
		Entity caught = event.getCaught();
		
		if (event.getState() != State.CAUGHT_FISH) return;
		
		List<ItemStack> items = DeriusFishing.getRewardMixin().getRewards(dplayer, event);
		if (AbilityUtil.activateAbility(dplayer, TreasureFishing.get(), items, VerboseLevel.ALWAYS) != AbilityUtil.CANCEL)
		{
			items.forEach(item -> caught.getWorld().dropItemNaturally(caught.getLocation(), item));
		}
		
		// Exp gain
		if (SkillUtil.canPlayerLearnSkill(dplayer, FishingSkill.get(), VerboseLevel.HIGH))
		{
			dplayer.addExp(FishingSkill.get(), FishingSkill.getExpGain());
		}
	}
	
}
