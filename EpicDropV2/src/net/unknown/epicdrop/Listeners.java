package net.unknown.epicdrop;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Listeners implements Listener{

	@EventHandler
    public void onMobDeath(EntityDeathEvent e){
		Player p = (Player)e.getEntity().getKiller();
		
		if(p == null){return;}
		if(!Globals.Enabled){return;}
		
		//Checks if percentages is enabled and if the percent is within custom amount
		if(Globals.Percentages){
			if(!Globals.PercentCheck(e.getEntityType().name())){
				p.sendMessage(Globals.name + "Mob, " + e.getEntityType().name() + "'s percent is not between 0-100!");
				return;
			}
		}
		
		//Checks if HealthRegen is enabled
		if(Globals.HealthRegen){
			regenHealth(p, e);
		}
		
		//Check if MoneyDrop is enabled
		if(Globals.MoneyDrop){
			Player pl = Bukkit.getPlayer(p.getUniqueId());
			MobDeath.addMoney(e.getEntityType(), pl, e); //Adds money to players account according to MobDeath.addmoney result
		}
		
		//Checks to see if Inventory Placing is enabled or not
		if(Globals.InventoryPlacing){
			MobDeath.checkMobInventoy(e.getEntityType(), p, e);
			return;
		}else{
			MobDeath.checkMobDrop(e.getEntityType(), e, p);
			return;
		}
		
    }
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e){
		if(!Globals.Enabled){return;}
		
		String MobName = e.getEntityType().name(); //Sets the spawned mob to MobName
		Environment Environment = e.getEntity().getWorld().getEnvironment(); //Sets the spawned mobs environment to Environment
		
		MobSpawn.checkMob(e.getEntity(), MobName, Environment); //Checks to see if CustomHealth is enabled and what the health should be
		
	}
	
	//Health Regeneration Method
	public void regenHealth(Player p, EntityDeathEvent e){
		
		Damageable dp = p; //Sets Player to Damageable to get Health
	    double oldHealth = dp.getHealth(); //Sets oldHealth Variable to players current health
	    double addedHealth = Core.plugin.getConfig().getDouble("eDrop.Mobs." + e.getEntityType().name() + ".RegenAmt"); //Retrieves regen amount
		
	    double newHealth = oldHealth + addedHealth; //Creates new health
	    
	    //Checks to see if NewHealth is over the Maximum of 20.0
	    if(newHealth >= 20.0){
	    	newHealth = 20.0;
	    }
	    
	    p.setHealth(newHealth); //Sets players new health
	    
	    
	    //Checks if HealthRegen messages are enabled and the old health doesn't equal the new health
	    if(Globals.HRMessages && newHealth != oldHealth){
	    	
	    	// Debug message shows how much health was added
	    	if(Globals.Debug){
		    	p.sendMessage(Globals.Debug("Health Regen by " + addedHealth));
		    }
	    	
	    	p.sendMessage("Your health regenerated a little!");
	    }
		
	}
	
}
