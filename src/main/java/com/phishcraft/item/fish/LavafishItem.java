package com.phishcraft.item.fish;

import com.phishcraft.item.food.FoodItem;
import com.phishcraft.item.fuel.IFurnaceFuelItem;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class LavafishItem extends FoodItem implements IFurnaceFuelItem {

  public LavafishItem() {
    super((new Item.Properties()).food(
        (new FoodProperties.Builder()
            .saturationMod(Foods.COOKED_COD.getSaturationModifier())
            .nutrition(Foods.COOKED_COD.getNutrition())
            .build())));
  }

  @Override
  public void onFoodEaten(Player player) {
    player.setSecondsOnFire(5);
  }

  @Override
  public int getFuelBurnTime() {
    return 4800;
  }
}
