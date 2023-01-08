package me.haru301.biowarboss.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
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

public class BoxEntity extends AnimalEntity implements IAnimatable
{
    private AnimationFactory factory = new AnimationFactory(this);
    private static final DataParameter<Integer> ANIMATIONSTATE = EntityDataManager.createKey(RaniEntity.class, DataSerializers.VARINT);

    private int getAnimState()
    {
        return this.getDataManager().get(ANIMATIONSTATE);
    }

    private void setAnimState(int state)
    {
        this.getDataManager().set(ANIMATIONSTATE, state);
    }

    @Override
    protected void registerData()
    {
        super.registerData();
        this.getDataManager().register(ANIMATIONSTATE, 0);
    }

    @Override
    public void writeAdditional(CompoundNBT tag)
    {
        super.writeAdditional(tag);
        tag.putInt("AnimationId", this.getAnimState());
    }

    @Override
    public void readAdditional(CompoundNBT tag)
    {
        super.readAdditional(tag);
        this.setAnimState(tag.getInt("AnimationId"));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return LivingEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 1.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if(source.equals(DamageSource.OUT_OF_WORLD))
            return super.attackEntityFrom(source, amount);
        else return false;
    }

    //Render thread
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        switch(this.getAnimState())
        {
            case 0:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 1:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("spawn", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("spawn_loop", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    public BoxEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate)
    {
        return null;
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
}
