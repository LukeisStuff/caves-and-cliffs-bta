package luke.cavecliff.entity;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.animal.EntitySquid;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class EntityGlowSquid extends EntitySquid {
	public EntityGlowSquid(World world) {
		super(world);
		this.isInWater();
		this.textureIdentifier = new NamespaceID("cavecliff", "glowsquid");
		this.setSize(0.95F, 0.95F);
		this.mobDrops.add(new WeightedRandomLootObject(Item.dye.getDefaultStack(), 1, 3));
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 4;
		return this.entityData.getByte(1) % skinVariantCount;
	}

}
