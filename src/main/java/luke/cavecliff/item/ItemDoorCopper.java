package luke.cavecliff.item;

import luke.cavecliff.block.BlockLogicCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemDoor;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemDoorCopper extends ItemDoor {
    public ItemDoorCopper(String name, String namespaceId, int id, Block<?> doorBottom, Block<?> doorTopId) {
        super(name, namespaceId, id, doorBottom, doorTopId);
    }

    @Override
    public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        if (!world.canPlaceInsideBlock(blockX, blockY, blockZ)) {
            blockX += side.getOffsetX();
            blockY += side.getOffsetY();
            blockZ += side.getOffsetZ();
        }

        if (!this.doorBlockBottom.canPlaceBlockAt(world, blockX, blockY, blockZ)) {
            return false;
        } else {
            Direction dir = player.getHorizontalPlacementDirection(side).rotate(3);
            int meta = dir.getHorizontalIndex();
            int xOffset = -dir.getOffsetX();
            int zOffset = -dir.getOffsetZ();
            int isSolidBlockLeft = (world.isBlockNormalCube(blockX - xOffset, blockY, blockZ - zOffset) ? 1 : 0) + (world.isBlockNormalCube(blockX - xOffset, blockY + 1, blockZ - zOffset) ? 1 : 0);
            int isSolidBlockRight = (world.isBlockNormalCube(blockX + xOffset, blockY, blockZ + zOffset) ? 1 : 0) + (world.isBlockNormalCube(blockX + xOffset, blockY + 1, blockZ + zOffset) ? 1 : 0);
            boolean isDoorLeft = world.getBlockId(blockX - xOffset, blockY, blockZ - zOffset) == this.doorBlockBottom.id() || world.getBlockId(blockX - xOffset, blockY + 1, blockZ - zOffset) == this.doorBlockTop.id();
            boolean isDoorRight = world.getBlockId(blockX + xOffset, blockY, blockZ + zOffset) == this.doorBlockBottom.id() || world.getBlockId(blockX + xOffset, blockY + 1, blockZ + zOffset) == this.doorBlockTop.id();
            boolean isMirrored = false;
            if (isDoorLeft && !isDoorRight) {
                isMirrored = true;
            } else if (isSolidBlockRight > isSolidBlockLeft) {
                isMirrored = true;
            }

            if (isMirrored) {
                meta = meta - 1 & 3;
                meta += 4;
                meta |= 8;
            }

            meta |= itemstack.getMetadata() << 4 & 240;
            world.noNeighborUpdate = true;
            world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.doorBlockBottom.id(), meta);
            world.setBlockAndMetadataWithNotify(blockX, blockY + 1, blockZ, this.doorBlockTop.id(), meta);
            world.noNeighborUpdate = false;
            world.notifyBlocksOfNeighborChange(blockX, blockY, blockZ, this.doorBlockBottom.id());
            world.notifyBlocksOfNeighborChange(blockX, blockY + 1, blockZ, this.doorBlockTop.id());
            world.playBlockSoundEffect(player, (float) blockX + 0.5F, (float) blockY + 0.5F, (float) blockZ + 0.5F, this.doorBlockBottom, EnumBlockSoundEffectType.PLACE);
            this.doorBlockBottom.onBlockPlacedByMob(world, blockX, blockY, blockZ, side, player, xPlaced, yPlaced);
            this.doorBlockTop.onBlockPlacedByMob(world, blockX, blockY + 1, blockZ, side, player, xPlaced, yPlaced);
            itemstack.consumeItem(player);
            return true;
        }
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        return super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((itemstack.getMetadata() & 3))];
    }
}
