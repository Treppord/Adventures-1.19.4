package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.BithEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class BithModel extends GeoModel<BithEntity> {

    @Override
    public Identifier getModelResource(BithEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/bith.geo.json");
    }

    @Override
    public Identifier getTextureResource(BithEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/bith.png");
    }

    @Override
    public Identifier getAnimationResource(BithEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/bith.animation.json");
    }
    

    @Override
    public void setCustomAnimations(BithEntity animatable, long instanceId, AnimationState<BithEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
