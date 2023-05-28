package com.phishcraft;

import java.util.Map;
import java.util.function.Supplier;

import com.phishcraft.item.fish.IcefishItem;
import com.phishcraft.item.rods.IronFishingRodItem;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        "fish/icefish", IcefishItem::new
    );
    public static final Map<String, Supplier<? extends Item>> ROD_MAP = Map.of(
        "rods/iron_fishing_rod", IronFishingRodItem::new
    );

    static {
        BLOCK_MAP.forEach((k, v) -> BLOCKS.register(k, v));
        FISH_MAP.forEach((k, v) -> ITEMS.register(k, v));
        ROD_MAP.forEach((k, v) -> ITEMS.register(k, v));
    }

    public Phishcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            BLOCKS.getEntries().forEach(block -> event.accept(block));
            ITEMS.getEntries().forEach(item -> event.accept(item));
        }
    }
}
