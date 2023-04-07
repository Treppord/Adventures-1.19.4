package com.trep.addon.entity.client.render;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.client.model.RodianModel;
import com.trep.addon.entity.custom.RodianEntity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RodianRenderer extends GeoEntityRenderer<RodianEntity> {
    public RodianRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RodianModel());
    }

    @Override
    public Identifier getTextureLocation(RodianEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/rodian.png");
    }

    @Override
    public void render(RodianEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}