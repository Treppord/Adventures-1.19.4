package com.trep.addon.entity.client.render;

import com.trep.addon.TestAddon;
import com.trep.addon.entity.client.model.C3POModel;
import com.trep.addon.entity.custom.C3POEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class C3PORenderer extends GeoEntityRenderer<C3POEntity> {
    public C3PORenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new C3POModel());
    }

    @Override
    public Identifier getTextureLocation(C3POEntity animatable) {
        return new Identifier(TestAddon.MODID, "textures/entity/c3po.png");
    }

    @Override
    public void render(C3POEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}