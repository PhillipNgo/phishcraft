package com.phishcraft.item.rods;

import java.util.List;

import com.phishcraft.Phishcraft;
import com.phishcraft.item.PhishcraftItems;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Phishcraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishingRodHandler {

  public static final List<RegistryObject<? extends FishingRodItem>> FISHING_RODS = List.of(
      PhishcraftItems.IRON_FISHING_ROD,
      PhishcraftItems.COPPER_FISHING_ROD,
      PhishcraftItems.EMERALD_FISHING_ROD,
      PhishcraftItems.GOLD_FISHING_ROD,
      PhishcraftItems.BLAZE_FISHING_ROD,
      PhishcraftItems.OBSIDIAN_FISHING_ROD,
      PhishcraftItems.DIAMOND_FISHING_ROD,
      PhishcraftItems.NETHERITE_FISHING_ROD);

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
