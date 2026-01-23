package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.MethodParametersAnnotation;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeaturePowderSnow extends WorldFeature {
    private final int blockId;
    private final int numberOfBlocks;
    private final int generateInId;

    @MethodParametersAnnotation(
        names = {"numberOfBlocks", "block"}
    )
    public WorldFeaturePowderSnow(int numberOfBlocks, Block<?> block) {
        this.blockId = CaveCliffBlocks.BLOCK_SNOW_POWDER.id();
        this.numberOfBlocks = numberOfBlocks;
        this.generateInId = block.id();
    }

    public boolean place(World world, Random random, int x, int y, int z) {
        float f = random.nextFloat() * 3.141593F;
        double d = (float) (x + 8) + MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F;
        double d1 = (float) (x + 8) - MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F;
        double d2 = (float) (z + 8) + MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F;
        double d3 = (float) (z + 8) - MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F;
        double d4 = y + random.nextInt(3) + 2.0F;
        double d5 = y + random.nextInt(3) + 2.0F;

        for (int l = 0; l <= this.numberOfBlocks; ++l) {
            double d6 = d + (d1 - d) * (double) l / (double) this.numberOfBlocks;
            double d7 = d4 + (d5 - d4) * (double) l / (double) this.numberOfBlocks;
            double d8 = d2 + (d3 - d2) * (double) l / (double) this.numberOfBlocks;
            double d9 = random.nextDouble() * (double) this.numberOfBlocks / (double) 16.0F;
            double d10 = (double) (MathHelper.sin((float) l * 3.141593F / (float) this.numberOfBlocks) + 1.0F) * d9 + (double) 1.0F;
            double d11 = (double) (MathHelper.sin((float) l * 3.141593F / (float) this.numberOfBlocks) + 1.0F) * d9 + (double) 1.0F;
            int i1 = MathHelper.floor(d6 - d10 / (double) 2.0F);
            int j1 = MathHelper.floor(d7 - d11 / (double) 2.0F);
            int k1 = MathHelper.floor(d8 - d10 / (double) 2.0F);
            int l1 = MathHelper.floor(d6 + d10 / (double) 2.0F);
            int i2 = MathHelper.floor(d7 + d11 / (double) 2.0F);
            int j2 = MathHelper.floor(d8 + d10 / (double) 2.0F);

            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double) k2 + (double) 0.5F - d6) / (d10 / (double) 2.0F);
                if (!(d12 * d12 >= (double) 1.0F)) {
                    for (int l2 = j1; l2 <= i2; ++l2) {
                        double d13 = ((double) l2 + (double) 0.5F - d7) / (d11 / (double) 2.0F);
                        if (!(d12 * d12 + d13 * d13 >= (double) 1.0F)) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                double d14 = ((double) i3 + (double) 0.5F - d8) / (d10 / (double) 2.0F);
                                if (d12 * d12 + d13 * d13 + d14 * d14 < (double) 1.0F && world.getBlockId(k2, l2, i3) == this.generateInId) {
                                    world.setBlock(k2, l2, i3, this.blockId);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
