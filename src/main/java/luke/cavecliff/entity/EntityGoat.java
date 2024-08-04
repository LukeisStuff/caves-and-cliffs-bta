package luke.cavecliff.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBucketEmpty;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.ItemToolShears;
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
		if (!this.getSheared()) {
			this.spawnAtLocation(Block.wool.id, 1, 0.0F);
		}
	}

	public boolean getSheared() {
		return (this.entityData.getByte(16) & 16) != 0;
	}

	public boolean interact(EntityPlayer entityplayer) {
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (itemstack != null && itemstack.itemID == Item.bucket.id) {
			ItemBucketEmpty.useBucket(entityplayer, new ItemStack(Item.bucketMilk));
			return true;
		}
			if (itemstack != null && itemstack.getItem() instanceof ItemToolShears && !this.getSheared()) {
				if (!this.world.isClientSide) {
					this.setSheared(true);
					int count = 2 + this.random.nextInt(3);

					for(int j = 0; j < count; ++j) {
						EntityItem entityitem = this.spawnAtLocation(Block.wool.id, 1, 0.0F);
						entityitem.yd += this.random.nextFloat() * 0.05F;
						entityitem.xd += (this.random.nextFloat() - this.random.nextFloat()) * 0.1F;
						entityitem.zd += (this.random.nextFloat() - this.random.nextFloat()) * 0.1F;
					}
				}

				itemstack.damageItem(1, entityplayer);
				if (itemstack.stackSize <= 0) {
					entityplayer.destroyCurrentEquippedItem();
				}

				return true;
			} else {
				return false;
			}
		}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Sheared", this.getSheared());
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.setSheared(tag.getBoolean("Sheared"));
	}

	public void setSheared(boolean flag) {
		byte byte0 = this.entityData.getByte(16);
		if (flag) {
			this.entityData.set(16, (byte)(byte0 | 16));
		} else {
			this.entityData.set(16, (byte)(byte0 & -17));
		}

	}

}
