package com.trep.addon.entity.custom;

import com.parzivail.pswg.entity.ship.SpeederEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class TankEntity extends SpeederEntity implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public TankEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected double getRepulsorSetpoint() {
        return -0.4;
    }

    @Override
    protected int getMaxPassengers() {
        return 2;
    }

    @Override
    public Vec3d getPassengerSocket(int passengerIndex) {
        if (passengerIndex > 0)
            return new Vec3d(0.5f, 0.1f, 1.25f);
        return new Vec3d(-0.5f, 0.1f, 1.25f);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> state) {
        if(state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.tank.walking", Animation.LoopType.LOOP));
        } else {
            state.getController().setAnimation(RawAnimation.begin().then("animation.tank.walking", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
	public boolean useMouseInput(PlayerEntity player)
	{
		return true;
	}

    public void travel(Vec3d pos) {
        if (this.isAlive() && this.hasPassengers()) {
            LivingEntity livingentity = (LivingEntity) this.getFirstPassenger();
            this.setYaw(livingentity.getYaw());
            this.prevYaw = this.getYaw();
            this.setPitch(livingentity.getPitch() * 0.5F);
            this.setRotation(this.getYaw(), this.getPitch());
            this.setBodyYaw(this.getYaw());
            this.setHeadYaw(this.getYaw());
        }
    }


    

}