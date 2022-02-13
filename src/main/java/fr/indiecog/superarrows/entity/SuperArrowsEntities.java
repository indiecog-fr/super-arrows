package fr.indiecog.superarrows.entity;

import fr.indiecog.superarrows.entity.projectile.arrow.ExplosiveArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.indiecog.superarrows.SuperArrowsMod.MODID;

public class SuperArrowsEntities {

    public static final EntityType<ExplosiveArrowEntity> EXPLOSIVE_ARROW_ENTITY =
            register("explosive_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC,ExplosiveArrowEntity::new));

    public static final EntityType<GlowingArrowEntity> GLOWING_ARROW_ENTITY =
            register("glowing_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, GlowingArrowEntity::new));


    public static void init() {
    }

    private static <T extends Entity> EntityType<T> register(String id, FabricEntityTypeBuilder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, id), builder.build());
    }
}
