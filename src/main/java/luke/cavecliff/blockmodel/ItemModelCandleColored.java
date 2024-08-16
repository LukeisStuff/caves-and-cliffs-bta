package luke.cavecliff.blockmodel;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemModelCandleColored
	extends ItemModelStandard {
	public static IconCoordinate[] dyeIcons = new IconCoordinate[16];

	public ItemModelCandleColored(Item item) {
		super(item, null);
	}

	@Override
	@NotNull
	public IconCoordinate getIcon(@Nullable Entity entity, ItemStack itemStack) {
		int meta = itemStack.getMetadata();
		return dyeIcons[MathHelper.clamp(meta, 0, 15)];
	}

	static {
		for (int i = 0; i < 16; ++i) {
			ItemModelCandleColored.dyeIcons[i] = TextureRegistry.getTexture("cavecliff:item/candle_" + ItemDye.dyeColors[15- i]);
		}
	}
}
