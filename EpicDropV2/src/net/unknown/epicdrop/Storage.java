package net.unknown.epicdrop;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Storage {

	public static HashMap<String, ArrayList<ItemStack>> droplist = new HashMap<String, ArrayList<ItemStack>>();
	 
	 /** Get Mobs Drops and item amount
	 * @return 
	  */
	 public static ArrayList<ItemStack> get(String mobname){
		 return droplist.get(mobname);
	 }
	 
	 /** Adds mob with drops into hashmap to be saved 
	  */
	 public static boolean add(String mobname, ArrayList<ItemStack> drop) {
		 if(droplist.containsKey(mobname)){
			 return false;
		 }
		 droplist.put(mobname, drop);
		 return true;
	 }
	
	 /** Removes mob with drops from hashmap
	  * @return True = Mob Removed </br>False = Mob not found
	  */
	 public static boolean remove(String mobname){
		 if(droplist.containsKey(mobname)){
			 droplist.remove(mobname);
			 return true;
		 }
		 return false;
	 }
	 
	 /** Creates an ItemStack
	 * @return 
	  */
	 @SuppressWarnings("null")
	public static ArrayList<ItemStack> createItemStack(Material item, int amount) {
		 ArrayList<ItemStack> items = null;
		 items.add(new ItemStack(item,amount));
		return items;
	 }
	 
}
