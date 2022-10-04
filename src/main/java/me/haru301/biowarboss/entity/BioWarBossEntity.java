package me.haru301.biowarboss.entity;

import me.haru301.biowarboss.client.ClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class BioWarBossEntity extends AnimalEntity implements IAnimatable
{
    private AnimationFactory factory = new AnimationFactory(this);

    public BioWarBossEntity(EntityType<? extends AnimalEntity> type, World world)
    {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return LivingEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 1.0D);
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event)
    {
        if(ClientHandler.state == 1)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.idle", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 2)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.skill1", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 3)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.skill12", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 4)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.skill2", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 5)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.skill3", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 6)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.skill4", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 7)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.sten", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 8)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.death", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        else if(ClientHandler.state == 9)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.boss.walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate)
    {
        return null;
    }
}
