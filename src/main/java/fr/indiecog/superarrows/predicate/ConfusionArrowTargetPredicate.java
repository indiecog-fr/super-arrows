package fr.indiecog.superarrows.predicate;

import net.minecraft.entity.LivingEntity;

import java.util.function.Predicate;

public class ConfusionArrowTargetPredicate implements Predicate<LivingEntity> {

    private final LivingEntity myself;

    public ConfusionArrowTargetPredicate(LivingEntity me) {
        myself = me;
    }

    @Override
    public boolean test(LivingEntity livingEntity) {
        return !(livingEntity.isPlayer() || livingEntity.equals(myself));
    }
}
