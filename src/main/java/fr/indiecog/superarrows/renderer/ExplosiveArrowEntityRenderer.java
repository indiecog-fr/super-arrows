package fr.indiecog.superarrows.renderer;

import fr.indiecog.superarrows.entity.projectile.arrow.ExplosiveArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

import static fr.indiecog.superarrows.SuperArrowsMod.MODID;

@Environment(EnvType.CLIENT)
public class ExplosiveArrowEntityRenderer extends ProjectileEntityRenderer<ExplosiveArrowEntity> {
    public ExplosiveArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ExplosiveArrowEntity entity) {
        return new Identifier(MODID, "textures/entity/projectiles/explosive_arrow.png");
    }
}
