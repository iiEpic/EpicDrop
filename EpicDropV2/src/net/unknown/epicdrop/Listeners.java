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
		
		if(Globals.HealthRegen){
			regenHealth(p, e);
		}
		
		
		if(Globals.MoneyDrop){
			Player pl = Bukkit.getPlayer(p.getUniqueId());
			MobDeath.addMoney(e.getEntityType(), pl, e);
		}
		
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
		
		String MobName = e.getEntityType().name();
		Environment Environment = e.getEntity().getWorld().getEnvironment();
		
		MobSpawn.checkMob(e.getEntity(), MobName, Environment);
		
		if(Globals.Debug){
			Bukkit.broadcastMessage("[Debug]: " + e.getEntityType().name());
		}
		
	}
	
	
	public void regenHealth(Player p, EntityDeathEvent e){
		
		Damageable dp = p; //Sets Player to Damageable to get Health
	    double oldHealth = dp.getHealth(); //Sets oldHealth Variable to players current health
	    double addedHealth = Core.plugin.getConfig().getDouble("eDrop.Mobs." + e.getEntityType().name() + ".RegenAmt");
		
	    double newHealth = oldHealth + addedHealth;
	    
	    if(newHealth >= 20.0){
	    	newHealth = 20.0;
	    }
	    p.setHealth(newHealth);
	    
	    if(Globals.HRMessages && newHealth != oldHealth){
	    	p.sendMessage("Your health regenerated a little!");
	    }
		
	}
	
}
