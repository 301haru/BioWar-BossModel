package me.haru301.biowarboss.network.packet;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.client.ClientHandler;
import me.haru301.biowarboss.network.PacketHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.function.Supplier;

public class BossAnimationToClientPacket
{
    private int state;

    public BossAnimationToClientPacket(int state)
    {
        this.state = state;
    }

    public void encode(PacketBuffer buffer)
    {
        buffer.writeShort(state);
    }

    //decode
    public BossAnimationToClientPacket(PacketBuffer buffer)
    {
        this.state = buffer.readShort();
    }

    public static void handle(BossAnimationToClientPacket msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->
                    handle(msg));
        });
        ctx.get().setPacketHandled(true);
    }

    private static void handle(BossAnimationToClientPacket msg)
    {
        ClientHandler.state = msg.state;
    }
}
