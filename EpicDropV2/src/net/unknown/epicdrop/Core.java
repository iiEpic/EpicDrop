package net.unknown.epicdrop;

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
			
			Globals.Enabled 	= true;
			Globals.InventoryPlacing 		= true;
			Globals.BothDrops 	= true;
			Globals.PlayerDrops = true;
			Globals.MoneyDrop	= true;
			Globals.MDMessages	= true;
			Globals.HealthRegen	= true;
			Globals.HRMessages	= true;
			Globals.Debug		= true;
			Globals.Setup		= false;
			Globals.ResetAll	= true;
			Globals.CustomHealthNormal = false;
			Globals.CustomHealthNether = false;
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
		
	}
	
    public void onEnable() {
        getConfig();
        plugin = this;
        getStatus();
        MobSettings.Setup();
        PluginManager p = this.getServer().getPluginManager();
        p.registerEvents(new Listeners(), this);
        setupEconomy();
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
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	// All Below are EpicDrop Commands
		if(label.equalsIgnoreCase("edrop")){
			
			if(args.length <= 0){
				sender.sendMessage(Globals.name +
						"Invalid command. Use the following."
						+ "\n/edrop on \n/edrop off \n/edrop status \n/edrop reload "
						+ "\n/edrop inv \n/edrop moneydrop \n/edrop BothDrops \n/edrop Playerdrops \n/edrop healthregen "
						+ "\n/edrop health normal \n/edrop health nether \n/edrop resetall \n/edrop debug");
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
						+	"CustomHealth Nether: " + CheckState(Globals.CustomHealthNether));
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
				
				//Turns on/off Money Drops
				if(args[0].equalsIgnoreCase("moneydrop")){
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
				
				
			}
			//Displays all commands when player enters a wrong command.
			sender.sendMessage(Globals.name +
					"Invalid command. Use the following."
					+ "\n/edrop on \n/edrop off \n/edrop status \n/edrop reload "
					+ "\n/edrop inv \n/edrop moneydrop \n/edrop BothDrops \n/edrop Playerdrops \n/edrop healthregen "
					+ "\n/edrop health normal \n/edrop health nether \n/edrop resetall \n/edrop debug");
			
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
    
}
