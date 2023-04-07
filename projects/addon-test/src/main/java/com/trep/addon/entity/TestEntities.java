package com.trep.addon.entity;

import com.parzivail.pswg.Resources;
import com.parzivail.pswg.container.SwgEntities;
import com.parzivail.pswg.entity.mammal.BanthaEntity;
import com.trep.addon.TestAddon;
import com.trep.addon.entity.custom.BithEntity;
import com.trep.addon.entity.custom.C3POEntity;
import com.trep.addon.entity.custom.MDEntity;
import com.trep.addon.entity.custom.ZabrakEntity;
import com.trep.addon.entity.custom.RodianEntity;
import com.trep.addon.entity.custom.TankEntity;
import com.trep.addon.entity.custom.TrandoshanEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class TestEntities {

    public static final ArrayList<EntityType<?>> entityTypes = new ArrayList<>();



    public static class Droids
    {
        public static final EntityType<DroidEntity> Droids = Registry.register(Registries.ENTITY_TYPE, Resources.id("droid"), FabricEntityTypeBuilder
                .create(SpawnGroup.MISC, DroidEntity::new)
                .dimensions(EntityDimensions.fixed(1, 2))
                .build());

        static void register()
        {
            entityTypes.add(Droids);
            FabricDefaultAttributeRegistry.register(Droids, DroidEntity.createAttributes());
        }
    }

    public static final EntityType<TrandoshanEntity> TRANDOSHAN = Registry.register(
        Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "trandoshan"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TrandoshanEntity::new)
                .dimensions(EntityDimensions.fixed(1f, 2f)).build());

                    public static final EntityType<BithEntity> BITH = Registry.register(
        Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "bith"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BithEntity::new)
                .dimensions(EntityDimensions.fixed(1f, 2f)).build());

                    public static final EntityType<RodianEntity> RODIAN = Registry.register(
        Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "rodian"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RodianEntity::new)
                .dimensions(EntityDimensions.fixed(1f, 2f)).build());


                    public static final EntityType<ZabrakEntity> ZABRAK = Registry.register(
        Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "zabrak"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ZabrakEntity::new)
                .dimensions(EntityDimensions.fixed(1f, 2f)).build());

                public static final EntityType<C3POEntity> C3PO = Registry.register(
                    Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "c3po"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, C3POEntity::new)
                            .dimensions(EntityDimensions.fixed(1f, 2f)).build());


                            public static final EntityType<TankEntity> TANK = Registry.register(
                                Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "tank"),
                                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TankEntity::new)
                                        .dimensions(EntityDimensions.fixed(1f, 2f)).build());

                            public static final EntityType<MDEntity> MD = Registry.register(
                                Registries.ENTITY_TYPE, new Identifier(TestAddon.MODID, "mouse_droid"),
                                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MDEntity::new)
                                        .dimensions(EntityDimensions.fixed(1f, 1f)).build());




    public static void register()
    {
        TestEntities.Droids.register();
    }
}
