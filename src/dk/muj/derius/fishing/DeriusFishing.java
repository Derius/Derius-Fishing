package dk.muj.derius.fishing;

import com.massivecraft.massivecore.MassivePlugin;

import dk.muj.derius.fishing.reward.RewardMixin;
import dk.muj.derius.fishing.reward.RewardMixinDefault;

public final class DeriusFishing extends MassivePlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static DeriusFishing i;
	public static DeriusFishing get() { return i; }
	public DeriusFishing() { i = this; }
	
	// -------------------------------------------- //
	// REWARD MIXIN
	// -------------------------------------------- //
	
	private static RewardMixin rewardMixin = RewardMixinDefault.get();
	public static RewardMixin getRewardMixin() { return rewardMixin; }
	public static void setRewardMixin(RewardMixin val) { rewardMixin = val; }
	
	// -------------------------------------------- //
	// OVERRIDE: PLUGIN
	// -------------------------------------------- //
	
	@Override
	public void onEnable()
	{
		if ( ! this.preEnable()) return;
		
		FishingSkill.get().register();
		CarefulFishing.get().register();
		TreasureFishing.get().register();
		
		EngineFishing.get().activate();
		
		this.postEnable();
	}
	
}
