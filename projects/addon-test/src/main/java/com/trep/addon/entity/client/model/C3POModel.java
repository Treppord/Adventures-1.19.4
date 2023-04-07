package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.C3POEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class C3POModel extends GeoModel<C3POEntity> {

    @Override
    public Identifier getModelResource(C3POEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/c3po.geo.json");
    }

    @Override
    public Identifier getTextureResource(C3POEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/c3po.png");
    }

    @Override
    public Identifier getAnimationResource(C3POEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/c3po.animation.json");
    }
    

    @Override
    public void setCustomAnimations(C3POEntity animatable, long instanceId, AnimationState<C3POEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
