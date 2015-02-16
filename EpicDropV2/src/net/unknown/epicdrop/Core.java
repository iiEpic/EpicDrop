package net.unknown.epicdrop;

import java.io.IOException;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	public static Plugin plugin;
	
	public void getStatus(){
		if(getConfig().getString("eDrop.Enabled") == null){
			getConfig().set("eDrop.Enabled", true);
			getConfig().set("eDrop.InventoryPlacing", true);
			getConfig().set("eDrop.BothDrops", true);
			getConfig().set("eDrop.PlayerDrops", true);
			getConfig().set("eDrop.MoneyDrop", true);
			getConfig().set("eDrop.HealthRegen", true);
			getConfig().set("eDrop.Setup", false);
			getConfig().set("eDrop.ResetAll", true);
			getConfig().set("eDrop.Messages.MoneyDrop", true);
			getConfig().set("eDrop.Messages.HealthRegen", true);
			getConfig().set("eDrop.CustomHealth.Normal", false);
			getConfig().set("eDrop.CustomHealth.Nether", false);
			getConfig().set("eDrop.CustomHealth.The_End", false);
		}
		
		Globals.Enabled 			= getConfig().getBoolean("eDrop.Enabled");
		Globals.InventoryPlacing 	= getConfig().getBoolean("eDrop.InventoryPlacing");
		Globals.BothDrops 			= getConfig().getBoolean("eDrop.BothDrops");
		Globals.PlayerDrops			= getConfig().getBoolean("eDrop.PlayerDrops");
		Globals.MoneyDrop			= getConfig().getBoolean("eDrop.MoneyDrop");
		Globals.MDMessages			= getConfig().getBoolean("eDrop.Messages.MoneyDrop");
		Globals.HealthRegen			= getConfig().getBoolean("eDrop.HealthRegen");
		Globals.HRMessages			= getConfig().getBoolean("eDrop.Messages.HealthRegen");
		Globals.Debug				= false;
		Globals.Setup				= getConfig().getBoolean("eDrop.Setup");
		Globals.ResetAll			= getConfig().getBoolean("eDrop.ResetAll");
		Globals.CustomHealthNormal	= getConfig().getBoolean("eDrop.CustomHealth.Normal");
		Globals.CustomHealthNether	= getConfig().getBoolean("eDrop.CustomHealth.Nether");
		Globals.CustomHealthEnd		= getConfig().getBoolean("eDrop.CustomHealth.The_End");
		
		
	}
	
	public void saveStates(){
		getConfig().set("eDrop.Enabled", Globals.Enabled);
    	getConfig().set("eDrop.InventoryPlacing", Globals.InventoryPlacing);
    	getConfig().set("eDrop.BothDrops", Globals.BothDrops);
    	getConfig().set("eDrop.PlayerDrops", Globals.PlayerDrops);
    	getConfig().set("eDrop.MoneyDrop", Globals.MoneyDrop);
    	getConfig().set("eDrop.HealthRegen", Globals.HealthRegen);
    	getConfig().set("eDrop.Setup", Globals.Setup);
    	getConfig().set("eDrop.Messages.MoneyDrop", Globals.MDMessages);
    	getConfig().set("eDrop.Messages.HealthRegen", Globals.HRMessages);
    	getConfig().set("eDrop.ResetAll", Globals.ResetAll);
    	getConfig().set("eDrop.CustomHealth.Normal", Globals.CustomHealthNormal);
    	getConfig().set("eDrop.CustomHealth.Nether", Globals.CustomHealthNether);
    	getConfig().set("eDrop.CustomHealth.The_End", Globals.CustomHealthEnd);
		
	}
	
    public void onEnable() {
        getConfig();
        plugin = this;
        getStatus();
        MobSettings.Setup();
        PluginManager p = this.getServer().getPluginManager();
        p.registerEvents(new Listeners(), this);
        
        //Add mobs to list
        Lists.addMobNames();
        
        //Checks to see if Vault is installed on server
        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            getLogger().info("Detected Vault!");
            setupEconomy();
            Globals.VaultEnabled = true;
        }else{
        	getLogger().info("Vault wasn't detected!");
        	Globals.MoneyDrop = false;
        	Globals.VaultEnabled = false;
        }
        
        // Runs McStats!
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
        
    }
 
    public void onDisable() {
    	saveStates();
        saveConfig();
    }
    
    
    // Setups Economy for use 
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            Globals.economy = economyProvider.getProvider();
        }

        return (Globals.economy != null);
    }
    
    public static boolean isNumeric(String str)
    {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	// All Below are EpicDrop Commands
		if(label.equalsIgnoreCase("edrop")){
			
			if(args.length <= 0){
				sender.sendMessage(Globals.name +
						"Invalid command. Use the following."
						+ "\n/edrop on \n/edrop off \n/edrop status \n/edrop reload \n/edrop edit"
						+ "\n/edrop inv \n/edrop message \n/edrop moneydrop \n/edrop BothDrops \n/edrop Playerdrops \n/edrop healthregen "
						+ "\n/edrop health \n/edrop resetall \n/edrop debug");
				return true;
				
			}else{
				
				// Turns on eDrop \\
				if(args[0].equalsIgnoreCase("on")){
					if(!Globals.Enabled){
						Globals.Enabled = true;
						sender.sendMessage(Globals.name + "has been Enabled!");
						return true;
					}else{
						sender.sendMessage(Globals.name + "is already Enabled!");
						return true;
					}
					 
				}
				
				// Turns off eDrop \\
				if(args[0].equalsIgnoreCase("off")){
					if(Globals.Enabled){
						Globals.Enabled = false;
						sender.sendMessage(Globals.name + "has been Disabled!");
						return true;
					}else{
						sender.sendMessage(Globals.name + "is already Disabled!");
						return true;
					}
				}
				
				// Show Status of Plugin
				if(args[0].equalsIgnoreCase("status")){
					saveStates();
					getStatus();
					if(args.length > 1){
						if(args[1].equalsIgnoreCase("dev")){
									sender.sendMessage(Globals.Version(4) + "\n"
									+ "Setup: " + CheckState(Globals.Setup) + "\n"
									+ "Debug: " + CheckState(Globals.Debug)
									);
							return true;
						}
					}
					sender.sendMessage(
							"Version: " + Globals.Version(1) + "\n"
						+   "EpicDrop: " + CheckState(Globals.Enabled) + "\n"
						+   "BothDrops: " + CheckState(Globals.BothDrops) + "\n"
						+   "MoneyDrop: " + CheckState(Globals.MoneyDrop) + "\n"
						+	"HealthRegen: " + CheckState(Globals.HealthRegen) + "\n"
						+ 	"PlayerDrops: " + CheckState(Globals.PlayerDrops) + "\n"
						+	"InventoryPlacing: " + CheckState(Globals.InventoryPlacing) + "\n"
						+	"CustomHealth Normal: " + CheckState(Globals.CustomHealthNormal) + "\n"
						+	"CustomHealth Nether: " + CheckState(Globals.CustomHealthNether) + "\n"
						+	"CustomHealth The_End: " + CheckState(Globals.CustomHealthEnd));
					return true; 
				}
				
				// Enables & Disables Drops \\
				if(args[0].equalsIgnoreCase("inv")){
					if(Globals.InventoryPlacing){ 
						Globals.InventoryPlacing = false;
						sender.sendMessage(Globals.name + "Inventory Placing has been Disabled!");
						return true;
					}else{ 
						Globals.InventoryPlacing = true;
						sender.sendMessage(Globals.name + "Inventory Placing has been Enabled!");
						return true;
					}
				}
				
				// Reloads the Config
				if(args[0].equalsIgnoreCase("reload")){
					if(sender.hasPermission("eDrop.Admin.Reload")){
					saveStates();
					reloadConfig();
					getStatus();
					sender.sendMessage(Globals.name + "EpicDrop was reloaded successfully.");
					return true;
					}
				}
				
				//Turns on/off Debugging
				if(args[0].equalsIgnoreCase("Debug")){
					if(Globals.Debug){ 
						Globals.Debug = false;
						sender.sendMessage(Globals.name + "Debugging has been Disabled!");
						return true;
					}else{ 
						Globals.Debug = true;
						sender.sendMessage(Globals.name + "Debugging has been Enabled!");
						return true;
					}
				}
				
				// Turns on/off Default Drops
				if(args[0].equalsIgnoreCase("BothDrops")){
					if(Globals.BothDrops){ 
						Globals.BothDrops = false;
						sender.sendMessage(Globals.name + "Default Drops have been Disabled!");
						return true;
					}else{ 
						Globals.BothDrops = true;
						sender.sendMessage(Globals.name + "Default Drops have been Enabled!");
						return true;
					}
				}
				
				// Turns on/off Health
				if(args[0].equalsIgnoreCase("Health")){
					if(args.length > 1){
						if(args[1].equalsIgnoreCase("Normal")){
							if(Globals.CustomHealthNormal){
								Globals.CustomHealthNormal = false;
								sender.sendMessage(Globals.name + "CustomHealth for Normal world has been disabled!");
								return true;
							}else{
								Globals.CustomHealthNormal = true;
								sender.sendMessage(Globals.name + "CustomHealth for Normal world has been enabled!");
								return true;
							}
						}
						if(args[1].equalsIgnoreCase("Nether")){
							if(Globals.CustomHealthNether){
								Globals.CustomHealthNether = false;
								sender.sendMessage(Globals.name + "CustomHealth for Nether world has been disabled!");
								return true;
							}else{
								Globals.CustomHealthNether = true;
								sender.sendMessage(Globals.name + "CustomHealth for Nether world has been enabled!");
								return true;
							}
						}
						if(args[1].equalsIgnoreCase("End")){
							if(Globals.CustomHealthEnd){
								Globals.CustomHealthEnd = false;
								sender.sendMessage(Globals.name + "CustomHealth for The_End world has been disabled!");
								return true;
							}else{
								Globals.CustomHealthEnd = true;
								sender.sendMessage(Globals.name + "CustomHealth for The_End world has been enabled!");
								return true;
							}
						}
					}else{
						sender.sendMessage(Globals.name + "Please use /edrop health <normal/nether/end>");
						return true;
					}
				}
				
				//Turns on/off Player Drops
				if(args[0].equalsIgnoreCase("PlayerDrops")){
					if(Globals.PlayerDrops){ 
						Globals.PlayerDrops = false;
						sender.sendMessage(Globals.name + "Player Drops have been Disabled!");
						return true;
					}else{ 
						Globals.PlayerDrops = true;
						sender.sendMessage(Globals.name + "Player Drops have been Enabled!");
						return true;
					}
				}
				
				//Turns on/off ResetAll Switch
				if(args[0].equalsIgnoreCase("ResetAll")){
					if(sender.hasPermission("eDrop.Admin.Reload")){
						Globals.ResetAll = true;
						Globals.Setup	= false;
						getConfig().set("eDrop", null);
						saveConfig();
						getStatus();
						MobSettings.Setup();
						saveConfig();
						sender.sendMessage(Globals.name + "Config file has been set back to default.");
						
						return true;
					}
					
				}
				
				//Turn on/off Messages
				if(args[0].equalsIgnoreCase("message")){
					if(args.length >=2){
						if(args[1].equalsIgnoreCase("moneydrop")){
							if(Globals.MDMessages){
								Globals.MDMessages = false;
								sender.sendMessage(Globals.name + "Money Drop messages have been turned off!");
								return true;
							}else{
								Globals.MDMessages = true;
								sender.sendMessage(Globals.name + "Money Drop messages have been turned on!");
								return true;
							}
						}
						if(args[1].equalsIgnoreCase("regen")){
							if(Globals.HRMessages){
								Globals.HRMessages = false;
								sender.sendMessage(Globals.name + "Regen Health messages have been turned off!");
								return true;
							}else{
								Globals.HRMessages = true;
								sender.sendMessage(Globals.name + "Regen Health messages have been turned on!");
								return true;
							}
						}
						
						sender.sendMessage(Globals.name + "Please use /edrop message <moneydrop/regen>");
						return true;
					}
					sender.sendMessage(Globals.name + "Please use /edrop message <moneydrop/regen>");
					return true;
				}
				
				//Turns on/off Money Drops
				if(args[0].equalsIgnoreCase("moneydrop")){
					
					if(!Globals.VaultEnabled){
						sender.sendMessage("You must install Vault on your server to use this command.");
						return true;
					}
					
					if(Globals.MoneyDrop){ 
						Globals.MoneyDrop = false;
						sender.sendMessage(Globals.name + "Money Drops have been Disabled!");
						return true;
					}else{ 
						Globals.MoneyDrop = true;
						sender.sendMessage(Globals.name + "Money Drops have been Enabled!");
						return true;
					}
				}
				
				//Turns on/off HealthRegen
				if(args[0].equalsIgnoreCase("healthregen")){
					if(Globals.HealthRegen){ 
						Globals.HealthRegen = false;
						sender.sendMessage(Globals.name + "HealthRegen has been Disabled!");
						return true;
					}else{ 
						Globals.HealthRegen = true;
						sender.sendMessage(Globals.name + "HealthRegen has been Enabled!");
						return true;
					}
				}
				
				
				//All below are Config Editing Commands
				if(args[0].equalsIgnoreCase("edit")){
					
					
					if(args.length >= 2){
						
						if(Lists.checkMob(args[1].toUpperCase())){
							if(Globals.Debug){
								sender.sendMessage(Globals.Debug(args[1].toUpperCase()));
							}
							if(args.length >= 3){
								
								//Proceed to ask what Item to drop
								if(args[2].equalsIgnoreCase("item")){
									if(Globals.Debug){sender.sendMessage(Globals.Debug("Item"));}
									
									return true;
								}
								
								//Proceed with asking how much of the item to drop
								if(args[2].equalsIgnoreCase("itemamount")){
									if(Globals.Debug){sender.sendMessage(Globals.Debug("ItemAmount"));}
									
									if(args.length >= 4){
										
										int itemAmt;
										if(isNumeric(args[3].toString())){
											itemAmt = Integer.parseInt(args[3]);
										}else{
											sender.sendMessage(Globals.name + "Please enter a valid Number! ie.10");
											return true;
										}
										
											if(itemAmt == (int)itemAmt){
												if(Globals.Debug){sender.sendMessage(Globals.Debug("ItemAmount: " + itemAmt));}
											
												plugin.getConfig().set("eDrop.Mobs." + args[1].toUpperCase() + ".ItemAmount", itemAmt);
												saveConfig();
												sender.sendMessage(Globals.name + "The ItemAmount for " + args[1].toString() + " was changed to " + itemAmt + "!");
												return true;
											}
										}
										sender.sendMessage(Globals.name + "Please enter a valid number!");
										return true;
								}
								
								//Proceed with asking how much money to drop
								if(args[2].equalsIgnoreCase("moneydrop")){
									if(Globals.Debug){sender.sendMessage(Globals.Debug("MoneyDrop"));}
									
									if(args.length >= 4){
										
										int moneyDrop;
										if(isNumeric(args[3].toString())){
											moneyDrop = Integer.parseInt(args[3]);
										}else{
											sender.sendMessage(Globals.name + "Please enter a valid Number! ie.10");
											return true;
										}
										
											if(moneyDrop == (int)moneyDrop){
												if(Globals.Debug){sender.sendMessage(Globals.Debug("MoneyDrop: " + moneyDrop));}
											
												plugin.getConfig().set("eDrop.Mobs." + args[1].toUpperCase() + ".MoneyDrop", moneyDrop);
												saveConfig();
												sender.sendMessage(Globals.name + "The MoneyDrop for " + args[1].toString() + " was changed to " + moneyDrop + "!");
												return true;
											}
										}
										sender.sendMessage(Globals.name + "Please enter a valid number!");
										return true;
								}
								
								//Proceed with asking how much health to regen
								if(args[2].equalsIgnoreCase("regenamt")){
									if(Globals.Debug){sender.sendMessage(Globals.Debug("RegenAmt"));}
									
									if(args.length >= 4){
										
									int regenamt;
									if(isNumeric(args[3].toString())){
										regenamt = Integer.parseInt(args[3]);
									}else{
										sender.sendMessage(Globals.name + "Please enter a valid Number! ie.10");
										return true;
									}
									
										if(regenamt == (int)regenamt){
											if(Globals.Debug){sender.sendMessage(Globals.Debug("RegenAmt: " + regenamt));}
										
											plugin.getConfig().set("eDrop.Mobs." + args[1].toUpperCase() + ".RegenAmt", regenamt);
											saveConfig();
											sender.sendMessage(Globals.name + "The RegenAmt for " + args[1].toString() + " was changed to " + regenamt + "!");
											return true;
										}
									}
									sender.sendMessage(Globals.name + "Please enter a valid number!");
									return true;
								}
								
								//Proceed with asking how much health
								if(args[2].equalsIgnoreCase("health")){
									if(Globals.Debug){sender.sendMessage(Globals.Debug("Health"));}
									
									int health;
									if(isNumeric(args[3].toString())){
										health = Integer.parseInt(args[3]);
									}else{
										sender.sendMessage(Globals.name + "Please enter a valid Number! ie.10");
										return true;
									}
									
									//Proceed with asking Normal/Nether
									if(args.length >= 5){
										if(health == (int)health){
											if(Globals.Debug){sender.sendMessage(Globals.Debug("Health: " + health));}
										
											if(args[4].equalsIgnoreCase("normal") || args[4].equalsIgnoreCase("nether")){
												plugin.getConfig().set("eDrop.Mobs." + args[1].toUpperCase() + ".CustomHealth." + args[4].toUpperCase(), health);
												saveConfig();
												sender.sendMessage(Globals.name + "The health for " + args[1].toString() + " was changed to " + health + "!");
												return true;
											}
											sender.sendMessage(Globals.name + "Please use either Normal or Nether");
											return true;
											
										
										}
									}
									
									sender.sendMessage(Globals.name + "Please add either Normal or Nether!");
									return true;
								}
								
							}
							sender.sendMessage(Globals.name + "Please use item/itemamount/moneydrop/regenamt or health.");
							return true;
						}
						sender.sendMessage(Globals.name + "That isn't a valid mob!");
						return true;
						
					}
					sender.sendMessage(Globals.name + "Invalid Command. Use the Following: \n"
							+ "/edrop edit <mobname> item <itemname> \n"
							+ "/edrop edit <mobname> itemamount <amount> \n"
							+ "/edrop edit <mobname> moneydrop <amount> \n"
							+ "/edrop edit <mobname> regenamt <amount> \n"
							+ "/edrop edit <mobname> health <amount> <nether/normal>");
					return true;
				}
				
				
			}
			//Displays all commands when player enters a wrong command.
			sender.sendMessage(Globals.name +
					"Invalid command. Use the following."
					+ "\n/edrop on \n/edrop off \n/edrop status \n/edrop reload \n/edrop edit"
					+ "\n/edrop inv \n/edrop message \n/edrop moneydrop \n/edrop BothDrops \n/edrop Playerdrops \n/edrop healthregen "
					+ "\n/edrop health \n/edrop resetall \n/edrop debug");
			
			return true;
			
		}
		
		return false;
	}
    	
    public static String CheckState(Boolean s){
    	String state;
    	if(s == true){
    		state = ChatColor.GREEN + "On" + ChatColor.RESET;
    	}else{
    		state = ChatColor.RED + "Off" + ChatColor.RESET;
    	}
    	
		return state;
    }
    
    public static double createDouble(int health){
    	double newHealth;
    	newHealth = (double)health;
    	
    	return newHealth;
    }
    
}
