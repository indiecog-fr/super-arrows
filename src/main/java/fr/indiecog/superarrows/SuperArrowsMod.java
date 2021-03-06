package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.arrow.ExplosiveArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
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

    @Override
    public void onInitialize() {
        SuperArrowsItems.init();
        SuperArrowsEntities.init();
    }
}
