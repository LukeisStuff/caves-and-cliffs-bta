package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.item.tool.ItemToolShears;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockLogicDirtRooted extends BlockLogic implements IBonemealable {


    public BlockLogicDirtRooted(Block<?> block) {
        super(block, Material.dirt);
    }


    public void onBlockLeftClicked(World world, int x, int y, int z, Player player, Side side, double xHit, double yHit) {
        if (!Item.hasTag(player.getCurrentEquippedItem(), ItemTags.PREVENT_LEFT_CLICK_INTERACTIONS)) {
            this.onBlockRightClicked(world, x, y, z, player, null, 0.0, 0.0);
        }

    }

    public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xHit, double yHit) {
        ItemStack heldItem = player.getHeldItem();
        if (heldItem != null && heldItem.getItem() instanceof ItemToolShears) {
            player.getHeldItem().damageItem(1, player);
            world.setBlockWithNotify(x, y, z, Blocks.DIRT.id());
            world.playSoundAtEntity(player, player, "random.pop", 0.2F, 0.5F);
            world.dropItem(x, y, z, new ItemStack(CaveCliffBlocks.ROOTS, 1));
            return true;
        }
        return false;
    }

    @Override
    public boolean onBonemealUsed(ItemStack itemStack, @Nullable Player player, World world, int i, int j, int k, Side side, double d, double e) {
        return world.setBlockWithNotify(i, j - 1, k, CaveCliffBlocks.ROOTS.id());
    }
}
