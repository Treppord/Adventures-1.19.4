package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.ZabrakEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ZabrakModel extends GeoModel<ZabrakEntity> {

    @Override
    public Identifier getModelResource(ZabrakEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/zabrak.geo.json");
    }

    @Override
    public Identifier getTextureResource(ZabrakEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/zabrak.png");
    }

    @Override
    public Identifier getAnimationResource(ZabrakEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/zabrak.animation.json");
    }
    

    @Override
    public void setCustomAnimations(ZabrakEntity animatable, long instanceId, AnimationState<ZabrakEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
