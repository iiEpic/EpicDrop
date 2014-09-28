package net.unknown.epicdrop;

import org.bukkit.World.Environment;
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
		
		//Bukkit.broadcastMessage("[Debug]: " + e.getEntityType().name());
		
	}
	
}
