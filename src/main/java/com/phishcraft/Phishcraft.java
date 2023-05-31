package com.phishcraft;

import java.util.Map;
import java.util.function.Supplier;

import com.phishcraft.item.fish.BeefishItem;
import com.phishcraft.item.fish.GenericFishItem;
import com.phishcraft.item.fish.IcefishItem;
import com.phishcraft.item.fish.LavafishItem;
import com.phishcraft.item.fish.SandfishItem;
import com.phishcraft.item.fish.SwordfishItem;
import com.phishcraft.item.food.CaviarItem;
import com.phishcraft.item.food.EventOnFoodEat;
import com.phishcraft.item.fuel.EventFurnaceFuelBurn;
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
import net.minecraftforge.registries.RegistryObject;

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
            "fish/swordfish", SwordfishItem::new);
    public static final Map<String, Supplier<? extends Item>> FOOD_MAP = Map.of(
            "food/caviar", CaviarItem::new);

    public static RegistryObject<GenericFishItem> ANCHOVY = Phishcraft.ITEMS.register("fish/anchovy",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> BREAM = Phishcraft.ITEMS.register("fish/bream", GenericFishItem::new);
    public static RegistryObject<GenericFishItem> CATFISH = Phishcraft.ITEMS.register("fish/catfish",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> DORADO = Phishcraft.ITEMS.register("fish/dorado",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> EEL = Phishcraft.ITEMS.register("fish/eel", GenericFishItem::new);
    public static RegistryObject<GenericFishItem> FLOUNDER = Phishcraft.ITEMS.register("fish/flounder",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> GHOSTFISH = Phishcraft.ITEMS.register("fish/ghostfish",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> HALIBUT = Phishcraft.ITEMS.register("fish/halibut",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> HERRING = Phishcraft.ITEMS.register("fish/herring",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> LARGEMOUTH_BASS = Phishcraft.ITEMS.register("fish/largemouth_bass",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> LAVA_EEL = Phishcraft.ITEMS.register("fish/lava_eel",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> LIONFISH = Phishcraft.ITEMS.register("fish/lionfish",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> PIKE = Phishcraft.ITEMS.register("fish/pike", GenericFishItem::new);
    public static RegistryObject<GenericFishItem> SARDINE = Phishcraft.ITEMS.register("fish/sardine",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> SCORPION_CARP = Phishcraft.ITEMS.register("fish/scorpion_carp",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> SMALLMOUTH_BASS = Phishcraft.ITEMS.register("fish/smallmouth_bass",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> STONEFISH = Phishcraft.ITEMS.register("fish/stonefish",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> STURGEON = Phishcraft.ITEMS.register("fish/sturgeon",
            GenericFishItem::new);
    public static RegistryObject<GenericFishItem> TUNA = Phishcraft.ITEMS.register("fish/tuna", GenericFishItem::new);
    public static RegistryObject<GenericFishItem> WALLEYE = Phishcraft.ITEMS.register("fish/walleye",
            GenericFishItem::new);

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
        MinecraftForge.EVENT_BUS.register(new EventFurnaceFuelBurn());
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
