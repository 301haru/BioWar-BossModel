package me.haru301.biowarboss.init;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.commands.AnimationCommand;
import me.haru301.biowarboss.entity.BioWarBossEntity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BioWarBoss.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents
{
    @SubscribeEvent
    public static void initAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.BOSS.get(), BioWarBossEntity.getAttributes().create());
    }
}
