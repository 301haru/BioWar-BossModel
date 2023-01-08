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

public class RaniEntity extends AnimalEntity implements IAnimatable
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

    public RaniEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super(type, worldIn);
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
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 1.0D);
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
                        .addAnimation("crouch_down_playonce", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("crouch_down_loop", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 2:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("cutscene_1", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("escape", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 3:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("hit_head", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("hit_head_loop", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 4:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("rush_out", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
                return PlayState.CONTINUE;
            case 5:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("start_car", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 6:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("departure", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("omw_1", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 7:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("turn_back_cart_1", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("omw_2", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 8:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("create_gift", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("hand_gift_1", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 9:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("throw_gift", ILoopType.EDefaultLoopTypes.PLAY_ONCE)
                        .addAnimation("hand_gift_2", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            case 10:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("exclude", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
                return PlayState.CONTINUE;
            case 11:
                event.getController().setAnimation(new AnimationBuilder()
                        .addAnimation("celebrate", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
        }
        return PlayState.STOP;
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
