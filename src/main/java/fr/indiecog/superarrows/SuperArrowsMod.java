package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SuperArrowsMod implements ModInitializer {

    public static final String MODID = "superarrows";
    public static final EntityType<GlowingArrowEntity> GLOWING_ARROW_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("entitytesting", "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlowingArrowEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        
    }
}
