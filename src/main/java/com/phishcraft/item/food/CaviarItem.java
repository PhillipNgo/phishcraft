package com.phishcraft.item.food;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class CaviarItem extends Item implements IHasOnFoodEaten {

  public static final int XP_BOOST = 50;

  public CaviarItem() {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .saturationMod(Foods.GOLDEN_CARROT.getSaturationModifier())
            .nutrition(Foods.GOLDEN_CARROT.getNutrition())
            .alwaysEat()
            .build())));
  }

  @Override
  public void onFoodEaten(Player player) {
    player.giveExperiencePoints(XP_BOOST);
  }
}
