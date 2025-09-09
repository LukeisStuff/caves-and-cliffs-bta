package luke.cavecliff.mixin;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.world.biome.BiomeForest;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = BiomeForest.class, remap = false)
public abstract class BiomeForestAzaleaTreeMixin {

	@Inject(method = "getRandomWorldGenForTrees", at = @At("RETURN"), cancellable = true)
	private void getRandomWorldGenForTrees(Random random, CallbackInfoReturnable<WorldFeature> cir) {
		WorldFeature original = cir.getReturnValue();
		if (original instanceof WorldFeatureTree) {
			if (random.nextInt(20) == 0) {
				if (random.nextInt(2) == 0) {
					cir.setReturnValue(new WorldFeatureTreeFancy(CaveCliffBlocks.LEAVES_AZALEA.id(), CaveCliffBlocks.LOG_AZALEA.id(), 1));
				} else {
					cir.setReturnValue(new WorldFeatureTreeFancy(CaveCliffBlocks.LEAVES_AZALEA_FLOWERING.id(), CaveCliffBlocks.LOG_AZALEA.id(), 1));
				}
			}
		}
	}
}
