package dk.muj.derius.fishing;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;

import com.massivecraft.massivecore.util.MUtil;

import dk.muj.derius.api.ability.AbilityDurabilityMultiplier;
import dk.muj.derius.api.skill.Skill;

public class CarefulFishing extends AbilityDurabilityMultiplier
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
   
	private static CarefulFishing i = new CarefulFishing();
	public static CarefulFishing get() { return i; }
	private CarefulFishing()
	{
		this.setName("Careful Fishing");
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Skill getSkill()
	{
		return FishingSkill.get();
	}

	@Override
	public String getId()
	{
		return "derius:fishing:careful";
	}

	private static final List<Material> types = MUtil.list(Material.FISHING_ROD);
	@Override
	public Collection<Material> getToolTypes()
	{
		return types;
	}
	
	@Override
	public Map<Integer, Double> getDurabilityMultiplier()
	{
		return FishingSkill.getDurabilityMultiplier();
	}
	
	@Override
	public String getToolName()
	{
		return "Fishing Rod";
	}
	
}
