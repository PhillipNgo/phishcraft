package com.phishcraft.item.food;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventOnFoodEaten {

  public EventOnFoodEaten() {}

  @SubscribeEvent
  public void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
    Entity entity = event.getEntity();
    if (entity == null || !(entity instanceof Player)) {
      return;
    }
    Item item = event.getItem().getItem();
    if (item == null || !(item instanceof IHasOnFoodEaten)) {
      return;
    }
    ((IHasOnFoodEaten) item).onFoodEaten((Player) entity);
  }
}
