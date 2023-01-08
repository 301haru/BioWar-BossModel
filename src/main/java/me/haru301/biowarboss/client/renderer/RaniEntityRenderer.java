package me.haru301.biowarboss.client.renderer;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.client.renderer.model.RaniEntityModel;
import me.haru301.biowarboss.entity.RaniEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RaniEntityRenderer extends GeoEntityRenderer<RaniEntity>
{
    public RaniEntityRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new RaniEntityModel());
        this.shadowSize = 0.5f;
    }

    @Override
    public ResourceLocation getEntityTexture(RaniEntity entity)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/ranitex.png");
    }
}
