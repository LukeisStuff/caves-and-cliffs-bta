package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureAlgae;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldGenTreeShapeSwamp extends WorldFeature {
    public int leavesID;
    public int logID;
    public int heightMod;
    public Random treeRand = new Random();

    public WorldGenTreeShapeSwamp(int leavesID, int logID, int heightMod) {
        this.leavesID = leavesID;
        this.logID = logID;
        this.heightMod = heightMod;
    }

    @Override
    public boolean place(World world, Random random, int x, int y, int z) {
        int trunkLength = random.nextInt(4) + this.heightMod;
        boolean flag = true;
        if (y < 1 || y + trunkLength + 1 > world.getHeightBlocks()) {
            return false;
        }
        for (int i1 = y; i1 <= y + 1 + trunkLength; ++i1) {
            int byte0 = 1;
            if (i1 == y) {
                byte0 = 0;
            }
            if (i1 >= y + 1 + trunkLength - 2) {
                byte0 = 2;
            }
            for (int i2 = x - byte0; i2 <= x + byte0 && flag; ++i2) {
                for (int l2 = z - byte0; l2 <= z + byte0 && flag; ++l2) {
                    if (i1 >= 0 && i1 < world.getHeightBlocks()) {
                        int j3 = world.getBlockId(i2, i1, l2);
                        if (j3 == 0 || j3 == this.leavesID) continue;
                        flag = false;
                        continue;
                    }
                    flag = false;
                }
            }
        }
        if (!flag) {
            return false;
        }
        int sinkToFloor = 0;
        while (world.getBlockId(x, y - sinkToFloor - 1, z) == Blocks.FLUID_WATER_STILL.id()) {
            if (sinkToFloor > 3) {
                return false;
            }
            ++sinkToFloor;
        }
        int oldY = y;
        int idBelow = world.getBlockId(x, (y -= sinkToFloor) - 1, z);
        if (!Blocks.hasTag(idBelow, BlockTags.GROWS_TREES) || y >= world.getHeightBlocks() - trunkLength + sinkToFloor - 1) {
            return false;
        }
        WorldFeatureTree.onTreeGrown(world, x, y, z);
        world.setBlockWithNotify(x, y - 1, z, Blocks.DIRT.id());

        for (int k1 = y - 3 + trunkLength + sinkToFloor; k1 <= y + trunkLength + sinkToFloor; ++k1) {
            int j2 = k1 - (y + trunkLength + sinkToFloor);
            int i3 = 2 - j2 / 2;
            for (int k3 = x - i3; k3 <= x + i3; ++k3) {
                int l3 = k3 - x;
                for (int i4 = z - i3; i4 <= z + i3; ++i4) {
                    int j4 = i4 - z;
                    if (Math.abs(l3) == i3 && Math.abs(j4) == i3 && (random.nextInt(2) == 0 || j2 == 0) || Blocks.solid[world.getBlockId(k3, k1, i4)])
                        continue;

                    if (world.getBlockId(k3, k1, i4) == 0) {
                        world.setBlockWithNotify(k3, k1, i4, this.leavesID);
                    }

                    int maxLength = this.treeRand.nextInt(5) + 1;
                    boolean isVine = false;
                    for (int q = 1; q < maxLength; ++q) {
                        int currentY = k1 - q;
                        if (k3 == x && i4 == z && currentY >= y && currentY < y + trunkLength + sinkToFloor) continue;
                        if (world.getBlockId(k3, currentY, i4) != 0) break;

                        if (isVine) {
                            world.setBlock(k3, currentY, i4, CaveCliffBlocks.VINES.id());
                        } else {
                            if (this.treeRand.nextFloat() < 0.3) {
                                world.setBlock(k3, currentY, i4, CaveCliffBlocks.VINES.id());
                                isVine = true;
                            } else {
                                world.setBlockWithNotify(k3, currentY, i4, this.leavesID);
                            }
                        }
                    }
                }
            }
        }

        for (int l1 = 0; l1 < trunkLength + sinkToFloor; ++l1) {
            int k2 = world.getBlockId(x, y + l1, z);
            if (k2 != 0 && k2 != this.leavesID && k2 != Blocks.FLUID_WATER_STILL.id() && k2 != Blocks.FLUID_WATER_FLOWING.id())
                continue;
            world.setBlockWithNotify(x, y + l1, z, this.logID);
        }

        if (random.nextInt(2) == 0) {
            new WorldFeatureAlgae().place(world, this.treeRand, x, oldY - 1, z);
        } else {
            new WorldFeatureDripleaf().place(world, this.treeRand, x, oldY - 1, z);
        }
        return true;
    }
}
