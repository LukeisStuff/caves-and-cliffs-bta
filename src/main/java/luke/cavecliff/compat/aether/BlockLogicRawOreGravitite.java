package luke.cavecliff.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import teamport.aether.entity.floating_block.EntityFloatingBlock;

import java.util.Random;

public class BlockLogicRawOreGravitite extends BlockLogic {

    public BlockLogicRawOreGravitite(Block<?> block) {
        super(block, Material.metal);
    }

    @Override
    public void onBlockPlacedByWorld(World world, int x, int y, int z) {
        world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
        world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        this.tryToFall(world, x, y, z);
    }

    public void tryToFall(World world, int x, int y, int z) {
        if (canFallAbove(world, x, y + 1, z) && y < 256) {
            byte byte0 = 32;
            if (world.areBlocksLoaded(x - byte0, y - byte0, z - byte0, x + byte0, y + byte0, z + byte0)) {
                EntityFloatingBlock entityFloatingBlock = new EntityFloatingBlock(world, (double) x + (double) 0.5F, (double) y + (double) 0.5F, (double) z + (double) 0.5F, this.block.id(), 0, (TileEntity) null);
                world.entityJoinedWorld(entityFloatingBlock);
                world.setBlockWithNotify(x, y, z, 0);
            } else {
                world.setBlockWithNotify(x, y, z, 0);

                while (canFallAbove(world, x, y + 1, z) && y < 256) {
                    ++y;
                }

                if (y < 256) {
                    world.setBlockWithNotify(x, y, z, this.block.id());
                }
            }
        }

    }

    @Override
    public int tickDelay() {
        return 3;
    }

    public static boolean canFallAbove(World world, int x, int y, int z) {
        Block<?> block = world.getBlock(x, y, z);
        return block == null || block.hasTag(BlockTags.PLACE_OVERWRITES);
    }

}
