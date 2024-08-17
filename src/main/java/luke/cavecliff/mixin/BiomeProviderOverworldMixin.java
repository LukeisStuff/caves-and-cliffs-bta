package luke.cavecliff.mixin;

import net.minecraft.core.world.biome.data.BiomeRangeMap;
import net.minecraft.core.world.biome.provider.BiomeProviderOverworld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= BiomeProviderOverworld.class,remap=false)
public abstract class BiomeProviderOverworldMixin {
	@Shadow
	@Final
	private static BiomeRangeMap brm;
	@Inject(method="init",at=@At(value = "INVOKE",ordinal=0,target = "Lnet/minecraft/core/world/biome/data/BiomeRangeMap;lock()V"), cancellable = true)
	private static void injectAfterRainforest(CallbackInfo ci) {
//		brm.addRange(CaveCliffBiomes.OVERWORLD_PEAK_SNOW, new BiomeRange(0.0,1.01,0.0,1.01,0.85,1.00,0.00,1.0));
		ci.cancel();
	}
}
