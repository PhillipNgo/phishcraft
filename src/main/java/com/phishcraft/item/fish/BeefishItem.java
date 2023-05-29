package com.phishcraft.item.fish;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class BeefishItem extends Item {

  private static int POISON_DURATION_TICKS = 200;
  private static float POISON_PROBABILITY = 100;

  public BeefishItem() {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .saturationMod(Foods.COOKED_COD.getSaturationModifier())
            .nutrition(Foods.COOKED_COD.getNutrition())
            .effect(() -> new MobEffectInstance(MobEffects.POISON, POISON_DURATION_TICKS), POISON_PROBABILITY)
            .build())));
  }
}
