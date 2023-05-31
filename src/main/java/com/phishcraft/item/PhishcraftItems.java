package com.phishcraft.item;

import com.phishcraft.Phishcraft;
import com.phishcraft.item.fish.BeefishItem;
import com.phishcraft.item.fish.GenericFishItem;
import com.phishcraft.item.fish.IcefishItem;
import com.phishcraft.item.fish.LavafishItem;
import com.phishcraft.item.fish.SandfishItem;
import com.phishcraft.item.fish.SwordfishItem;
import com.phishcraft.item.food.CaviarItem;
import com.phishcraft.item.rods.BlazeFishingRodItem;
import com.phishcraft.item.rods.CopperFishingRodItem;
import com.phishcraft.item.rods.DiamondFishingRodItem;
import com.phishcraft.item.rods.EmeraldFishingRodItem;
import com.phishcraft.item.rods.GoldFishingRodItem;
import com.phishcraft.item.rods.IronFishingRodItem;
import com.phishcraft.item.rods.NetheriteFishingRodItem;
import com.phishcraft.item.rods.ObsidianFishingRodItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PhishcraftItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Phishcraft.MODID);

  // Generic Fish
  public static RegistryObject<GenericFishItem> ANCHOVY = ITEMS.register("fish/anchovy",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> BREAM = ITEMS.register("fish/bream", GenericFishItem::new);
  public static RegistryObject<GenericFishItem> CATFISH = ITEMS.register("fish/catfish",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> DORADO = ITEMS.register("fish/dorado",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> EEL = ITEMS.register("fish/eel", GenericFishItem::new);
  public static RegistryObject<GenericFishItem> FLOUNDER = ITEMS.register("fish/flounder",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> GHOSTFISH = ITEMS.register("fish/ghostfish",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> HALIBUT = ITEMS.register("fish/halibut",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> HERRING = ITEMS.register("fish/herring",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> LARGEMOUTH_BASS = ITEMS.register("fish/largemouth_bass",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> LAVA_EEL = ITEMS.register("fish/lava_eel",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> LIONFISH = ITEMS.register("fish/lionfish",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> PIKE = ITEMS.register("fish/pike", GenericFishItem::new);
  public static RegistryObject<GenericFishItem> SARDINE = ITEMS.register("fish/sardine",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> SCORPION_CARP = ITEMS.register("fish/scorpion_carp",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> SMALLMOUTH_BASS = ITEMS.register("fish/smallmouth_bass",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> STONEFISH = ITEMS.register("fish/stonefish",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> STURGEON = ITEMS.register("fish/sturgeon",
      GenericFishItem::new);
  public static RegistryObject<GenericFishItem> TUNA = ITEMS.register("fish/tuna", GenericFishItem::new);
  public static RegistryObject<GenericFishItem> WALLEYE = ITEMS.register("fish/walleye",
      GenericFishItem::new);

  // Fish
  public static RegistryObject<BeefishItem> BEEFISH = ITEMS.register("fish/beefish",
      BeefishItem::new);
  public static RegistryObject<IcefishItem> ICEFISH = ITEMS.register("fish/icefish",
      IcefishItem::new);
  public static RegistryObject<LavafishItem> LAVAFISH = ITEMS.register("fish/lavafish",
      LavafishItem::new);
  public static RegistryObject<SandfishItem> SANDFISH = ITEMS.register("fish/sandfish", SandfishItem::new);
  public static RegistryObject<SwordfishItem> SWORDFISH = ITEMS.register("fish/swordfish",
      SwordfishItem::new);

  // Food
  public static RegistryObject<CaviarItem> CAVIAR = ITEMS.register("food/caviar", CaviarItem::new);

  // Rods
  public static RegistryObject<IronFishingRodItem> IRON_FISHING_ROD = ITEMS.register("rods/iron_fishing_rod",
      IronFishingRodItem::new);
  public static RegistryObject<CopperFishingRodItem> COPPER_FISHING_ROD = ITEMS.register("rods/copper_fishing_rod",
      CopperFishingRodItem::new);
  public static RegistryObject<EmeraldFishingRodItem> EMERALD_FISHING_ROD = ITEMS.register("rods/emerald_fishing_rod",
      EmeraldFishingRodItem::new);
  public static RegistryObject<GoldFishingRodItem> GOLD_FISHING_ROD = ITEMS.register("rods/gold_fishing_rod",
      GoldFishingRodItem::new);
  public static RegistryObject<BlazeFishingRodItem> BLAZE_FISHING_ROD = ITEMS.register("rods/blaze_fishing_rod",
      BlazeFishingRodItem::new);
  public static RegistryObject<ObsidianFishingRodItem> OBSIDIAN_FISHING_ROD = ITEMS
      .register("rods/obsidian_fishing_rod", ObsidianFishingRodItem::new);
  public static RegistryObject<DiamondFishingRodItem> DIAMOND_FISHING_ROD = ITEMS.register("rods/diamond_fishing_rod",
      DiamondFishingRodItem::new);
  public static RegistryObject<NetheriteFishingRodItem> NETHERITE_FISHING_ROD = ITEMS
      .register("rods/netherite_fishing_rod", NetheriteFishingRodItem::new);
}
