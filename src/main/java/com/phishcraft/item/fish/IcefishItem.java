package com.phishcraft.item.fish;

import com.phishcraft.item.food.IHasOnFoodEaten;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class IcefishItem extends Item implements IHasOnFoodEaten {

  public IcefishItem() {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .alwaysEat()
            .saturationMod(Foods.COD.getSaturationModifier())
            .nutrition(Foods.COD.getNutrition())
            .build())));
  }

  @Override
  public void onFoodEaten(Player player) {
    player.setRemainingFireTicks(0);
  }
}
