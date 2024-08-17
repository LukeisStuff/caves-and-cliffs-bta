package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;

public class BiomePeakSnow extends Biome {
	public BiomePeakSnow(String key) {
		super(key);
		this.topBlock = (short) CaveCliffBlocks.blockSnowPowder.id;
		this.fillerBlock = (short) Block.blockSnow.id;
	}

	public boolean hasSurfaceSnow = true;

	public boolean hasSurfaceSnow() {
		return this.hasSurfaceSnow;
	}

	public Biome setSurfaceSnow() {
		this.hasSurfaceSnow = true;
		return this;
	}
}
