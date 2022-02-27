package fr.indiecog.superarrows.renderer;

import fr.indiecog.superarrows.SuperArrowsMod;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.VineArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class VineArrowEntityRenderer extends ProjectileEntityRenderer<VineArrowEntity> {
    public VineArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(VineArrowEntity entity) {
        return new Identifier(SuperArrowsMod.MODID, "textures/entity/projectiles/vine_arrow.png");
    }
}
