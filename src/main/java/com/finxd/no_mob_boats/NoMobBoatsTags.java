package com.finxd.no_mob_boats;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class NoMobBoatsTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> CAN_RIDE_BOATS = tag("can_ride_boats");

        //wtf neoforge why is it private??
        public static TagKey<EntityType<?>> create(ResourceLocation name) {
            return TagKey.create(Registries.ENTITY_TYPE, name);
        }

        private static TagKey<EntityType<?>> tag(String name) {
            return create(ResourceLocation.fromNamespaceAndPath(NoMobBoats.MODID, name));
        }
    }
}
