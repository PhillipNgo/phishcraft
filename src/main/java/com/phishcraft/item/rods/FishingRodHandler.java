package com.phishcraft.item.rods;

import java.util.List;

import com.phishcraft.Phishcraft;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Phishcraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishingRodHandler {

  public static final List<RegistryObject<FishingRodItem>> FISHING_RODS = List.of(
      Phishcraft.ITEMS.register("rods/iron_fishing_rod", IronFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/copper_fishing_rod", CopperFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/emerald_fishing_rod", EmeraldFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/gold_fishing_rod", GoldFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/blaze_fishing_rod", BlazeFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/obsidian_fishing_rod", ObsidianFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/diamond_fishing_rod", DiamondFishingRodItem::new),
      Phishcraft.ITEMS.register("rods/netherite_fishing_rod", NetheriteFishingRodItem::new));

  public static void setup() {
    FISHING_RODS.forEach(fishingRod -> registerFishingRodModelProperties(fishingRod.get()));
  }

  public static void registerFishingRodModelProperties(FishingRodItem fishingRod) {
    ItemProperties.register(fishingRod, new ResourceLocation("cast"), (stack, level, entity, i) -> {
      if (entity == null || !(entity instanceof Player)) {
        return 0.0F;
      }
      boolean isMainhand = entity.getMainHandItem() == stack;
      boolean isOffHand = entity.getOffhandItem() == stack;
      if (entity.getMainHandItem().getItem() instanceof FishingRodItem) {
        isOffHand = false;
      }
      return (isMainhand || isOffHand) && ((Player) entity).fishing != null ? 1.0F : 0.0F;
    });
  }
}
