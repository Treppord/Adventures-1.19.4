package com.trep.addon.entity.client.render;

import com.parzivail.pswg.Resources;
import com.trep.addon.TestAddon;
import com.trep.addon.entity.client.model.BithModel;
import com.trep.addon.entity.client.model.TankModel;
import com.trep.addon.entity.client.model.TrandoshanModel;
import com.trep.addon.entity.custom.TankEntity;
import com.trep.addon.entity.custom.TrandoshanEntity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class TankRenderer extends GeoEntityRenderer<TankEntity> {
    public TankRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TankModel());
        this.shadowRadius = .5f;
    }

    @Override
    public Identifier getTextureLocation(TankEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/vehicle.png");
    }

}