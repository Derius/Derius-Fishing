package dk.muj.derius.fishing.reward;

import org.bukkit.inventory.ItemStack;

public class Reward
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private ItemStack item;
	public ItemStack getItem() { return item; }
	public void setItem(ItemStack item) { this.item = item; }
	
	private int minimumLevel;
	public int getMinimumLevel() { return minimumLevel; }
	public void setMinimumLevel(int minimumLevel) { this.minimumLevel = minimumLevel; }
	
	private int maximumLevel;
	public int getMaximumLevel() { return maximumLevel; }
	public void setmMaximumLevel(int maximumLevel) { this.maximumLevel = maximumLevel; }
	
	// Chance is between 0.0 and 1.0
	private double chance;
	public double getChance() { return chance; }
	public void setChance(double chance) { this.chance = chance; }
	
	private int expGain = 0;
	public int getExpGain() { return expGain; }
	public void setExpGain(int expGain) { this.expGain = expGain; }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	// GSON
	public Reward()
	{
		this.item = null;
		this.minimumLevel = 0;
		this.maximumLevel = 0;
		this.chance = 0.0;
	}
	
	public Reward(ItemStack item, int minimumLevel, int maximumLevel, double chance)
	{
		this.item = item;
		this.minimumLevel = minimumLevel;
		this.chance = chance;
	}
	
}
