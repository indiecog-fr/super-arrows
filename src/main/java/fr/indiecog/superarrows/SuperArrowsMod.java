package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.projectile.arrow.ExplosiveArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import fr.indiecog.superarrows.item.arrow.ExplosiveArrowItem;
import fr.indiecog.superarrows.item.arrow.GlowingArrowItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SuperArrowsMod implements ModInitializer {

    public static final String MODID = "superarrows";
    public static final EntityType<GlowingArrowEntity> GLOWING_ARROW_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MODID, "glowing_arrow"),
            FabricEntityTypeBuilder.<GlowingArrowEntity>create(SpawnGroup.CREATURE, GlowingArrowEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final EntityType<ExplosiveArrowEntity> EXPLOSIVE_ARROW_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MODID,"explosive_arrow"),
            FabricEntityTypeBuilder.<ExplosiveArrowEntity>create(SpawnGroup.MISC,ExplosiveArrowEntity::new).build());

    public static final ExplosiveArrowItem EXPLOSIVE_ARROW_ITEM = new ExplosiveArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final GlowingArrowItem GLOWING_ARROW_ITEM = new GlowingArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM,new Identifier(MODID,"explosive_arrow"),EXPLOSIVE_ARROW_ITEM);
        Registry.register(Registry.ITEM,new Identifier(MODID,"glowing_arrow"),GLOWING_ARROW_ITEM);
    }
}
