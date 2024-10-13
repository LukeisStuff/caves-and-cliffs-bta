package luke.cavecliff.mixin;

import luke.cavecliff.world.WorldGenTreeShapeSwamp;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.BiomeSwamp;
import net.minecraft.core.world.generate.feature.WorldFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value= BiomeSwamp.class,remap=false)
public class SwampBiomeVinesMixin {
	@Inject(method = "getRandomWorldGenForTrees", at = @At(value = "HEAD", target = "Lnet/minecraft/core/world/biome/BiomeRainforest;getRandomWorldGenForTrees(Ljava/util/Random;)Lnet/minecraft/core/world/generate/feature/WorldFeature;"), cancellable = true)
	public void getRandomWorldGenForTrees(Random random, CallbackInfoReturnable<WorldFeature> cir) {
		{
			cir.setReturnValue(new WorldGenTreeShapeSwamp(Block.leavesOak.id, Block.logOakMossy.id, 6));
		}
		cir.cancel();
	}
}
