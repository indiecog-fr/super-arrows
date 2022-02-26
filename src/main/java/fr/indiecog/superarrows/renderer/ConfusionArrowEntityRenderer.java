package fr.indiecog.superarrows.renderer;

import fr.indiecog.superarrows.SuperArrowsMod;
import fr.indiecog.superarrows.entity.projectile.arrow.ConfusionArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ConfusionArrowEntityRenderer extends ProjectileEntityRenderer<ConfusionArrowEntity> {
    public ConfusionArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ConfusionArrowEntity entity) {
        return new Identifier(SuperArrowsMod.MODID,"textures/entity/projectiles/confusion_arrow.png");
    }
}
