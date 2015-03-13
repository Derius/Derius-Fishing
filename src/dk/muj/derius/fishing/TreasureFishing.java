package dk.muj.derius.fishing;

import java.util.Optional;

import dk.muj.derius.api.ability.AbilityAbstract;
import dk.muj.derius.api.player.DPlayer;
import dk.muj.derius.api.skill.Skill;

public class TreasureFishing extends AbilityAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
   
	private static TreasureFishing i = new TreasureFishing();
	public static TreasureFishing get() { return i; }
	private TreasureFishing() { }
	
	@Override
	public String getId()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Skill getSkill()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<String> getLvlDescriptionMsg(int lvl)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object onActivate(DPlayer dplayer, Object other)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onDeactivate(DPlayer dplayer, Object other)
	{
		// TODO Auto-generated method stub
		
	}


}
