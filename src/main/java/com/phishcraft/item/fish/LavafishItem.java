package com.phishcraft.item.fish;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class LavafishItem extends Item {

  public LavafishItem() {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .saturationMod(Foods.COD.getSaturationModifier())
            .nutrition(Foods.COD.getNutrition())
            .build())));
  }
}
