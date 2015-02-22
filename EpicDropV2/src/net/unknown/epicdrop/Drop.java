package net.unknown.epicdrop;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class Drop {
		 
	public ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		 
	public Drop() {  
	}
		 
	/**
	* Add an item
	 * @return 
	*/
	public void add(ItemStack drops) {
		items.add(drops);
	}
		 
	/**
	* Drop the items defined
	 * @return 
	*/
	public void drop() {
	// do your dropping code but loop over the array
	}
		 
	}
