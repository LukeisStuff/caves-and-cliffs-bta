package luke.cavecliff.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.animal.EntityWaterAnimal;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class EntityAxolotl extends EntityWaterAnimal {
	public EntityAxolotl(World world) {
		super(world);
		this.textureIdentifier = new NamespaceID("cavecliff", "axolotl");
		this.setSize(0.5F, 0.5F);
	}

	@Override
	public void init() {
		this.entityData.define(16, (byte)0);
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 5;
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
