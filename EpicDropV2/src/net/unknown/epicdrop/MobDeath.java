package net.unknown.epicdrop;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MobDeath {
	/*
	public HashMap<String,Player> tmp = new HashMap<String, Player>(); // A Hashmap that can store players by their username to lookup
	
	public void addUser(String playerName, Player pl) {
		if(!tmp.containsKey(playerName)) // checks if the player exists in the hashmap.
			tmp.put(playerName, pl); // Adds the element to the hashmap
			
	}
	*/
	
	// Adds to mob drop
	public static void checkMobDrop(EntityType Entity, EntityDeathEvent e, Player p){
		FileConfiguration gc = Core.plugin.getConfig();
		
		if(Entity.equals(EntityType.PLAYER)){
			if(!Globals.PlayerDrops){e.getDrops().clear();}
		}else{
			if(!Globals.BothDrops){ e.getDrops().clear(); };
		}
		
		if(Globals.Debug){
			p.sendMessage(Globals.Debug(Entity.name()));
			p.sendMessage(Globals.Debug(gc.getString("eDrop.Mobs." + Entity.name() + ".Item")));
		}
		
		Material 	m = Material.valueOf(gc.getString("eDrop.Mobs." + Entity.name() + ".Item")); 	// Gets Mobs Item
		int 		a = gc.getInt("eDrop.Mobs." + Entity.name() + ".ItemAmount");					// Gets Mobs Item Amount
		
		e.getDrops().add(new ItemStack(m,a)); // Sets the Mobs Drop		
		
	}
	
	// Adds to inventory 
	public static void checkMobInventoy(EntityType Entity, Player p, EntityDeathEvent ede){
		
		PlayerInventory pi = p.getInventory();
		FileConfiguration gc = Core.plugin.getConfig();
		
		if(Entity.equals(EntityType.PLAYER)){
			if(!Globals.PlayerDrops){ede.getDrops().clear();}
		}else{
			if(!Globals.BothDrops){ ede.getDrops().clear(); };
		}
		
		if(Globals.Debug){
			p.sendMessage(Globals.Debug(Entity.name()));
			p.sendMessage(Globals.Debug(gc.getString("eDrop.Mobs." + Entity.name() + ".Item")));
		}
		
		Material m = Material.valueOf(gc.getString("eDrop.Mobs." + Entity.name() + ".Item"));
		int a = gc.getInt("eDrop.Mobs." + Entity.name() + ".ItemAmount");
		
		pi.addItem(new ItemStack(m, a));
		
	}
	
	//Adds money to your account after kill if Enabled
	public static void addMoney(EntityType Entity, Player p, EntityDeathEvent ede){
		
		FileConfiguration gc = Core.plugin.getConfig();
		
		if(Globals.Debug){
			p.sendMessage(Globals.Debug(Entity.name()));
			p.sendMessage(Globals.Debug(gc.getString("eDrop.Mobs." + Entity.name() + ".MoneyDrop")));
		}
		
		Double amount = gc.getDouble("eDrop.Mobs." + Entity.name() + ".MoneyDrop"); //Finds out how much money to give
		
		Globals.economy.depositPlayer(p, amount);
		p.sendMessage(amount + " added to your account!");
		
	}
	
}
