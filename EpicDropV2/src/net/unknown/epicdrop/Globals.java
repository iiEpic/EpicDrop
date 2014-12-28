package net.unknown.epicdrop;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;

public class Globals {

	public static int Player;
	
	public static int MajorBuild = 1;
	public static int MinorBuild = 3;
	public static int Revision = 0;
	public static String Build = "002-20141227-1915";
	public static String Special = "1.8 Update!";
	public static String name = "[" + ChatColor.DARK_GRAY + "Epic" + ChatColor.LIGHT_PURPLE + "Drop" + ChatColor.RESET + "] ";
	
	// Command Variables //
	public static boolean Enabled;
	public static boolean InventoryPlacing;
	public static boolean BothDrops;
	public static boolean PlayerDrops;
	public static boolean ResetAll;
	public static boolean Setup;
	public static boolean Debug;
	public static boolean CustomHealthNormal;
	public static boolean CustomHealthNether;
	public static boolean MoneyDrop;
	public static boolean MDMessages;
	public static boolean HealthRegen;
	public static boolean HRMessages;
	
	// Economy Vault Variables
	public static Economy economy = null;
	public static boolean VaultEnabled;
	
	
	/** Displays the Version (4 Formats)
	 * @param type The different format of how Version is displayed.
	 * @return Version Message.
	 * */
	public static String Version(int type){
		
		String VM = "";
		
		switch(type){
		case 1:
			VM = MajorBuild + "." + MinorBuild + "." + Revision;
			break;
		case 2:
			VM = "v" + MajorBuild + "." + MinorBuild + "." + Revision;;
			break;
		case 3:
			VM = "[Version] " + MajorBuild + "." + MinorBuild + "." + Revision;
			break;
		case 4:
			if(Special != ""){
				VM = "[Version] " + MajorBuild + "." + MinorBuild + "." + Revision + "\nBuild: " + Build + "\nSpecial: " + Special;
			}else{
				VM = "[Version] " + MajorBuild + "." + MinorBuild + "." + Revision + "\nBuild: " + Build;
			}
			break;
		}
		
		return VM;
	}
	
	//Debug Method
	public static String Debug(String message){
		message = Globals.name + "[Debug] " + message;
		return message;
	}
	
}
