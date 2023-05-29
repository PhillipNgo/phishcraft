package com.phishcraft.item.food;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

public abstract class FoodItem extends Item {

  public FoodItem(Item.Properties properties) {
    super(properties);
  }

  public void onFoodEaten(Player player) {}
}
