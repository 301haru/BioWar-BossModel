package me.haru301.biowarboss.init;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.commands.AnimationCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BioWarBoss.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents
{
    @SubscribeEvent
    public static void onCommandInit(RegisterCommandsEvent event)
    {
        new AnimationCommand(event.getDispatcher());
    }
}
