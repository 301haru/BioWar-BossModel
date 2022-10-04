package me.haru301.biowarboss.client;

import me.haru301.biowarboss.client.renderer.BioWarBossEntityRenderer;
import me.haru301.biowarboss.init.ModEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler
{
    public static int state = 1;

    public static void init()
    {
        initEntityRenders();
    }
    private static void initEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOSS.get(), BioWarBossEntityRenderer::new);
    }
}