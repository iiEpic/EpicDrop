package net.unknown.epicdrop;

import java.util.ArrayList;
import java.util.List;

public class ItemsMobs {

	
	// Mob Names
		public static List<String> Mobs = new ArrayList<String>();
		
		public static void addMobNames(){
			Mobs.add("BAT");
			Mobs.add("BLAZE");
			Mobs.add("CAVE_SPIDER");
			Mobs.add("CHICKEN");
			Mobs.add("COW");
			Mobs.add("CREEPER");
			Mobs.add("ENDER_DRAGON");
			Mobs.add("ENDERMAN");
			Mobs.add("GHAST");
			Mobs.add("GIANT");
			Mobs.add("HORSE");
			Mobs.add("IRON_GOLEM");
			Mobs.add("MAGMA_CUBE");
			Mobs.add("MUSHROOM_COW");
			Mobs.add("OCELOT");
			Mobs.add("PIG");
			Mobs.add("PIG_ZOMBIE");
			Mobs.add("PLAYER");
			Mobs.add("SHEEP");
			Mobs.add("SILVERFISH");
			Mobs.add("SKELETON");
			Mobs.add("SLIME");
			Mobs.add("SNOWMAN");
			Mobs.add("SPIDER");
			Mobs.add("SQUID");
			Mobs.add("VILLAGER");
			Mobs.add("WITCH");
			Mobs.add("WITHER");
			Mobs.add("WITHER_SKELETON");
			Mobs.add("WOLF");
			Mobs.add("ZOMBIE");
		}
		
		public static boolean checkMob(String mob){
			 
			if(Mobs.contains(mob)){
				return true;
			}
			
			return false;
		}
	
	// Items
		
}
