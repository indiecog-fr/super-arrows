package fr.indiecog.superarrows.renderer;

import fr.indiecog.superarrows.SuperArrowsMod;
import fr.indiecog.superarrows.entity.projectile.arrow.LightningArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LightningArrowEntityRenderer extends ProjectileEntityRenderer<LightningArrowEntity> {
    public LightningArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(LightningArrowEntity entity) {
        return new Identifier(SuperArrowsMod.MODID,"textures/entity/projectiles/lightning_arrow.png");
    }
}
