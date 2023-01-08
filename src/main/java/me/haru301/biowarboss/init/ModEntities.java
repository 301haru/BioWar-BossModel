package me.haru301.biowarboss.init;

import me.haru301.biowarboss.BioWarBoss;
import me.haru301.biowarboss.entity.BioWarBossEntity;
import me.haru301.biowarboss.entity.RaniEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, BioWarBoss.MOD_ID);

    public static final RegistryObject<EntityType<BioWarBossEntity>> BOSS = REGISTER.register("boss", () -> EntityType.Builder.create(BioWarBossEntity::new, EntityClassification.CREATURE).size(1.0f, 1.0f).immuneToFire().build("boss"));
    public static final RegistryObject<EntityType<RaniEntity>> RANI = REGISTER.register("rani", () -> EntityType.Builder.create(RaniEntity::new, EntityClassification.CREATURE).size(1.5f, 2.0f).immuneToFire().build("rani"));

}
