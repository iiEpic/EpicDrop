package net.unknown.epicdrop;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	
	// Mob Names
		public static List<String> Mobs = new ArrayList<String>();
		
		
		/**Adds Mobs Name to a list to check for Drops/Healths/Etc. */
		public static void addMobNames(){
			Mobs.add("BAT");
			Mobs.add("BLAZE");
			Mobs.add("CAVE_SPIDER");
			Mobs.add("CHICKEN");
			Mobs.add("COW");
			Mobs.add("CREEPER");
			Mobs.add("ENDER_DRAGON");
			Mobs.add("ENDERMAN");
			Mobs.add("ENDERMITE");
			Mobs.add("GHAST");
			Mobs.add("GIANT");
			Mobs.add("GUARDIAN");
			Mobs.add("HORSE");
			Mobs.add("IRON_GOLEM");
			Mobs.add("MAGMA_CUBE");
			Mobs.add("MUSHROOM_COW");
			Mobs.add("OCELOT");
			Mobs.add("PIG");
			Mobs.add("PIG_ZOMBIE");
			Mobs.add("PLAYER");
			Mobs.add("RABBIT");
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
		
		
		/**Checks to see if said Mob is in the List
		 * @return True = Found</br>False = Not Found*/
		public static boolean checkMob(String mob){
			 
			if(Mobs.contains(mob)){
				return true;
			}
			
			return false;
		}

}
