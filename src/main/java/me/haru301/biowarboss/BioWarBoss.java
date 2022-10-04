package me.haru301.biowarboss;

import me.haru301.biowarboss.client.ClientHandler;
import me.haru301.biowarboss.init.ModEntities;
import me.haru301.biowarboss.network.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("biowarboss")
public class BioWarBoss
{
    public static final String MOD_ID = "biowarboss";
    public static final Logger LOGGER = LogManager.getLogger();

    public BioWarBoss()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onClientSetup);
        bus.addListener(this::onCommonSetup);
        ModEntities.REGISTER.register(bus);
    }

    private void onClientSetup(final FMLClientSetupEvent event)
    {
        ClientHandler.init();
    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {
        PacketHandler.init();
    }
}
