package luke.cavecliff.mixin;

import luke.cavecliff.block.CaveCliffBlocks;
import luke.cavecliff.item.CaveCliffItems;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuInventory;
import net.minecraft.core.player.inventory.menu.MenuInventoryCreative;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItems;
import static net.minecraft.core.player.inventory.menu.MenuInventoryCreative.creativeItemsCount;

@Mixin(value = MenuInventoryCreative.class, remap = false)
public class MenuInventoryCreativeMixin extends MenuInventory {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        List<ItemStack> copperBlockVariants = new ArrayList<>();
        List<ItemStack> copperBrickVariants = new ArrayList<>();
        List<ItemStack> copperFenceVariants = new ArrayList<>();
        List<ItemStack> copperStairsVariants = new ArrayList<>();
        List<ItemStack> copperSlabVariants = new ArrayList<>();
        List<ItemStack> copperTrapDoorVariants = new ArrayList<>();
        List<ItemStack> candleVariants = new ArrayList<>();
        List<ItemStack> copperDoorItemVariants = new ArrayList<>();
        List<ItemStack> copperRodVariants = new ArrayList<>();

        for (int i = 1; i <= 3; ++i) {
            copperBlockVariants.add(new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, i));
            copperBrickVariants.add(new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, i));
            copperFenceVariants.add(new ItemStack(CaveCliffBlocks.FENCE_COPPER, 1, i));
            copperRodVariants.add(new ItemStack(CaveCliffBlocks.LIGHTNING_ROD, 1, i));
            copperDoorItemVariants.add(new ItemStack(CaveCliffItems.DOOR_COPPER, 1, i));
        }

        for (int i = 1; i <= 3; ++i) {
            int meta = i << 4;
            copperStairsVariants.add(new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 1, meta));
            copperSlabVariants.add(new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 1, meta));
            copperTrapDoorVariants.add(new ItemStack(CaveCliffBlocks.TRAPDOOR_COPPER, 1, meta));
        }

        for (int i = 1; i <= 15; ++i) {
            candleVariants.add(new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, i));
        }

        List<ItemStack> newCreativeItems = new ArrayList<>();

        for (ItemStack item : creativeItems) {
            newCreativeItems.add(item);

            if (item.itemID == CaveCliffBlocks.BLOCK_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperBlockVariants);
            } else if (item.itemID == CaveCliffBlocks.BRICK_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperBrickVariants);
            } else if (item.itemID == CaveCliffBlocks.FENCE_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperFenceVariants);
            } else if (item.itemID == CaveCliffBlocks.STAIRS_BRICK_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperStairsVariants);
            } else if (item.itemID == CaveCliffBlocks.SLAB_BRICK_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperSlabVariants);
            } else if (item.itemID == CaveCliffBlocks.TRAPDOOR_COPPER.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperTrapDoorVariants);
            } else if (item.itemID == CaveCliffBlocks.CANDLE_COLORED.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(candleVariants);
            } else if (item.itemID == CaveCliffItems.DOOR_COPPER.id && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperDoorItemVariants);
            } else if (item.itemID == CaveCliffBlocks.LIGHTNING_ROD.id() && item.getMetadata() == 0) {
                newCreativeItems.addAll(copperRodVariants);
            }
        }

        creativeItems = newCreativeItems;
        creativeItemsCount = creativeItems.size();
    }

    public MenuInventoryCreativeMixin(ContainerInventory inventory) {
        super(inventory);
    }
}
