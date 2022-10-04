package me.haru301.biowarboss.init;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.entity.BioWarBossEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, BioWarBoss.MOD_ID);

    public static final RegistryObject<EntityType<BioWarBossEntity>> BOSS = REGISTER.register("boss", () -> EntityType.Builder.create(BioWarBossEntity::new, EntityClassification.CREATURE).size(5.0f, 5.0f).immuneToFire().build("boss"));
}
