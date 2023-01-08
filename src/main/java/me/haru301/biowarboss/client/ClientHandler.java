package me.haru301.biowarboss.client;

import me.haru301.biowarboss.client.renderer.BioWarBossEntityRenderer;
import me.haru301.biowarboss.client.renderer.BoxEntityRenderer;
import me.haru301.biowarboss.client.renderer.RaniEntityRenderer;
import me.haru301.biowarboss.init.ModEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler
{
    @Deprecated
    public static int state = 1;

    public static void init()
    {
        initEntityRenders();
    }
    private static void initEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOSS.get(), BioWarBossEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.RANI.get(), RaniEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOX.get(), BoxEntityRenderer::new);
    }
}
