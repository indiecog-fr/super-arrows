package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SuperArrowsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SuperArrowsEntities.GLOWING_ARROW_ENTITY, GlowingArrowEntityRenderer::new);
    }
}
