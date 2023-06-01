package com.phishcraft.item.fish;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class GenericFishItem extends Item {

  public GenericFishItem() {
    this(Foods.COD.getSaturationModifier(), Foods.COD.getNutrition());
  }

  public GenericFishItem(float saturation, int nutrition) {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .saturationMod(saturation)
            .nutrition(nutrition)
            .build())));
  }
}
