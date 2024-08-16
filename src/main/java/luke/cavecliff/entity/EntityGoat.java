package luke.cavecliff.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class EntityGoat extends EntityAnimal {
	public EntityGoat(World world) {
		super(world);
		this.textureIdentifier = new NamespaceID("cavecliff", "goat");
		this.setSize(0.9F, 1.3F);
		this.mobDrops.add(new WeightedRandomLootObject(Block.wool.getDefaultStack(), 1, 5));
	}

	public void dropFewItems() {
		super.dropFewItems();
			this.spawnAtLocation(Block.wool.id, 1, 0.0F);
		}

	@Override
	protected void init() {
		this.entityData.define(16, (byte)0);
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 1;
		return this.entityData.getByte(1) % skinVariantCount;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

}
