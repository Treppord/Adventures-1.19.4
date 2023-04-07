package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.TankEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class TankModel extends GeoModel<TankEntity> {

    @Override
    public Identifier getModelResource(TankEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/tank.geo.json");
    }

    @Override
    public Identifier getTextureResource(TankEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/vehicle.png");
    }

    @Override
    public Identifier getAnimationResource(TankEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/tank.animation.json");
    }
    
}
