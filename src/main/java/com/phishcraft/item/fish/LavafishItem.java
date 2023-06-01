package com.phishcraft.item.fish;

import com.phishcraft.item.food.IHasOnFoodEaten;
import com.phishcraft.item.fuel.IFurnaceFuelItem;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;

public class LavafishItem extends GenericFishItem implements IHasOnFoodEaten, IFurnaceFuelItem {

  public LavafishItem() {
    super(Foods.COOKED_COD.getSaturationModifier(), Foods.COOKED_COD.getNutrition());
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
