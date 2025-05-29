package com.finxd.no_mob_boats;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
@Mod.EventBusSubscriber(modid = NoMobBoats.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static boolean mobBoats;
    public static boolean tagOnly;
    public static int seatAmount;

    public static final ForgeConfigSpec.BooleanValue MOB_BOATS = BUILDER
            .comment("Should any mob (other than player) be allowed to enter boats?")
            .comment("false = no other entity other than player may enter a boat")
            .comment("true = other entities can enter a boat (can be limited by setting tagOnly to true)")
            .define("mobBoats", false);

    public static final ForgeConfigSpec.BooleanValue TAG_ONLY = BUILDER
            .comment("Should only mobs in #no_mob_boats:can_ride_boats entity tag be allowed to ride boats?")
            .comment("this doesn't allow adding new mobs that weren't previously allowed in boats, only for limiting those that normally were")
            .define("tagOnly", false);

    public static final ForgeConfigSpec.IntValue SEAT_AMOUNT = BUILDER
            .comment("How many mobs can a boat seat?")
            .comment("keep it at 1 for old boat behaviour, 2 is vanilla, 0 makes the boat useless lol")
            .defineInRange("seatAmount", 1, 0, 2);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onConstructModEvent(final FMLConstructModEvent event) {
        final ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.SERVER, SPEC);
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        mobBoats = MOB_BOATS.get();
        tagOnly = TAG_ONLY.get();
        seatAmount = SEAT_AMOUNT.get();
    }
}

//// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
//// Demonstrates how to use Forge's config APIs
//@Mod.EventBusSubscriber(modid = NoMobBoats.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class Config
//{
//    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
//
//    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Whether to log the dirt block on common setup")
//            .define("logDirtBlock", true);
//
//    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
//            .comment("A magic number")
//            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
//
//    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");
//
//    // a list of strings that are treated as resource locations for items
//    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);
//
//    static final ForgeConfigSpec SPEC = BUILDER.build();
//
//    public static boolean logDirtBlock;
//    public static int magicNumber;
//    public static String magicNumberIntroduction;
//    public static Set<Item> items;
//
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
//    }
//
//    @SubscribeEvent
//    static void onLoad(final ModConfigEvent event)
//    {
//        logDirtBlock = LOG_DIRT_BLOCK.get();
//        magicNumber = MAGIC_NUMBER.get();
//        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();
//
//        // convert the list of strings into a set of items
//        items = ITEM_STRINGS.get().stream()
//                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
//                .collect(Collectors.toSet());
//    }
//}


