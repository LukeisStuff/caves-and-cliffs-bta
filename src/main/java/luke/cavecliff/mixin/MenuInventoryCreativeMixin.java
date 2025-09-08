package luke.cavecliff.mixin;

import luke.cavecliff.CaveCliffBlocks;
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
		List<ItemStack> copperStairsVariants = new ArrayList<>();
		List<ItemStack> copperSlabVariants = new ArrayList<>();

		for (int i = 1; i <= 3; ++i) {
			copperBlockVariants.add(new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, i));
			copperBrickVariants.add(new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, i));
		}

		for (int i = 1; i <= 3; ++i) {
			int meta = i << 4;
			copperStairsVariants.add(new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 1, meta));
			copperSlabVariants.add(new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 1, meta));
		}

		List<ItemStack> newCreativeItems = new ArrayList<>();

		for (ItemStack item : creativeItems) {
			newCreativeItems.add(item);

			if (item.itemID == CaveCliffBlocks.BLOCK_COPPER.id() && item.getMetadata() == 0) {
				newCreativeItems.addAll(copperBlockVariants);
			} else if (item.itemID == CaveCliffBlocks.BRICK_COPPER.id() && item.getMetadata() == 0) {
				newCreativeItems.addAll(copperBrickVariants);
			} else if (item.itemID == CaveCliffBlocks.STAIRS_BRICK_COPPER.id() && item.getMetadata() == 0) {
				newCreativeItems.addAll(copperStairsVariants);
			} else if (item.itemID == CaveCliffBlocks.SLAB_BRICK_COPPER.id() && item.getMetadata() == 0) {
				newCreativeItems.addAll(copperSlabVariants);
			}
		}


		creativeItems = newCreativeItems;
		creativeItemsCount = creativeItems.size();
	}

	public MenuInventoryCreativeMixin(ContainerInventory inventory) {
		super(inventory);
	}
}
