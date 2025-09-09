package luke.cavecliff.mixin;

import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = Biome.class, remap = false)
public class BiomeSpawnableListMixin {
	@Shadow
	protected List<SpawnListEntry> spawnableWaterCreatureList;
	@Shadow
	protected List<SpawnListEntry> spawnableCreatureList;

	@Inject(method = "<init>", at = @At("TAIL"))
	public void injectMethod(String key, CallbackInfo ci) {
		this.spawnableWaterCreatureList.add(new SpawnListEntry(MobGlowSquid.class, 5));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(MobAxolotl.class, 1));
		this.spawnableCreatureList.add(new SpawnListEntry(MobGoat.class, 102));
	}
}
