package dk.muj.derius.fishing;

import java.util.List;
import java.util.Optional;

import org.bukkit.inventory.ItemStack;

import dk.muj.derius.api.ability.AbilityAbstract;
import dk.muj.derius.api.player.DPlayer;
import dk.muj.derius.api.skill.Skill;

public class TreasureFishing extends AbilityAbstract<List<ItemStack>>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
   
	private static TreasureFishing i = new TreasureFishing();
	public static TreasureFishing get() { return i; }
	private TreasureFishing()
	{
		this.setDesc("Fish treasures");
		
		this.setName("Treasure Fishing");
		
		this.setType(AbilityType.PASSIVE);
		
		this.setCooldownMillis(-1);
	}
	
	@Override
	public String getId()
	{
		return "derius:fishing:treasure";
	}
	
	@Override
	public Skill getSkill()
	{
		return FishingSkill.get();
	}
	
	@Override
	public Optional<String> getLvlDescriptionMsg(int lvl)
	{
		return Optional.empty();
	}
	
	@Override
	public Object onActivate(DPlayer dplayer, List<ItemStack> other)
	{
		return other;
	}
	
	@Override
	public void onDeactivate(DPlayer dplayer, Object other)
	{

	}


}
