package fr.indiecog.superarrows.item;

import fr.indiecog.superarrows.item.arrow.ExplosiveArrowItem;
import fr.indiecog.superarrows.item.arrow.GlowingArrowItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.indiecog.superarrows.SuperArrowsMod.MODID;

public class SuperArrowsItems {

    public static final ExplosiveArrowItem EXPLOSIVE_ARROW_ITEM = register("explosive_arrow",new ExplosiveArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final GlowingArrowItem GLOWING_ARROW_ITEM = register("glowing_arrow",new GlowingArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT)));



    private static <T extends Item> T register(String id, T item) {
        Registry.register(Registry.ITEM,new Identifier(MODID,id),item);
        return item;
    }

    public static void init() {
        //register("explosive_arrow",EXPLOSIVE_ARROW_ITEM);
        //register("glowing_arrow",GLOWING_ARROW_ITEM);
    }
}
