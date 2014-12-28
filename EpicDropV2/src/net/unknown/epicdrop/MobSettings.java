package net.unknown.epicdrop;

import org.bukkit.configuration.file.FileConfiguration;

import net.unknown.epicdrop.Core;

public class MobSettings {

	public static void Setup(){
		
		FileConfiguration gc = Core.plugin.getConfig();
		
		if(gc.getBoolean("eDrop.Setup")){return;}
		if(!gc.getBoolean("eDrop.ResetAll")){return;};
		
		gc.set("eDrop.Setup", true);
		gc.set("eDrop.ResetAll", false);
		
		if(gc.get("eDrop.Mobs.BAT") == null){
			gc.set("eDrop.Mobs.BAT.Item", "APPLE");
			gc.set("eDrop.Mobs.BAT.ItemAmount", 1);
			gc.set("eDrop.Mobs.BAT.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.BAT.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.BAT.CustomHealth.Normal", 6.0);
			gc.set("eDrop.Mobs.BAT.CustomHealth.Nether", 6.0);
		}
		if(gc.get("eDrop.Mobs.BLAZE") == null){
			gc.set("eDrop.Mobs.BLAZE.Item", "APPLE");
			gc.set("eDrop.Mobs.BLAZE.ItemAmount", 1);
			gc.set("eDrop.Mobs.BLAZE.MoneyDrop", 5.0);
			gc.set("eDrop.Mobs.BLAZE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.BLAZE.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.BLAZE.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.CAVE_SPIDER") == null){
			gc.set("eDrop.Mobs.CAVE_SPIDER.Item", "APPLE");
			gc.set("eDrop.Mobs.CAVE_SPIDER.ItemAmount", 1);
			gc.set("eDrop.Mobs.CAVE_SPIDER.MoneyDrop", 3.0);
			gc.set("eDrop.Mobs.CAVE_SPIDER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.CAVE_SPIDER.CustomHealth.Normal", 12.0);
			gc.set("eDrop.Mobs.CAVE_SPIDER.CustomHealth.Nether", 12.0);
		}
		if(gc.get("eDrop.Mobs.CHICKEN") == null){
			gc.set("eDrop.Mobs.CHICKEN.Item", "APPLE");
			gc.set("eDrop.Mobs.CHICKEN.ItemAmount", 1);
			gc.set("eDrop.Mobs.CHICKEN.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.CHICKEN.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.CHICKEN.CustomHealth.Normal", 4.0);
			gc.set("eDrop.Mobs.CHICKEN.CustomHealth.Nether", 4.0);
		}
		if(gc.get("eDrop.Mobs.COW") == null){
			gc.set("eDrop.Mobs.COW.Item", "APPLE");
			gc.set("eDrop.Mobs.COW.ItemAmount", 1);
			gc.set("eDrop.Mobs.COW.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.COW.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.COW.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.COW.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.CREEPER") == null){
			gc.set("eDrop.Mobs.CREEPER.Item", "APPLE");
			gc.set("eDrop.Mobs.CREEPER.ItemAmount", 1);
			gc.set("eDrop.Mobs.CREEPER.MoneyDrop", 4.0);
			gc.set("eDrop.Mobs.CREEPER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.CREEPER.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.CREEPER.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.ENDER_DRAGON") == null){
			gc.set("eDrop.Mobs.ENDER_DRAGON.Item", "APPLE");
			gc.set("eDrop.Mobs.ENDER_DRAGON.ItemAmount", 1);
			gc.set("eDrop.Mobs.ENDER_DRAGON.MoneyDrop", 250.0);
			gc.set("eDrop.Mobs.ENDER_DRAGON.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.ENDER_DRAGON.CustomHealth.Normal", 200.0);
			gc.set("eDrop.Mobs.ENDER_DRAGON.CustomHealth.Nether", 200.0);
		}
		if(gc.get("eDrop.Mobs.ENDERMAN") == null){
			gc.set("eDrop.Mobs.ENDERMAN.Item", "APPLE");
			gc.set("eDrop.Mobs.ENDERMAN.ItemAmount", 1);
			gc.set("eDrop.Mobs.ENDERMAN.MoneyDrop", 4.0);
			gc.set("eDrop.Mobs.ENDERMAN.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.ENDERMAN.CustomHealth.Normal", 40.0);
			gc.set("eDrop.Mobs.ENDERMAN.CustomHealth.Nether", 40.0);
		}
		if(gc.get("eDrop.Mobs.ENDERMITE") == null){
			gc.set("eDrop.Mobs.ENDERMITE.Item", "APPLE");
			gc.set("eDrop.Mobs.ENDERMITE.ItemAmount", 1);
			gc.set("eDrop.Mobs.ENDERMITE.MoneyDrop", 4.0);
			gc.set("eDrop.Mobs.ENDERMITE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.ENDERMITE.CustomHealth.Normal", 8.0);
			gc.set("eDrop.Mobs.ENDERMITE.CustomHealth.Nether", 8.0);
		}
		if(gc.get("eDrop.Mobs.GHAST") == null){
			gc.set("eDrop.Mobs.GHAST.Item", "APPLE");
			gc.set("eDrop.Mobs.GHAST.ItemAmount", 1);
			gc.set("eDrop.Mobs.GHAST.MoneyDrop", 5);
			gc.set("eDrop.Mobs.GHAST.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.GHAST.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.GHAST.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.GIANT") == null){
			gc.set("eDrop.Mobs.GIANT.Item", "APPLE");
			gc.set("eDrop.Mobs.GIANT.ItemAmount", 1);
			gc.set("eDrop.Mobs.GIANT.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.GIANT.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.GIANT.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.GIANT.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.GUARDIAN") == null){
			gc.set("eDrop.Mobs.GUARDIAN.Item", "APPLE");
			gc.set("eDrop.Mobs.GUARDIAN.ItemAmount", 1);
			gc.set("eDrop.Mobs.GUARDIAN.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.GUARDIAN.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.GUARDIAN.CustomHealth.Normal", 30.0);
			gc.set("eDrop.Mobs.GUARDIAN.CustomHealth.Nether", 30.0);
		}
		if(gc.get("eDrop.Mobs.HORSE") == null){
			gc.set("eDrop.Mobs.HORSE.Item", "APPLE");
			gc.set("eDrop.Mobs.HORSE.ItemAmount", 1);
			gc.set("eDrop.Mobs.HORSE.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.HORSE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.HORSE.CustomHealth.Normal", 15.0);
			gc.set("eDrop.Mobs.HORSE.CustomHealth.Nether", 15.0);
		}
		if(gc.get("eDrop.Mobs.IRON_GOLEM") == null){
			gc.set("eDrop.Mobs.IRON_GOLEM.Item", "APPLE");
			gc.set("eDrop.Mobs.IRON_GOLEM.ItemAmount", 1);
			gc.set("eDrop.Mobs.IRON_GOLEM.MoneyDrop", 3.5);
			gc.set("eDrop.Mobs.IRON_GOLEM.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.IRON_GOLEM.CustomHealth.Normal", 100.0);
			gc.set("eDrop.Mobs.IRON_GOLEM.CustomHealth.Nether", 100.0);
		}
		if(gc.get("eDrop.Mobs.MAGMA_CUBE") == null){
			gc.set("eDrop.Mobs.MAGMA_CUBE.Item", "APPLE");
			gc.set("eDrop.Mobs.MAGMA_CUBE.ItemAmount", 1);
			gc.set("eDrop.Mobs.MAGMA_CUBE.MoneyDrop", 3.0);
			gc.set("eDrop.Mobs.MAGMA_CUBE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.MAGMA_CUBE.CustomHealth.Normal", 1.0);
			gc.set("eDrop.Mobs.MAGMA_CUBE.CustomHealth.Nether", 1.0);
		}
		if(gc.get("eDrop.Mobs.MUSHROOM_COW") == null){
			gc.set("eDrop.Mobs.MUSHROOM_COW.Item", "APPLE");
			gc.set("eDrop.Mobs.MUSHROOM_COW.ItemAmount", 1);
			gc.set("eDrop.Mobs.MUSHROOM_COW.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.MUSHROOM_COW.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.MUSHROOM_COW.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.MUSHROOM_COW.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.OCELOT") == null){
			gc.set("eDrop.Mobs.OCELOT.Item", "APPLE");
			gc.set("eDrop.Mobs.OCELOT.ItemAmount", 1);
			gc.set("eDrop.Mobs.OCELOT.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.OCELOT.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.OCELOT.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.OCELOT.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.PIG") == null){
			gc.set("eDrop.Mobs.PIG.Item", "APPLE");
			gc.set("eDrop.Mobs.PIG.ItemAmount", 1);
			gc.set("eDrop.Mobs.PIG.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.PIG.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.PIG.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.PIG.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.PIG_ZOMBIE") == null){
			gc.set("eDrop.Mobs.PIG_ZOMBIE.Item", "APPLE");
			gc.set("eDrop.Mobs.PIG_ZOMBIE.ItemAmount", 1);
			gc.set("eDrop.Mobs.PIG_ZOMBIE.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.PIG_ZOMBIE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.PIG_ZOMBIE.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.PIG_ZOMBIE.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.PLAYER") == null){
			gc.set("eDrop.Mobs.PLAYER.Item", "APPLE");
			gc.set("eDrop.Mobs.PLAYER.ItemAmount", 1);
			gc.set("eDrop.Mobs.PLAYER.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.PLAYER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.PLAYER.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.PLAYER.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.RABBIT") == null){
			gc.set("eDrop.Mobs.RABBIT.Item", "APPLE");
			gc.set("eDrop.Mobs.RABBIT.ItemAmount", 1);
			gc.set("eDrop.Mobs.RABBIT.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.RABBIT.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.RABBIT.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.RABBIT.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.SHEEP") == null){
			gc.set("eDrop.Mobs.SHEEP.Item", "APPLE");
			gc.set("eDrop.Mobs.SHEEP.ItemAmount", 1);
			gc.set("eDrop.Mobs.SHEEP.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SHEEP.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SHEEP.CustomHealth.Normal", 8.0);
			gc.set("eDrop.Mobs.SHEEP.CustomHealth.Nether", 8.0);
		}
		if(gc.get("eDrop.Mobs.SILVERFISH") == null){
			gc.set("eDrop.Mobs.SILVERFISH.Item", "APPLE");
			gc.set("eDrop.Mobs.SILVERFISH.ItemAmount", 1);
			gc.set("eDrop.Mobs.SILVERFISH.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SILVERFISH.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SILVERFISH.CustomHealth.Normal", 8.0);
			gc.set("eDrop.Mobs.SILVERFISH.CustomHealth.Nether", 8.0);
		}
		if(gc.get("eDrop.Mobs.SKELETON") == null){
			gc.set("eDrop.Mobs.SKELETON.Item", "APPLE");
			gc.set("eDrop.Mobs.SKELETON.ItemAmount", 1);
			gc.set("eDrop.Mobs.SKELETON.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SKELETON.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SKELETON.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.SKELETON.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.SLIME") == null){
			gc.set("eDrop.Mobs.SLIME.Item", "APPLE");
			gc.set("eDrop.Mobs.SLIME.ItemAmount", 1);
			gc.set("eDrop.Mobs.SLIME.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SLIME.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SLIME.CustomHealth.Normal", 1.0);
			gc.set("eDrop.Mobs.SLIME.CustomHealth.Nether", 1.0);
		}
		if(gc.get("eDrop.Mobs.SNOWMAN") == null){
			gc.set("eDrop.Mobs.SNOWMAN.Item", "APPLE");
			gc.set("eDrop.Mobs.SNOWMAN.ItemAmount", 1);
			gc.set("eDrop.Mobs.SNOWMAN.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SNOWMAN.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SNOWMAN.CustomHealth.Normal", 4.0);
			gc.set("eDrop.Mobs.SNOWMAN.CustomHealth.Nether", 4.0);
		}
		if(gc.get("eDrop.Mobs.SPIDER") == null){
			gc.set("eDrop.Mobs.SPIDER.Item", "APPLE");
			gc.set("eDrop.Mobs.SPIDER.ItemAmount", 1);
			gc.set("eDrop.Mobs.SPIDER.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SPIDER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SPIDER.CustomHealth.Normal", 16.0);
			gc.set("eDrop.Mobs.SPIDER.CustomHealth.Nether", 16.0);
		}
		if(gc.get("eDrop.Mobs.SQUID") == null){
			gc.set("eDrop.Mobs.SQUID.Item", "APPLE");
			gc.set("eDrop.Mobs.SQUID.ItemAmount", 1);
			gc.set("eDrop.Mobs.SQUID.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.SQUID.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.SQUID.CustomHealth.Normal", 10.0);
			gc.set("eDrop.Mobs.SQUID.CustomHealth.Nether", 10.0);
		}
		if(gc.get("eDrop.Mobs.VILLAGER") == null){
			gc.set("eDrop.Mobs.VILLAGER.Item", "APPLE");
			gc.set("eDrop.Mobs.VILLAGER.ItemAmount", 1);
			gc.set("eDrop.Mobs.VILLAGER.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.VILLAGER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.VILLAGER.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.VILLAGER.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.WITCH") == null){
			gc.set("eDrop.Mobs.WITCH.Item", "APPLE");
			gc.set("eDrop.Mobs.WITCH.ItemAmount", 1);
			gc.set("eDrop.Mobs.WITCH.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.WITCH.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.WITCH.CustomHealth.Normal", 26.0);
			gc.set("eDrop.Mobs.WITCH.CustomHealth.Nether", 26.0);
		}
		if(gc.get("eDrop.Mobs.WITHER") == null){
			gc.set("eDrop.Mobs.WITHER.Item", "APPLE");
			gc.set("eDrop.Mobs.WITHER.ItemAmount", 1);
			gc.set("eDrop.Mobs.WITHER.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.WITHER.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.WITHER.CustomHealth.Normal", 300.0);
			gc.set("eDrop.Mobs.WITHER.CustomHealth.Nether", 300.0);
		}
		if(gc.get("eDrop.Mobs.WITHER_SKELETON") == null){
			gc.set("eDrop.Mobs.WITHER_SKELETON.Item", "APPLE");
			gc.set("eDrop.Mobs.WITHER_SKELETON.ItemAmount", 1);
			gc.set("eDrop.Mobs.WITHER_SKELETON.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.WITHER_SKELETON.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.WITHER_SKELETON.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.WITHER_SKELETON.CustomHealth.Nether", 20.0);
		}
		if(gc.get("eDrop.Mobs.WOLF") == null){
			gc.set("eDrop.Mobs.WOLF.Item", "APPLE");
			gc.set("eDrop.Mobs.WOLF.ItemAmount", 1);
			gc.set("eDrop.Mobs.WOLF.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.WOLF.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.WOLF.CustomHealth.Normal", 8.0);
			gc.set("eDrop.Mobs.WOLF.CustomHealth.Nether", 8.0);
		}
		if(gc.get("eDrop.Mobs.ZOMBIE") == null){
			gc.set("eDrop.Mobs.ZOMBIE.Item", "APPLE");
			gc.set("eDrop.Mobs.ZOMBIE.ItemAmount", 1);
			gc.set("eDrop.Mobs.ZOMBIE.MoneyDrop", 2.5);
			gc.set("eDrop.Mobs.ZOMBIE.RegenAmt", 2.0);
			gc.set("eDrop.Mobs.ZOMBIE.CustomHealth.Normal", 20.0);
			gc.set("eDrop.Mobs.ZOMBIE.CustomHealth.Nether", 20.0);
		}
	}
	
}
