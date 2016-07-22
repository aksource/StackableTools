package StackableTools;


import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StackableTools.MOD_ID,
        name = StackableTools.MOD_NAME,
        version = StackableTools.MOD_VERSION,
        dependencies = StackableTools.MOD_DEPENDENCIES,
        useMetadata = true,
        acceptedMinecraftVersions = StackableTools.MOD_MC_VERSION)
public class StackableTools {

    public static final String MOD_ID = "StackableTools";
    public static final String MOD_NAME = "StackableTools";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[12.17.0,)";
    public static final String MOD_MC_VERSION = "[1.9,1.10.99]";

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
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        AxeMax = config.get(Configuration.CATEGORY_GENERAL, "AxeMax", 64, "Axe Max Stack Size, min = 1, max = 64").getInt();
        AxeMax = (AxeMax < 1) ? 1 : (AxeMax > 64) ? 64 : AxeMax;
        PickaxeMax = config.get(Configuration.CATEGORY_GENERAL, "PickaxeMax", 64, "Pickaxe Max Stack Size, min = 1, max = 64").getInt();
        PickaxeMax = (PickaxeMax < 1) ? 1 : (PickaxeMax > 64) ? 64 : PickaxeMax;
        ShovelMax = config.get(Configuration.CATEGORY_GENERAL, "ShovelMax", 64, "Shovel Max Stack Size, min = 1, max = 64").getInt();
        ShovelMax = (ShovelMax < 1) ? 1 : (ShovelMax > 64) ? 64 : ShovelMax;
        SwordMax = config.get(Configuration.CATEGORY_GENERAL, "SwordMax", 64, "Sword Max Stack Size, min = 1, max = 64").getInt();
        SwordMax = (SwordMax < 1) ? 1 : (SwordMax > 64) ? 64 : SwordMax;
        HoeMax = config.get(Configuration.CATEGORY_GENERAL, "HoeMax", 64, "Hoe Max Stack Size, min = 1, max = 64").getInt();
        HoeMax = (HoeMax < 1) ? 1 : (HoeMax > 64) ? 64 : HoeMax;
        FrintMax = config.get(Configuration.CATEGORY_GENERAL, "FrintMax", 64, "Flint Max Stack Size, min = 1, max = 64").getInt();
        FrintMax = (FrintMax < 1) ? 1 : (FrintMax > 64) ? 64 : FrintMax;
        BowMax = config.get(Configuration.CATEGORY_GENERAL, "BowMax", 64, "Bow Max Stack Size, min = 1, max = 64").getInt();
        BowMax = (BowMax < 1) ? 1 : (BowMax > 64) ? 64 : BowMax;
        ShearsMax = config.get(Configuration.CATEGORY_GENERAL, "ShearsMax", 64, "Shears Max Stack Size, min = 1, max = 64").getInt();
        ShearsMax = (ShearsMax < 1) ? 1 : (ShearsMax > 64) ? 64 : ShearsMax;
        FishingRodMax = config.get(Configuration.CATEGORY_GENERAL, "FishingRodMax", 64, "FishingRod Max Stack Size, min = 1, max = 64").getInt();
        FishingRodMax = (FishingRodMax < 1) ? 1 : (FishingRodMax > 64) ? 64 : FishingRodMax;
        ArmorMax = config.get(Configuration.CATEGORY_GENERAL, "ArmorMax", 64, "Armor Max Stack Size, min = 1, max = 64").getInt();
        ArmorMax = (ArmorMax < 1) ? 1 : (ArmorMax > 64) ? 64 : ArmorMax;
        WebDamage = config.get(Configuration.CATEGORY_GENERAL, "WebDamage", 1, "Damage Destroyed Web with Sword, min = 0, max = 2").getInt();
        WebDamage = (WebDamage < 0) ? 0 : (WebDamage > 2) ? 2 : WebDamage;
        config.save();
        if (AxeMax != 1) {
            Items.WOODEN_AXE.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.STONE_AXE.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.IRON_AXE.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.DIAMOND_AXE.setHasSubtypes(true).setMaxStackSize(AxeMax);
            Items.GOLDEN_AXE.setHasSubtypes(true).setMaxStackSize(AxeMax);
        }

        if (PickaxeMax != 1) {
            Items.WOODEN_PICKAXE.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.STONE_PICKAXE.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.IRON_PICKAXE.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.DIAMOND_PICKAXE.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
            Items.GOLDEN_PICKAXE.setHasSubtypes(true).setMaxStackSize(PickaxeMax);
        }

        if (ShovelMax != 1) {
            Items.WOODEN_SHOVEL.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.STONE_SHOVEL.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.IRON_SHOVEL.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.DIAMOND_SHOVEL.setHasSubtypes(true).setMaxStackSize(ShovelMax);
            Items.GOLDEN_SHOVEL.setHasSubtypes(true).setMaxStackSize(ShovelMax);
        }

        if (BowMax != 1) {
            Items.BOW.setHasSubtypes(true).setMaxStackSize(BowMax);
        }

        if (SwordMax != 1 || WebDamage != 2) {
            Items.WOODEN_SWORD.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.STONE_SWORD.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.IRON_SWORD.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.DIAMOND_SWORD.setHasSubtypes(true).setMaxStackSize(SwordMax);
            Items.GOLDEN_SWORD.setHasSubtypes(true).setMaxStackSize(SwordMax);
        }

        if (ArmorMax != 1) {
            Items.LEATHER_HELMET.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.LEATHER_CHESTPLATE.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.LEATHER_LEGGINGS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.LEATHER_BOOTS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.CHAINMAIL_HELMET.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.CHAINMAIL_CHESTPLATE.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.CHAINMAIL_LEGGINGS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.CHAINMAIL_BOOTS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.IRON_HELMET.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.IRON_CHESTPLATE.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.IRON_LEGGINGS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.IRON_BOOTS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.DIAMOND_HELMET.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.DIAMOND_CHESTPLATE.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.DIAMOND_LEGGINGS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.DIAMOND_BOOTS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.GOLDEN_HELMET.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.GOLDEN_CHESTPLATE.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.GOLDEN_LEGGINGS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
            Items.GOLDEN_BOOTS.setHasSubtypes(true).setMaxStackSize(ArmorMax);
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        if (FrintMax != 1) {
            Items.FLINT_AND_STEEL.setMaxStackSize(FrintMax).setHasSubtypes(true);
        }

        if (FishingRodMax != 1) {
            Items.FISHING_ROD.setMaxStackSize(FishingRodMax).setHasSubtypes(true);
        }

        if (ShearsMax != 1) {
            Items.SHEARS.setMaxStackSize(ShearsMax).setHasSubtypes(true);
        }

        if (HoeMax != 1) {
            Items.WOODEN_HOE.setMaxStackSize(HoeMax).setHasSubtypes(true);
            Items.STONE_HOE.setMaxStackSize(HoeMax).setHasSubtypes(true);
            Items.IRON_HOE.setMaxStackSize(HoeMax).setHasSubtypes(true);
            Items.DIAMOND_HOE.setMaxStackSize(HoeMax).setHasSubtypes(true);
            Items.GOLDEN_HOE.setMaxStackSize(HoeMax).setHasSubtypes(true);
        }
    }
}