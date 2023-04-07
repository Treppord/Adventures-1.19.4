package com.trep.addon.entity.client.model;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.BithEntity;
import com.trep.addon.entity.custom.MDEntity;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class MDModel extends GeoModel<MDEntity> {

    @Override
    public Identifier getModelResource(MDEntity animatable) {
        return new Identifier(TestAddon.MODID, "geo/mouse_droid.geo.json");
    }

    @Override
    public Identifier getTextureResource(MDEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/mouse_droid.png");
    }

    @Override
    public Identifier getAnimationResource(MDEntity animatable) {
        return new Identifier(TestAddon.MODID, "animations/mouse_droid.animation.json");
    }
    

}
