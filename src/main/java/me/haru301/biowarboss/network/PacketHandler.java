package me.haru301.biowarboss.network;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.network.packet.BossAnimationToClientPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler
{
    public static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry
            .newSimpleChannel(new ResourceLocation(BioWarBoss.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void init()
    {
        int id = 0;
        INSTANCE.messageBuilder(BossAnimationToClientPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT).encoder(BossAnimationToClientPacket::encode).decoder(BossAnimationToClientPacket::new).consumer(BossAnimationToClientPacket::handle).add();
    }
}
