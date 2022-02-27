package fr.indiecog.superarrows.renderer;

import fr.indiecog.superarrows.SuperArrowsMod;
import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.arrow.TracingArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class TracingArrowEntityRenderer extends ProjectileEntityRenderer<TracingArrowEntity> {
    public TracingArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TracingArrowEntity entity) {
        return new Identifier(SuperArrowsMod.MODID, "textures/entity/projectiles/tracing_arrow.png");
    }
}
