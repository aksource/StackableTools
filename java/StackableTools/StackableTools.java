package StackableTools;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;

@Mod(modid="StackableTools", name="StackableTools", version="@VERSION@",dependencies="required-after:FML", useMetadata = true)
public class StackableTools
{
	@Mod.Instance("StackableTools")
	public static StackableTools instance;
	
	public static int AxeMax;
	public static int PickaxeMax;
	public static int ShovelMax;
	public static int SwordMax;
	public static int HoeMax;
	public static int FrintMax;
	public static int BowMax;
	public static int ShearsMax;
	public static int FishingRodMax;
	public static int ArmorMax;
	public static int WebDamage;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		AxeMax = config.get(Configuration.CATEGORY_GENERAL, "AxeMax", 64, "Axe Max Stack Size, min = 1, max = 64").getInt();
		AxeMax = (AxeMax<1)?1:(AxeMax>64)?64:AxeMax;
		PickaxeMax = config.get(Configuration.CATEGORY_GENERAL, "PickaxeMax", 64, "Pickaxe Max Stack Size, min = 1, max = 64").getInt();
		PickaxeMax = (PickaxeMax<1)?1:(PickaxeMax>64)?64:PickaxeMax;
		ShovelMax = config.get(Configuration.CATEGORY_GENERAL, "ShovelMax", 64, "Shovel Max Stack Size, min = 1, max = 64").getInt();
		ShovelMax = (ShovelMax<1)?1:(ShovelMax>64)?64:ShovelMax;
		SwordMax = config.get(Configuration.CATEGORY_GENERAL, "SwordMax", 64, "Sword Max Stack Size, min = 1, max = 64").getInt();
		SwordMax = (SwordMax<1)?1:(SwordMax>64)?64:SwordMax;
		HoeMax = config.get(Configuration.CATEGORY_GENERAL, "HoeMax", 64, "Hoe Max Stack Size, min = 1, max = 64").getInt();
		HoeMax = (HoeMax<1)?1:(HoeMax>64)?64:HoeMax;
		FrintMax = config.get(Configuration.CATEGORY_GENERAL, "FrintMax", 64, "Flint Max Stack Size, min = 1, max = 64").getInt();
		FrintMax = (FrintMax<1)?1:(FrintMax>64)?64:FrintMax;
		BowMax = config.get(Configuration.CATEGORY_GENERAL, "BowMax", 64, "Bow Max Stack Size, min = 1, max = 64").getInt();
		BowMax = (BowMax<1)?1:(BowMax>64)?64:BowMax;
		ShearsMax = config.get(Configuration.CATEGORY_GENERAL, "ShearsMax", 64, "Shears Max Stack Size, min = 1, max = 64").getInt();
		ShearsMax = (ShearsMax<1)?1:(ShearsMax>64)?64:ShearsMax;
		FishingRodMax = config.get(Configuration.CATEGORY_GENERAL, "FishingRodMax", 64, "FishingRod Max Stack Size, min = 1, max = 64").getInt();
		FishingRodMax = (FishingRodMax<1)?1:(FishingRodMax>64)?64:FishingRodMax;
		ArmorMax = config.get(Configuration.CATEGORY_GENERAL, "ArmorMax", 64, "Armor Max Stack Size, min = 1, max = 64").getInt();
		ArmorMax = (ArmorMax<1)?1:(ArmorMax>64)?64:ArmorMax;
		WebDamage = config.get(Configuration.CATEGORY_GENERAL, "WebDamage", 1, "Damage Destroyed Web with Sword, min = 0, max = 2").getInt();
		WebDamage = (WebDamage<0)?0:(WebDamage>2)?2:WebDamage;
		config.save();
		if(AxeMax != 1)
		{
            Items.wooden_axe.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.stone_axe.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.iron_axe.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.diamond_axe.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.golden_axe.setHasSubtypes(true).setMaxStackSize(AxeMax);
		}
		
		if(PickaxeMax != 1)
		{
            Items.wooden_pickaxe.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.stone_pickaxe.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.iron_pickaxe.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.diamond_pickaxe.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.golden_pickaxe.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
		}
		
		if(ShovelMax != 1)
		{
            Items.wooden_shovel.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.stone_shovel.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.iron_shovel.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.diamond_shovel.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.golden_shovel.setHasSubtypes(true).setMaxStackSize(ShovelMax);
		}
		
		if(BowMax != 1)
		{
            Items.bow.setHasSubtypes(true).setMaxStackSize(BowMax);
		}
		
		if(SwordMax != 1 || WebDamage != 2)
		{
            Items.wooden_sword.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.stone_sword.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.iron_sword.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.diamond_sword.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.golden_sword.setHasSubtypes(true).setMaxStackSize(SwordMax);
		}

		if(ArmorMax != 1)
		{
            Items.leather_helmet.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.leather_chestplate.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.leather_leggings.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.leather_boots.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.chainmail_helmet.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.chainmail_chestplate.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.chainmail_leggings.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.chainmail_boots.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.iron_helmet.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.iron_chestplate.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.iron_leggings.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.iron_boots.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.diamond_helmet.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.diamond_chestplate.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.diamond_leggings.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.diamond_boots.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.golden_helmet.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.golden_chestplate.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.golden_leggings.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.golden_boots.setHasSubtypes(true).setMaxStackSize(ArmorMax);
		}
	}
	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		if(FrintMax != 1)
		{
			Items.flint_and_steel.setMaxStackSize(FrintMax).setHasSubtypes(true);
		}
		
		if(FishingRodMax != 1)
		{
			Items.fishing_rod.setMaxStackSize(FishingRodMax).setHasSubtypes(true);
		}
		
		if(ShearsMax != 1)
		{
			Items.shears.setMaxStackSize(ShearsMax).setHasSubtypes(true);
		}
		
		if(HoeMax != 1)
		{
			Items.wooden_hoe.setMaxStackSize(HoeMax).setHasSubtypes(true);
			Items.stone_hoe.setMaxStackSize(HoeMax).setHasSubtypes(true);
			Items.iron_hoe.setMaxStackSize(HoeMax).setHasSubtypes(true);
			Items.diamond_hoe.setMaxStackSize(HoeMax).setHasSubtypes(true);
			Items.golden_hoe.setMaxStackSize(HoeMax).setHasSubtypes(true);
		}
	}
}