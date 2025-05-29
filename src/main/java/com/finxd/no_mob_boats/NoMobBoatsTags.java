package com.finxd.no_mob_boats;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NoMobBoatsTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> CAN_RIDE_BOATS = tag("can_ride_boats");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(NoMobBoats.MODID, name));
        }
    }
}
