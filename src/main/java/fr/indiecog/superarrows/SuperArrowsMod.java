package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
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
            new Identifier(MODID, "glowing_arrow_entity"),
            FabricEntityTypeBuilder.<GlowingArrowEntity>create(SpawnGroup.MISC, GlowingArrowEntity::new).build()
    );

    public static final GlowingArrowItem GLOWING_ARROW_ITEM = new GlowingArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "glowing_arrow_item"), GLOWING_ARROW_ITEM);
    }
}
