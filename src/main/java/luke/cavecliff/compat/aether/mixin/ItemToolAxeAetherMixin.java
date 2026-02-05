package luke.cavecliff.compat.aether.mixin;

import luke.cavecliff.block.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.item.item_tool.ItemToolAxeAether;

import java.util.Random;

@Pseudo
@Mixin(value = ItemToolAxeAether.class, remap = false)
public class ItemToolAxeAetherMixin extends ItemTool {

    protected ItemToolAxeAetherMixin(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
        super(name, namespaceId, id, 3, enumtoolmaterial, AetherBlockTags.MINEABLE_BY_AETHER_AXE);
    }

    @Override
    public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return this.scrapeBlock(itemstack, player, world, x, y, z);
    }

    @Override
    public void onUseByActivator(ItemStack itemstack, TileEntityActivator activatorBlock, World world, Random random, int x, int y, int z, double offX, double offY, double offZ, Direction direction) {
        this.scrapeBlock(itemstack, null, world, x + direction.getOffsetX(), y + direction.getOffsetY(), z + direction.getOffsetZ());
    }

    @Unique
    public boolean scrapeBlock(ItemStack itemstack, @Nullable Player player, World world, int x, int y, int z) {
        int blockId = world.getBlockId(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        if (meta > 0) {
            if (blockId == CaveCliffBlocks.BLOCK_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.BLOCK_COPPER, 1);
                return true;
            } else if (blockId == CaveCliffBlocks.BRICK_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.BRICK_COPPER, 1);
                return true;
            } else if (blockId == CaveCliffBlocks.FENCE_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.FENCE_COPPER, 1);
                return true;
            } else if (blockId == CaveCliffBlocks.SLAB_BRICK_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.SLAB_BRICK_COPPER, 16);
                return true;
            } else if (blockId == CaveCliffBlocks.STAIRS_BRICK_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.STAIRS_BRICK_COPPER, 16);
                return true;
            } else if (blockId == CaveCliffBlocks.TRAPDOOR_COPPER.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.TRAPDOOR_COPPER, 16);
                return true;
            } else if (blockId == CaveCliffBlocks.LIGHTNING_ROD.id()) {
                scrapeBlock(world, x, y, z, itemstack, player, CaveCliffBlocks.LIGHTNING_ROD, 1);
                return true;
            }
        }

        if (meta > 15) {
            if (blockId == CaveCliffBlocks.DOOR_COPPER_TOP.id()) {
                scrapeDoor(world, x, y, z, itemstack, player, true);
            } else if (blockId == CaveCliffBlocks.DOOR_COPPER_BOTTOM.id()) {
                scrapeDoor(world, x, y, z, itemstack, player, false);
            }
            return true;
        }

        return false;
    }


    @Unique
    private void scrapeBlock(World world, int x, int y, int z, ItemStack itemstack, Player player, Block<?> block, int metaDecrease) {
        int meta = world.getBlockMetadata(x, y, z);
        world.playBlockSoundEffect(null, x + 0.5f, y + 0.5f, z + 0.5f, block, EnumBlockSoundEffectType.MINE);
        if (!world.isClientSide) {
            world.setBlockAndMetadataWithNotify(x, y, z, block.id(), meta - metaDecrease);
            itemstack.damageItem(1, player);
        }
    }

    @Unique
    private void scrapeDoor(World world, int x, int y, int z, ItemStack itemstack, Player player, boolean isTop) {
        int bottomY = isTop ? y - 1 : y;
        int meta = world.getBlockMetadata(x, bottomY, z);
        world.playBlockSoundEffect(null, x + 0.5f, y + 0.5f, z + 0.5f, isTop ? CaveCliffBlocks.DOOR_COPPER_TOP : CaveCliffBlocks.DOOR_COPPER_BOTTOM, EnumBlockSoundEffectType.MINE);

        if (!world.isClientSide) {
            world.setBlockAndMetadataWithNotify(x, bottomY, z, CaveCliffBlocks.DOOR_COPPER_BOTTOM.id(), meta - 16);
            world.setBlockAndMetadataWithNotify(x, bottomY + 1, z, CaveCliffBlocks.DOOR_COPPER_TOP.id(), meta - 16);
            itemstack.damageItem(1, player);
        }
    }

}
