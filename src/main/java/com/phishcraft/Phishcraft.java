package com.phishcraft;

import java.util.Map;
import java.util.function.Supplier;

import com.phishcraft.item.fish.BeefishItem;
import com.phishcraft.item.fish.IcefishItem;
import com.phishcraft.item.fish.LavafishItem;
import com.phishcraft.item.fish.SandfishItem;
import com.phishcraft.item.fish.SwordfishItem;
import com.phishcraft.item.food.CaviarItem;
import com.phishcraft.item.food.EventOnFoodEat;
import com.phishcraft.item.rods.FishingRodHandler;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Phishcraft.MODID)
public class Phishcraft {

    public static final String MODID = "phishcraft";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final Map<String, Supplier<? extends Block>> BLOCK_MAP = Map.of();
    public static final Map<String, Supplier<? extends Item>> FISH_MAP = Map.of(
        "fish/beefish", BeefishItem::new,
        "fish/icefish", IcefishItem::new,
        "fish/lavafish", LavafishItem::new,
        "fish/sandfish", SandfishItem::new,
        "fish/swordfish", SwordfishItem::new
    );
    public static final Map<String, Supplier<? extends Item>> FOOD_MAP = Map.of(
        "food/caviar", CaviarItem::new
    );

    static {
        BLOCK_MAP.forEach(BLOCKS::register);
        FISH_MAP.forEach(ITEMS::register);
        FOOD_MAP.forEach(ITEMS::register);
    }

    public Phishcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::addCreative);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventOnFoodEat());
    }

    private void setup(FMLClientSetupEvent event) {
        event.enqueueWork(FishingRodHandler::setup);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            BLOCKS.getEntries().forEach(event::accept);
            ITEMS.getEntries().forEach(event::accept);
        }
    }
}
