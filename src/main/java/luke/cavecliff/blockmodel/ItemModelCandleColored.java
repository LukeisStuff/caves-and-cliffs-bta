package luke.cavecliff.blockmodel;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

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
		DyeColor c;
		for (Iterator<DyeColor> var0 = DyeColor.itemOrderedColors().iterator(); var0.hasNext(); dyeIcons[c.itemMeta] = TextureRegistry.getTexture("cavecliff:item/candle_" + c.colorID)) {
			c = var0.next();
		}

	}
}
