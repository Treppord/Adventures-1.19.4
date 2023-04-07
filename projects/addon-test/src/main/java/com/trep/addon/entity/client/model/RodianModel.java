package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.RodianEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class RodianModel extends GeoModel<RodianEntity> {

    @Override
    public Identifier getModelResource(RodianEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/rodian.geo.json");
    }

    @Override
    public Identifier getTextureResource(RodianEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/rodian.png");
    }

    @Override
    public Identifier getAnimationResource(RodianEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/rodian.animation.json");
    }
    

    @Override
    public void setCustomAnimations(RodianEntity animatable, long instanceId, AnimationState<RodianEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
