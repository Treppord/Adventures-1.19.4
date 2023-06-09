package com.trep.addon.entity;


import com.trep.addon.TestAddon;
import com.trep.addon.items.AdventureItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ForceDarkEntity extends ThrownItemEntity {

    public ForceDarkEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}
 
	public ForceDarkEntity(World world, LivingEntity owner) {
		super(TestAddon.ForceDarkEntityType, owner, world);
	}
 
	public ForceDarkEntity(World world, double x, double y, double z) {
		super(TestAddon.ForceDarkEntityType, x, y, z, world);
	}

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            LivingEntity player = (LivingEntity) entityHitResult.getEntity();
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 50 * 1, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 50 * 2, 1));
        }
        this.discard();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.discard();
    }

    public void setProperties(PlayerEntity user, float pitch, float yaw, float f, float g, float h) {
    }

    public static Builder createAttributes() {
        return null;
    }

    @Override
	protected Item getDefaultItem() {
		return AdventureItems.FORCE_DARK;
	}

    

}