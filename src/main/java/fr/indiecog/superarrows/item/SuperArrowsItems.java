package fr.indiecog.superarrows.item;

import fr.indiecog.superarrows.item.arrow.ConfusionArrowItem;
import fr.indiecog.superarrows.item.arrow.ExplosiveArrowItem;
import fr.indiecog.superarrows.item.arrow.GlowingArrowItem;
import fr.indiecog.superarrows.item.arrow.LightningArrowItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.indiecog.superarrows.SuperArrowsMod.MODID;

public class SuperArrowsItems {

    public static final Item EXPLOSIVE_ARROW_ITEM = new ExplosiveArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item GLOWING_ARROW_ITEM = new GlowingArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item LIGHTNING_ARROW_ITEM = new LightningArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item CONFUSION_ARROW_ITEM = new ConfusionArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));

    private static void register(String id, Item item) {
        Registry.register(Registry.ITEM,new Identifier(MODID,id),item);
    }

    public static void init() {
        register("explosive_arrow",EXPLOSIVE_ARROW_ITEM);
        register("glowing_arrow",GLOWING_ARROW_ITEM);
        register("lightning_arrow",LIGHTNING_ARROW_ITEM);
        register("confusion_arrow", CONFUSION_ARROW_ITEM);
    }
}
