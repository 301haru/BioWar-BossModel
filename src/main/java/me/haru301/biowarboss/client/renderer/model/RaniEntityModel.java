package me.haru301.biowarboss.client.renderer.model;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.entity.RaniEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaniEntityModel extends AnimatedGeoModel<RaniEntity>
{

    @Override
    public ResourceLocation getModelLocation(RaniEntity object)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "geo/rani.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RaniEntity object)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/ranitex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RaniEntity animatable)
    {
        return new ResourceLocation(BioWarBoss.MOD_ID, "animations/rani.animation.json");
    }
}
