package luke.cavecliff;

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
	}
}
