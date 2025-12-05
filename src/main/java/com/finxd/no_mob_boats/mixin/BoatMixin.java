package com.finxd.no_mob_boats.mixin;

import com.finxd.no_mob_boats.Config;
import com.finxd.no_mob_boats.NoMobBoatsTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)

public abstract class BoatMixin extends Entity implements net.minecraftforge.common.extensions.IForgeBoat {

    @Shadow protected abstract int getMaxPassengers();

    public BoatMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "canAddPassenger", at = @At("HEAD"), cancellable = true)
    protected void canAddPassenger(Entity pPassenger, CallbackInfoReturnable<Boolean> cir) {
        if(Config.MOB_BOATS.get().equals(false)) {

            if (pPassenger.getType() == EntityType.PLAYER) {
                cir.setReturnValue(this.getPassengers().size() < this.getMaxPassengers() && !this.canBoatInFluid(this.getEyeInFluidType()));
            } else {
                cir.setReturnValue(false);
            }

        } else if(Config.MOB_BOATS.get().equals(true) && Config.TAG_ONLY.get().equals(true)) {

            if (pPassenger.getType().is(NoMobBoatsTags.EntityTypes.CAN_RIDE_BOATS)) {
                cir.setReturnValue(this.getPassengers().size() < this.getMaxPassengers() && !this.canBoatInFluid(this.getEyeInFluidType()));
            } else {
                cir.setReturnValue(false);
            }

        }
    }

    @Inject(method = "getMaxPassengers", at = @At("HEAD"), cancellable = true)
    protected void getMaxPassengers(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Config.seatAmount);
    }
}
