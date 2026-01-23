package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;

import java.util.Random;

public class BlockLogicSaplingAzalea extends BlockLogicSaplingBase {
    Block<?> leafBlock;

    public BlockLogicSaplingAzalea(Block<?> block, Block<?> leafBlock) {
        super(block);
        this.leafBlock = leafBlock;
    }

    public void growTree(World world, int x, int y, int z, Random random) {
        WorldFeature treeFeature;
        world.setBlock(x, y, z, 0);
        world.setBlock(x, y - 1, z, CaveCliffBlocks.DIRT_ROOTED.id());
        treeFeature = new WorldFeatureTreeFancy(leafBlock.id(), CaveCliffBlocks.LOG_AZALEA.id(), 0);
        if (!treeFeature.place(world, random, x, y, z)) {
            world.setBlock(x, y, z, this.id());
        }

    }

}
