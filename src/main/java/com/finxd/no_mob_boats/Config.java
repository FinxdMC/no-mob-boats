package com.finxd.no_mob_boats;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
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
    static void onLoad(final ModConfigEvent event)
    {
        mobBoats = MOB_BOATS.get();
        tagOnly = TAG_ONLY.get();
        seatAmount = SEAT_AMOUNT.get();
    }
}


