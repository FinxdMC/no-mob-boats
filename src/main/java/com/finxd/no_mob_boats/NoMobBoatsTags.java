package com.finxd.no_mob_boats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class NoMobBoatsTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> CAN_RIDE_BOATS = tag("can_ride_boats");

        private static TagKey<EntityType<?>> tag(String name) {
            return EntityTypeTags.create(ResourceLocation.fromNamespaceAndPath(NoMobBoats.MODID, name));
        }
    }
}
