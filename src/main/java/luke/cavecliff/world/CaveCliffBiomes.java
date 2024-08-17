package luke.cavecliff.world;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffBiomes {

	public static final Biome OVERWORLD_PEAK_SNOW = new BiomePeakSnow("cavecliff.peak.snowy");


	public void initializeBiomes() {
		Biomes.register(MOD_ID+":overworld.peak.snowy", OVERWORLD_PEAK_SNOW);
	}

}
