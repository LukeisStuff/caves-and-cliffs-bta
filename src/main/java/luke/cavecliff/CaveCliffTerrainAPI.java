package luke.cavecliff;

import luke.cavecliff.world.WorldFeatureGeode;
import luke.cavecliff.world.WorldFeaturePowderSnow;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffTerrainAPI implements TerrainAPI {
	@Override
	public String getModID() {
		return MOD_ID;
	}

	@Override
	public void onInitialize() {
		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(getModID(), CaveCliffBlocks.oreCopperStone, 10, 16, 0.0f, 0.5f, true);

		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureGeode(), 24, 0.25f);

		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(getModID(), CaveCliffBlocks.dripstone, 32, 1, 0.0f, 0.5f, false);

		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(getModID(), CaveCliffBlocks.moss, 32, 1, 0.5f, false);

		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeaturePowderSnow(), 12, 1.0f);


	}
}
