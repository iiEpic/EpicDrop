package net.unknown.epicdrop;

import org.bukkit.World.Environment;
import org.bukkit.entity.LivingEntity;

public class MobSpawn {

	public static void checkMob(LivingEntity LV, String Mob, Environment Env){
		double Max = 0.0;
		
		if(Env.equals(Environment.NORMAL)){
			if(!Globals.CustomHealthNormal){return;}
			
			Max = getCustomHealthNormal(Mob);
			
		}else if(Env.equals(Environment.NETHER)){
			if(!Globals.CustomHealthNether){return;}
			
			Max = getCustomHealthNether(Mob);
		}
		
		LV.setMaxHealth(Max);
		LV.setHealth(Max/2);
		
	}
	
	
	public static double getCustomHealthNether(String mob){
		double CustomHealthNether = 0;
		CustomHealthNether = Core.plugin.getConfig().getDouble("eDrop.Mobs." + mob + ".CustomHealth.Nether");
		
		return CustomHealthNether;
	}
	
	public static double getCustomHealthNormal(String mob){
		double CustomHealthNormal = 0;
		CustomHealthNormal = Core.plugin.getConfig().getDouble("eDrop.Mobs." + mob + ".CustomHealth.Normal");
		
		return CustomHealthNormal;
	}
}
