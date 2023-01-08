package me.haru301.biowarboss.client.renderer;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.client.renderer.model.BoxEntityModel;
import me.haru301.biowarboss.entity.BoxEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BoxEntityRenderer extends GeoEntityRenderer<BoxEntity>
{
    public BoxEntityRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new BoxEntityModel());
        this.shadowSize = 0.25f;
    }

    @Override
    public ResourceLocation getEntityTexture(BoxEntity entity)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/boxtex.png");
    }
}
