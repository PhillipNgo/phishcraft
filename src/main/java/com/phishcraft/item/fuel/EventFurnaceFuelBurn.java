package com.phishcraft.item.fuel;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventFurnaceFuelBurn {
  
  public EventFurnaceFuelBurn() {}

  @SubscribeEvent
  public void onItemUseFinish(FurnaceFuelBurnTimeEvent event) {
    Item item = event.getItemStack().getItem();
    if (item != null && item instanceof IFurnaceFuelItem) {
      int burnTime = ((IFurnaceFuelItem) item).getFuelBurnTime();
      event.setBurnTime(burnTime);
    }
  }
}
