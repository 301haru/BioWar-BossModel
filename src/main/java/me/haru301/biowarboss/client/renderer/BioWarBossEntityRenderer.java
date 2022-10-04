package me.haru301.biowarboss.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.client.renderer.model.BioWarBossEntityModel;
import me.haru301.biowarboss.entity.BioWarBossEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BioWarBossEntityRenderer extends GeoEntityRenderer<BioWarBossEntity>
{
    public BioWarBossEntityRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new BioWarBossEntityModel());
        this.shadowSize = 1.0f;
    }

    @Override
    public ResourceLocation getEntityTexture(BioWarBossEntity entity)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/texture.png");
    }
}
