package luke.cavecliff.blockmodel;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemModelAmethystCluster
	extends ItemModelStandard {
	public IconCoordinate medium = TextureRegistry.getTexture("cavecliff:block/amethyst_medium");
	public IconCoordinate large = TextureRegistry.getTexture("cavecliff:block/amethyst_large");
	public IconCoordinate cluster = TextureRegistry.getTexture("cavecliff:block/amethyst_cluster");

	public ItemModelAmethystCluster(Item item) {
		super(item, null);
	}

	@Override
	@NotNull
	public IconCoordinate getIcon(@Nullable Entity entity, ItemStack itemStack) {
		if (itemStack.getMetadata() == 1) {
			return this.medium;
		}
		if (itemStack.getMetadata() == 2) {
			return this.large;
		}
		if (itemStack.getMetadata() == 3) {
			return this.cluster;
		}
		return super.getIcon(entity, itemStack);
	}
}
