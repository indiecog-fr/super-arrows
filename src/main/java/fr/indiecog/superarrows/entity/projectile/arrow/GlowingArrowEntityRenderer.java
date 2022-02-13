package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.SuperArrowsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GlowingArrowEntityRenderer extends ProjectileEntityRenderer<GlowingArrowEntity> {
    public GlowingArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(GlowingArrowEntity entity) {
        return new Identifier(SuperArrowsMod.MODID, "textures/entity/projectiles/glowing_arrow.png");
    }
}
