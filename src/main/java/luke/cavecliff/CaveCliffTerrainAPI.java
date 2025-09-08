//package luke.cavecliff;
//
//import luke.cavecliff.world.WorldFeatureFlowersRotated;
//import luke.cavecliff.world.WorldFeatureGeode;
//import luke.cavecliff.world.WorldFeaturePowderSnow;
//import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
//import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;
//import useless.terrainapi.api.TerrainAPI;
//import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;
//
//import static luke.cavecliff.CaveCliffMod.MOD_ID;
//
//public class CaveCliffTerrainAPI implements TerrainAPI {
//	@Override
//	public String getModID() {
//		return MOD_ID;
//	}
//
//	@Override
//	public void onInitialize() {
//
//
//
//
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeaturePowderSnow(), 12, 1.0f);
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureTreeFancy(CaveCliffBlocks.leavesAzalea.id, CaveCliffBlocks.logAzalea.id, 1), 1, 1.0f);
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureTreeFancy(CaveCliffBlocks.leavesAzaleaFlowering.id, CaveCliffBlocks.logAzalea.id, 1), 2, 1.0f);
//
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowersRotated(CaveCliffBlocks.dripleafBig.id), 8, -1f);
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(CaveCliffBlocks.dripleafSmall.id), 8, -1f);
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(CaveCliffBlocks.flowerSpore.id), 1, 1.0f);
//
//		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(CaveCliffBlocks.roots.id), 1, 1.0f);
//
//
//
//	}
//}
