package com.trep.addon.entity.client.model;

import com.parzivail.pswg.Resources;
import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.TrandoshanEntity;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class TrandoshanModel extends GeoModel<TrandoshanEntity> {

    @Override
    public Identifier getModelResource(TrandoshanEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/trandoshan.geo.json");
    }

    @Override
    public Identifier getTextureResource(TrandoshanEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/trandoshan.png");
    }

    @Override
    public Identifier getAnimationResource(TrandoshanEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/trandoshan.animation.json");
    }
    

    @Override
    public void setCustomAnimations(TrandoshanEntity animatable, long instanceId, AnimationState<TrandoshanEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
