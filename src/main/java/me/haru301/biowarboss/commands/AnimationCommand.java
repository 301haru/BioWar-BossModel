package me.haru301.biowarboss.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.haru301.biowarboss.network.PacketHandler;
import me.haru301.biowarboss.network.packet.BossAnimationToClientPacket;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

@Deprecated
public class AnimationCommand
{
    public AnimationCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        LiteralArgumentBuilder<CommandSource> builder = Commands.literal("animation");

        builder.then(Commands.argument("state", IntegerArgumentType.integer()).executes((source) -> {
            int channel = IntegerArgumentType.getInteger(source, "state");
            if(channel < 1 || channel > 8)
                return -1;

            for(ServerPlayerEntity p : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers())
                PacketHandler.INSTANCE.sendTo(new BossAnimationToClientPacket(channel), p.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            return 1;
        }));
        dispatcher.register(builder);
    }
}
