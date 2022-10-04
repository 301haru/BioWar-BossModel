package me.haru301.biowarboss.client.renderer.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.entity.BioWarBossEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BioWarBossEntityModel extends AnimatedGeoModel<BioWarBossEntity>
{
	@Override
	public ResourceLocation getModelLocation(BioWarBossEntity object)
	{
		return new ResourceLocation(BioWarBoss.MOD_ID, "geo/boss.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BioWarBossEntity object)
	{
		return new ResourceLocation(BioWarBoss.MOD_ID, "textures/entity/texture.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BioWarBossEntity animatable)
	{
		return new ResourceLocation(BioWarBoss.MOD_ID, "animations/boss.animation.json");
	}
}