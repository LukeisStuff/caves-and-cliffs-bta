package luke.cavecliff.entity;

import com.mojang.nbt.CompoundTag;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBucketEmpty;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class EntityGoat extends EntityAnimal {
	public EntityGoat(World world) {
		super(world);
		this.textureIdentifier = new NamespaceID("cavecliff", "goat");
		this.setSize(0.9F, 1.3F);
		this.mobDrops.add(new WeightedRandomLootObject(CaveCliffItems.hornGoat.getDefaultStack(), 0, 2));
	}

	@Override
	protected void init() {
		this.entityData.define(16, (byte)0);
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 4;
		return this.entityData.getByte(1) % skinVariantCount;
	}

	@Override
	public boolean interact(EntityPlayer entityplayer) {
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (itemstack != null && itemstack.itemID == Item.bucket.id) {
			ItemBucketEmpty.useBucket(entityplayer, new ItemStack(Item.bucketMilk));
			return true;
		}
		return super.interact(entityplayer);
	}

	@Override
	public String getLivingSound() {
		return "mob.sheep";
	}

	@Override
	protected String getHurtSound() {
		return "mob.sheep";
	}

	@Override
	protected String getDeathSound() {
		return "mob.sheep";
	}

	public void playLivingSound() {
		String s = this.getLivingSound();
		if (s != null) {
			this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.getSoundVolume() * 1.5F));
		}
	}

	public void playHurtSound() {
		this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.getSoundVolume() * 1.5F));
	}

	public void playDeathSound() {
		this.world.playSoundAtEntity(null, this, this.getDeathSound(), this.getSoundVolume(), (this.getSoundVolume() * 1.5F));
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
