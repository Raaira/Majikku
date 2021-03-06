package com.gmail.lynx7478.majikku.player;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.gmail.lynx7478.majikku.CAD;

public class MajikkuPlayer 
{
	
	private OfflinePlayer bukkitPlayer;
	private String name;
	private int level;
	private double power;
	private double basePower;
	private CAD[] cads;
	private boolean cooling;
	
	public MajikkuPlayer(Player p)
	{
		this.bukkitPlayer = p;
		this.name = p.getName();
		
		this.level = 1;
		this.power = 50.0;
		this.basePower = 50.0;
		this.cads = new CAD[8];
	}
	
	public MajikkuPlayer(OfflinePlayer p, int level, double power, double basePower,  CAD[] cads)
	{
		this.bukkitPlayer = p;
		this.name = p.getName();
		
		this.level = level;
		this.power = power;
		this.cads = cads;
		this.basePower = basePower;

		// The player isn't on cooldown at start.
		//TODO: Cooldown varies on the level of the player.
		/* Cooldown diminishes or becomes larger varying on the player, will get the values later.
		i.e: Level 1 makes the cooldown larger by 50%, multiply cooldown times 1.5.
		 */
		cooling = false;
	}
	
	public OfflinePlayer getPlayer()
	{
		return bukkitPlayer;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public double getPower()
	{
		return power;
	}
	
	public double getBasePower()
	{
		return basePower;
	}
	
	public CAD[] getCADs()
	{
		return cads;
	}

	public boolean isCooling()
	{
		return cooling;
	}

	public void setCooling(boolean cooling)
	{
		this.cooling = cooling;
	}
	
	@SuppressWarnings("deprecation")
	public boolean hasCADInHand()
	{
		if(bukkitPlayer.getPlayer().getItemInHand() != null && bukkitPlayer.getPlayer().getItemInHand().getType() != Material.AIR)
		{
			if(bukkitPlayer.getPlayer().getItemInHand().hasItemMeta())
			{
				if(bukkitPlayer.getPlayer().getItemInHand().getItemMeta().getLore().contains(ChatColor.AQUA + "CAD"))
				{
					return true;
				}
			}
		}
		return false;
	}

}
