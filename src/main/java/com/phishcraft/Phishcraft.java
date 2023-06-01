package com.phishcraft;

import java.util.Map;
import java.util.function.Supplier;

import com.phishcraft.item.PhishcraftItems;
import com.phishcraft.item.food.EventOnFoodEat;
import com.phishcraft.item.fuel.EventFurnaceFuelBurn;
import com.phishcraft.item.rods.FishingRodHandler;

import net.minecraft.world.item.CreativeModeTabs;
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

    public static final Map<String, Supplier<? extends Block>> BLOCK_MAP = Map.of();

    static {
        BLOCK_MAP.forEach(BLOCKS::register);
    }

    public Phishcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::addCreative);

        BLOCKS.register(modEventBus);
        PhishcraftItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventOnFoodEat());
        MinecraftForge.EVENT_BUS.register(new EventFurnaceFuelBurn());
    }

    private void setup(FMLClientSetupEvent event) {
        event.enqueueWork(FishingRodHandler::setup);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            BLOCKS.getEntries().forEach(event::accept);
            PhishcraftItems.ITEMS.getEntries().forEach(event::accept);
        }
    }
}
