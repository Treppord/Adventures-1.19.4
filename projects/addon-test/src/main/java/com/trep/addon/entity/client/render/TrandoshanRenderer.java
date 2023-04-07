package com.trep.addon.entity.client.render;

import com.parzivail.pswg.Resources;
import com.trep.addon.TestAddon;
import com.trep.addon.entity.client.model.TrandoshanModel;
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


public class TrandoshanRenderer extends GeoEntityRenderer<TrandoshanEntity> {
    public TrandoshanRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TrandoshanModel());
    }

    @Override
    public Identifier getTextureLocation(TrandoshanEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/trandoshan.png");
    }

    @Override
    public void render(TrandoshanEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}