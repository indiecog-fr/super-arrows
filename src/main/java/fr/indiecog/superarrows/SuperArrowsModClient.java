package fr.indiecog.superarrows;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.renderer.GlowingArrowEntityRenderer;
import fr.indiecog.superarrows.renderer.ExplosiveArrowEntityRenderer;
import fr.indiecog.superarrows.renderer.LightningArrowEntityRenderer;
import fr.indiecog.superarrows.renderer.VineArrowEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SuperArrowsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SuperArrowsEntities.GLOWING_ARROW_ENTITY, GlowingArrowEntityRenderer::new);
        EntityRendererRegistry.register(SuperArrowsEntities.EXPLOSIVE_ARROW_ENTITY, ExplosiveArrowEntityRenderer::new);
        EntityRendererRegistry.register(SuperArrowsEntities.LIGHTNING_ARROW_ENTITY, LightningArrowEntityRenderer::new);
        EntityRendererRegistry.register(SuperArrowsEntities.VINE_ARROW_ENTITY, VineArrowEntityRenderer::new);
    }
}
