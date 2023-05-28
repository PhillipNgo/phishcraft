package com.phishcraft.fish;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class Icefish extends Item {

  public Icefish(Properties properties) {
    super(properties.food(
        (new FoodProperties.Builder()
            .saturationMod(Foods.COD.getSaturationModifier())
            .nutrition(Foods.COD.getNutrition())
            .build())));
  }
}
