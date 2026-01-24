package luke.cavecliff.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import luke.cavecliff.block.CaveCliffBlocks;
import luke.cavecliff.block.BlockLogicOreCopper;
import luke.cavecliff.world.WorldFeatureGeode;
import luke.cavecliff.world.WorldFeaturePowderSnow;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public class ChunkDecoratorOverworldMixin {

    @Shadow
    @Final
    private World world;

    @Inject(method = "decorate", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 104))
    public void decorate(Chunk chunk, CallbackInfo ci, @Local(name = "rand") Random rand, @Local(name = "x") int x, @Local(name = "z") int z, @Local(name = "y") int y) {
        int minY = this.world.getWorldType().getMinY();
        int maxY = this.world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;
        float oreHeightModifier = (float) rangeY / 128.0F;
        int j4;
        int xArea;
        int yHeight;
        int zArea;

        for (j4 = 0; (float) j4 < 20.0F * oreHeightModifier; ++j4) {
            xArea = x + rand.nextInt(16);
            yHeight = minY + rand.nextInt(rangeY);
            zArea = z + rand.nextInt(16);
            (new WorldFeatureOre(BlockLogicOreCopper.variantMap, 12)).place(this.world, rand, xArea, yHeight, zArea);
        }

        for (j4 = 0; (float) j4 < 15.0F * oreHeightModifier; ++j4) {
            xArea = x + rand.nextInt(16);
            yHeight = minY + rand.nextInt(rangeY);
            zArea = z + rand.nextInt(16);
            (new WorldFeatureOre(CaveCliffBlocks.DIRT_ROOTED.id(), 32)).place(this.world, rand, xArea, yHeight, zArea);
        }

        for (j4 = 0; (float) j4 < 5.0F * oreHeightModifier; ++j4) {
            xArea = x + rand.nextInt(16);
            yHeight = minY + rand.nextInt(rangeY);
            zArea = z + rand.nextInt(16);
            (new WorldFeatureOre(CaveCliffBlocks.DRIPSTONE.id(), 32)).place(this.world, rand, xArea, yHeight, zArea);
        }

        for (j4 = 0; (float) j4 < 10.0F * oreHeightModifier; ++j4) {
            xArea = x + rand.nextInt(16);
            yHeight = minY + rand.nextInt(rangeY);
            zArea = z + rand.nextInt(16);
            (new WorldFeatureOre(CaveCliffBlocks.BLOCK_MOSS.id(), 32)).place(this.world, rand, xArea, yHeight, zArea);
        }

        xArea = x + rand.nextInt(16);
        yHeight = minY + rand.nextInt(rangeY);
        zArea = z + rand.nextInt(16);
        new WorldFeatureFlowers(CaveCliffBlocks.ROOTS.id(), 128, false).place(world, rand, xArea, yHeight, zArea);
        new WorldFeatureFlowers(CaveCliffBlocks.DRIPLEAF_SMALL.id(), 128, false).place(world, rand, xArea, yHeight, zArea);
        new WorldFeatureFlowers(CaveCliffBlocks.FLOWER_SPORE.id(), 64, false).place(world, rand, xArea, yHeight, zArea);

        if ((rand.nextInt(25) == 0)) {
            xArea = x + rand.nextInt(16);
            yHeight = minY + rand.nextInt(rangeY / 3);
            zArea = z + rand.nextInt(16);
            (new WorldFeatureGeode()).place(this.world, rand, xArea, yHeight, zArea);
        }

        Biome biome = this.world.getBlockBiome(x + 16, y, z + 16);
        if (biome == Biomes.OVERWORLD_GLACIER || biome == Biomes.OVERWORLD_TUNDRA) {
            for (int i4 = 0; (float) i4 < 5.0F * oreHeightModifier; ++i4) {
                int j7 = x + rand.nextInt(16);
                int k10 = minY + rand.nextInt(rangeY / 2);
                int j13 = z + rand.nextInt(16);
                (new WorldFeaturePowderSnow(32 + rand.nextInt(32), Blocks.BLOCK_SNOW)).place(this.world, rand, j7, k10, j13);
            }
        }

    }
}
