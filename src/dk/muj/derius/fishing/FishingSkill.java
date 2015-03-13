package dk.muj.derius.fishing;

import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.xlib.gson.reflect.TypeToken;

import dk.muj.derius.api.skill.SkillAbstract;
import dk.muj.derius.fishing.reward.Reward;

public class FishingSkill extends SkillAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static FishingSkill i = new FishingSkill();
	public static FishingSkill get() { return i; }
	
	public FishingSkill()
	{		
		this.setName("Fishing");
		this.setDesc("Makes you able to fish up treasures");
		this.setIcon(Material.FISHING_ROD);
		this.addEarnExpDescs("Fish fish & treasures");
			
		this.writeConfig(Const.JSON_EXP_GAIN, 200);
		
		this.writeConfig(Const.JSON_CAREFUL_FISHING, MUtil.map(
				0, 0.5,
				1000, 1.5,
				2000, 3.0), new TypeToken<Map<Integer, Double>>(){});
		
		this.writeConfig(Const.JSON_REWARDS, MUtil.list(
				new Reward(new ItemStack(Material.APPLE), 0, 500, 0.05)
				), new TypeToken<List<Reward>>(){});
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public String getId() 
	{
		return "derius:fishing";
	}
	

	@Override
	public Plugin getPlugin()
	{
		return DeriusFishing.get();
	}
	
	// -------------------------------------------- //
	// CONFIG
	// -------------------------------------------- //

	public static int getExpGain()
	{
		return get().readConfig(Const.JSON_EXP_GAIN, Integer.TYPE);
	}

	public static Map<Integer, Double> getDurabilityMultiplier()
	{
		return get().readConfig(Const.JSON_CAREFUL_FISHING, new TypeToken<Map<Integer, Double>>(){});
	}
	
	public static List<Reward> getRewards()
	{
		return get().readConfig(Const.JSON_REWARDS, new TypeToken<List<Reward>>(){});
	}

}
