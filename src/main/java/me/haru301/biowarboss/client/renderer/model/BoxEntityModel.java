package me.haru301.biowarboss.client.renderer.model;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.entity.BoxEntity;
import me.haru301.biowarboss.entity.RaniEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BoxEntityModel extends AnimatedGeoModel<BoxEntity>
{

    @Override
    public ResourceLocation getModelLocation(BoxEntity object)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "geo/box.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BoxEntity object)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/boxtex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BoxEntity animatable)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "animations/box.animation.json");
    }
}
