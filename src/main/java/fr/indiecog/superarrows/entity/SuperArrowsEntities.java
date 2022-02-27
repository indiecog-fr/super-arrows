package fr.indiecog.superarrows.entity;

import fr.indiecog.superarrows.entity.projectile.arrow.ConfusionArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.ExplosiveArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.LightningArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.VineArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.TracingArrowEntity;
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

    public static final EntityType<LightningArrowEntity> LIGHTNING_ARROW_ENTITY =
            register("lightning_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC,LightningArrowEntity::new));

    public static final EntityType<GlowingArrowEntity> GLOWING_ARROW_ENTITY =
            register("glowing_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, GlowingArrowEntity::new));
    public static final EntityType<TracingArrowEntity> TRACING_ARROW_ENTITY =
            register("tracing_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, TracingArrowEntity::new));

    public static final EntityType<ConfusionArrowEntity> CONFUSION_ARROW_ENTITY =
            register("confusion_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, ConfusionArrowEntity::new));
    public static final EntityType<VineArrowEntity> VINE_ARROW_ENTITY =
            register("vine_arrow",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, VineArrowEntity::new));

    public static void init() {
    }

    private static <T extends Entity> EntityType<T> register(String id, FabricEntityTypeBuilder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, id), builder.build());
    }
}
