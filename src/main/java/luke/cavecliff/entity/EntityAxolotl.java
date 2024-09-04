package luke.cavecliff.entity;

import com.mojang.nbt.CompoundTag;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.entity.animal.EntityWaterAnimal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pathfinder.Path;

import java.util.ArrayList;
import java.util.List;

public class EntityAxolotl extends EntityWaterAnimal {
	public boolean looksWithInterest = false;
	public float field_25048_b;
	public boolean field_25052_g;
	public EntityAxolotl(World world) {
		super(world);
		this.textureIdentifier = new NamespaceID("cavecliff", "axolotl");
		this.setSize(0.5f, 0.5f);
		this.moveSpeed = 1.1f;
		this.scoreValue = 500;
	}

	@Override
	public void init() {
		super.init();
		this.entityData.define(15, ItemStack.NO_ITEM);
		this.entityData.define(16, (byte)0);
		this.entityData.define(17, "");
		this.entityData.define(19, "");
		if (!this.isAxolotlTamed() && this.random.nextInt(100) == 0) {
			this.setAxolotlHeldItem(new ItemStack(CaveCliffItems.recordOtherside, 1));
		}
	}

	@Override
	public boolean sendDeathMessage(Entity entityKilledBy) {
		return super.sendDeathMessage(entityKilledBy) || this.isAxolotlTamed();
	}

	@Override
	public boolean collidesWith(Entity entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			return !player.username.equalsIgnoreCase(this.getAxolotlOwner()) || this.isAxolotlSitting();
		}
		return true;
	}

	@Override
	public int getSkinVariant() {
		int skinVariantCount = 5;
		return this.entityData.getByte(1) % skinVariantCount;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Sitting", this.isAxolotlSitting());
		if (this.getAxolotlHeldItem() != null) {
			CompoundTag heldItemNBT = new CompoundTag();
			this.getAxolotlHeldItem().writeToNBT(heldItemNBT);
			tag.putCompound("HeldItem", heldItemNBT);
		}
		if (this.getAxolotlOwner() == null) {
			tag.putString("Owner", "");
		} else {
			tag.putString("Owner", this.getAxolotlOwner());
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		String s;
		ItemStack stack;
		super.readAdditionalSaveData(tag);
		this.setAxolotlSitting(tag.getBoolean("Sitting"));
		CompoundTag heldItemStack = tag.getCompound("HeldItem");
		if (heldItemStack != null && (stack = ItemStack.readItemStackFromNbt(heldItemStack)) != null) {
			this.setAxolotlHeldItem(stack);
		}
		if (!(s = tag.getString("Owner")).isEmpty()) {
			this.setAxolotlOwner(s);
			this.setAxolotlTamed(true);
		}
	}

	@Override
	public boolean canDespawn() {
		return !this.isAxolotlTamed() && super.canDespawn();
	}

	@Override
	public String getLivingSound() {
		if (this.random.nextInt(3) == 0) {
			if (this.isAxolotlTamed() && this.getHealth() < this.getMaxHealth() / 2) {
				return "cavecliff.axolotlhurt";
			}
			return "cavecliff.axolotlidle";
		}
		return "cavecliff.axolotlidle";
	}

	@Override
	public String getHurtSound() {
		return "cavecliff.axolotlhurt";
	}

	@Override
	public String getDeathSound() {
		return "cavecliff.axolotldeath";
	}

	@Override
	public float getSoundVolume() {
		return 0.8f;
	}

	@Override
	public void dropFewItems() {
		if (this.getHeldItem() != null && this.getHeldItem().stackSize > 0) {
			this.spawnAtLocation(this.getHeldItem(), 0.0f);
			this.setAxolotlHeldItem(null);
		}
		super.dropFewItems();
	}

	@Override
	public void updatePlayerActionState() {
		List<Entity> nearbySheep;
		super.updatePlayerActionState();
		if (this.getTarget() instanceof EntityItem && (this.getTarget().isInWater() || this.getTarget().isInLava() || this.getTarget().isInWall() || !this.getTarget().onGround || this.getTarget().isRemoved())) {
			this.setTarget(null);
		}
		if (!this.hasAttacked && !this.hasPath() && this.isAxolotlTamed() && this.vehicle == null) {
			EntityPlayer entityplayer = this.world.getPlayerEntityByName(this.getAxolotlOwner());
			if (entityplayer != null) {
				float f = entityplayer.distanceTo(this);
				if (f > 5.0f) {
					this.getPathOrWalkableBlock(entityplayer, f);
				}
			} else if (!this.isInWater()) {
				this.setAxolotlSitting(true);
			}
		} else if (!(this.entityToAttack != null || this.hasPath() || this.isAxolotlTamed() || this.world.rand.nextInt(100) != 0 || (nearbySheep = this.world.getEntitiesWithinAABB(EntitySheep.class, AABB.getBoundingBoxFromPool(this.x, this.y, this.z, this.x + 1.0, this.y + 1.0, this.z + 1.0).expand(16.0, 4.0, 16.0))).isEmpty())) {
			this.setTarget(nearbySheep.get(this.world.rand.nextInt(nearbySheep.size())));
		}
		ItemStack heldItemSlot = this.getAxolotlHeldItem();
		if (heldItemSlot == null || heldItemSlot.itemID <= 0) {
			ArrayList<EntityItem> triedItems = new ArrayList<EntityItem>();
			List<Entity> nearbyItems = this.world.getEntitiesWithinAABB(EntityItem.class, AABB.getBoundingBoxFromPool(this.x, this.y, this.z, this.x + 1.0, this.y + 1.0, this.z + 1.0).expand(16.0, 4.0, 16.0));
			if (!nearbyItems.isEmpty()) {
				while (triedItems.size() != nearbyItems.size()) {
					EntityItem item = (EntityItem)nearbyItems.get(this.world.rand.nextInt(nearbyItems.size()));
					if (triedItems.contains(item)) continue;
					if (item.isInWater() || item.isInLava() || item.isInWall() || !item.onGround || item.isRemoved()) {
						triedItems.add(item);
						continue;
					}
					this.setTarget(item);
					break;
				}
			}
		}
		if (this.isInWater()) {
			this.setAxolotlSitting(false);
		}
	}

	@Override
	public void onLivingUpdate() {
		Entity entity;
		super.onLivingUpdate();
		this.looksWithInterest = false;
		if (this.hasCurrentTarget() && !this.hasPath() && (entity = this.getCurrentTarget()) instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer)entity;
			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null) {
				if (!this.isAxolotlTamed() && itemstack.itemID == Item.bone.id) {
					this.looksWithInterest = true;
				} else if (this.isAxolotlTamed() && Item.itemsList[itemstack.itemID] instanceof ItemFood) {
					this.looksWithInterest = ((ItemFood)Item.itemsList[itemstack.itemID]).getIsWolfsFavoriteMeat();
				}
			}
		}
		if (!this.isMultiplayerEntity && !this.field_25052_g && !this.hasPath() && this.onGround) {
			this.field_25052_g = true;
			this.world.sendTrackedEntityStatusUpdatePacket(this, (byte)8);
		}
	}

	@Override
	public ItemStack getHeldItem() {
		return this.getAxolotlHeldItem();
	}

	@Override
	public void tick() {
		super.tick();
		List<Entity> entitiesNearAxolotl = this.world.getEntitiesWithinAABBExcludingEntity(this, this.bb);
		if (entitiesNearAxolotl != null && !entitiesNearAxolotl.isEmpty() && this.isAlive()) {
			for (Entity entity : entitiesNearAxolotl) {
				if (!(entity instanceof EntityItem) || this.getAxolotlHeldItem() != null && this.getAxolotlHeldItem().getItem() != null) continue;
				EntityItem entityItem = (EntityItem)entity;
				if (entityItem.item == null || entityItem.item.stackSize <= 0) continue;
				this.setAxolotlHeldItem(entityItem.item.copy());
				entityItem.item.stackSize = 0;
				entity.outOfWorld();
				break;
			}
		}
		if (this.looksWithInterest) {
			this.field_25048_b += (1.0f - this.field_25048_b) * 0.4f;
		} else {
			this.field_25048_b += (0.0f - this.field_25048_b) * 0.4f;
		}
		if (this.looksWithInterest) {
			this.numTicksToChaseTarget = 10;
		}
		if (this.isInWaterOrRain()) {
			this.field_25052_g = false;
		}
	}

	@Override
	public int func_25026_x() {
		if (this.isAxolotlSitting()) {
			return 20;
		}
		return super.func_25026_x();
	}

	public void getPathOrWalkableBlock(Entity entity, float f) {
		Path pathentity = this.world.getPathToEntity(this, entity, 16.0f);
		if (pathentity == null && f > 12.0f) {
			int i = MathHelper.floor_double(entity.x) - 2;
			int j = MathHelper.floor_double(entity.z) - 2;
			int k = MathHelper.floor_double(entity.bb.minY);
			for (int l = 0; l <= 4; ++l) {
				for (int i1 = 0; i1 <= 4; ++i1) {
					if (l >= 1 && i1 >= 1 && l <= 3 && i1 <= 3 || !this.world.isBlockNormalCube(i + l, k - 1, j + i1) || this.world.isBlockNormalCube(i + l, k, j + i1) || this.world.isBlockNormalCube(i + l, k + 1, j + i1)) continue;
					this.moveTo((float)(i + l) + 0.5f, k, (float)(j + i1) + 0.5f, this.yRot, this.xRot);
					return;
				}
			}
		} else {
			this.setPathToEntity(pathentity);
		}
	}


	@Override
	public boolean hurt(Entity attacker, int i, DamageType type) {
		this.setAxolotlSitting(false);
		if (attacker != null && !(attacker instanceof EntityPlayer) && !(attacker instanceof EntityArrow)) {
			i = (i + 1) / 2;
		}
		if (super.hurt(attacker, i, type)) {
			if (!this.isAxolotlTamed()) {
				if (attacker instanceof EntityPlayer) {
					this.entityToAttack = attacker;
				}
				if (attacker instanceof EntityArrow && ((EntityArrow)attacker).owner != null) {
					attacker = ((EntityArrow)attacker).owner;
				}
				if (attacker instanceof EntityLiving) {
					List<Entity> list = this.world.getEntitiesWithinAABB(EntityAxolotl.class, AABB.getBoundingBoxFromPool(this.x, this.y, this.z, this.x + 1.0, this.y + 1.0, this.z + 1.0).expand(16.0, 4.0, 16.0));
					for (Entity entity1 : list) {
						EntityAxolotl entityaxolotl = (EntityAxolotl)entity1;
						if (entityaxolotl.isAxolotlTamed() || this.entityToAttack != null) continue;
						this.entityToAttack = attacker;
					}
				}
			} else if (attacker != this && attacker != null) {
				if (this.isAxolotlTamed() && attacker instanceof EntityPlayer && ((EntityPlayer)attacker).username.equalsIgnoreCase(this.getAxolotlOwner())) {
					return true;
				}
				this.entityToAttack = attacker;
			}
			return true;
		}
		return false;
	}

	@Override
	public void attackEntity(Entity entity, float distance) {
		if (entity instanceof EntityItem) {
			return;
		}
		if (distance > 2.0f && distance < 6.0f && this.random.nextInt(10) == 0) {
			if (this.onGround) {
				double d = entity.x - this.x;
				double d1 = entity.z - this.z;
				float f1 = MathHelper.sqrt_double(d * d + d1 * d1);
				this.xd = d / (double)f1 * 0.5 * (double)0.8f + this.xd * (double)0.2f;
				this.zd = d1 / (double)f1 * 0.5 * (double)0.8f + this.zd * (double)0.2f;
				this.yd = 0.4f;
			}
		} else if ((double)distance < 1.5 && entity.bb.maxY > this.bb.minY && entity.bb.minY < this.bb.maxY) {
			this.attackTime = 20;
			int byte0 = 2;
			if (this.isAxolotlTamed()) {
				byte0 = 4;
			}
			entity.hurt(this, byte0, DamageType.COMBAT);
		}
	}

	@Override
	public boolean interact(EntityPlayer entityplayer) {
		if (super.interact(entityplayer)) {
			return true;
		}
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (!this.isAxolotlTamed()) {
			if (itemstack != null && itemstack.itemID == Item.foodFishRaw.id) {
				itemstack.consumeItem(entityplayer);
				if (itemstack.stackSize <= 0) {
					entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
				}
				if (!this.world.isClientSide) {
					if (this.random.nextInt(3) == 0) {
						this.setAxolotlTamed(true);
						this.setPathToEntity(null);
						this.setAxolotlSitting(true);
						this.setHealthRaw(this.getMaxHealth());
						this.setAxolotlOwner(entityplayer.username);
						this.showHeartsOrSmokeFX(true);
						this.world.sendTrackedEntityStatusUpdatePacket(this, (byte)7);
					} else {
						this.showHeartsOrSmokeFX(false);
						this.world.sendTrackedEntityStatusUpdatePacket(this, (byte)6);
					}
				}
				return true;
			}
		} else {
			if (itemstack != null && Item.itemsList[itemstack.itemID] instanceof ItemFood && ((ItemFood)Item.itemsList[itemstack.itemID]).getIsWolfsFavoriteMeat() && this.getHealth() < this.getMaxHealth()) {
				if (entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
					if (itemstack.stackSize <= 0) {
						entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
					}
				}
				this.heal(((ItemFood)Item.foodPorkchopRaw).getHealAmount());
				return true;
			}
			if (entityplayer.username.equalsIgnoreCase(this.getAxolotlOwner())) {
				if (!this.world.isClientSide) {
					ItemStack heldItemSlot = this.getAxolotlHeldItem();
					if (this.isAxolotlSitting() && heldItemSlot != null && heldItemSlot.getItem() != null && heldItemSlot.itemID > 0 && !entityplayer.isSneaking()) {
						entityplayer.inventory.insertItem(heldItemSlot, true);
						if (heldItemSlot.stackSize <= 0) {
							this.setAxolotlHeldItem(null);
						}
					} else {
						this.setAxolotlSitting(!this.isAxolotlSitting());
						this.isJumping = false;
						this.setPathToEntity(null);
					}
				}
				return true;
			}
		}
		return false;
	}

	void showHeartsOrSmokeFX(boolean flag) {
		String s = "heart";
		if (!flag) {
			s = "smoke";
		}
		for (int i = 0; i < 7; ++i) {
			double motionX = this.random.nextGaussian() * 0.02;
			double motionY = this.random.nextGaussian() * 0.02;
			double motionZ = this.random.nextGaussian() * 0.02;
			this.world.spawnParticle(s, this.x + (double)(this.random.nextFloat() * this.bbWidth * 2.0f) - (double)this.bbWidth, this.y + 0.5 + (double)(this.random.nextFloat() * this.bbHeight), this.z + (double)(this.random.nextFloat() * this.bbWidth * 2.0f) - (double)this.bbWidth, motionX, motionY, motionZ, 0);
		}
	}

	@Override
	public int getMaxHealth() {
		if (this.isAxolotlTamed()) {
			return 20;
		}
		return 8;
	}

	@Override
	public void handleEntityEvent(byte byte0, float attackedAtYaw) {
		if (byte0 == 7) {
			this.showHeartsOrSmokeFX(true);
		} else if (byte0 == 6) {
			this.showHeartsOrSmokeFX(false);
		} else if (byte0 == 8) {
			this.field_25052_g = true;
		} else {
			super.handleEntityEvent(byte0, attackedAtYaw);
		}
	}

	public String getAxolotlOwner() {
		return this.entityData.getString(17);
	}

	public void setAxolotlOwner(String s) {
		this.entityData.set(17, s);
	}

	public boolean isAxolotlSitting() {
		return (this.entityData.getByte(16) & 1) != 0;
	}

	public void setAxolotlSitting(boolean flag) {
		byte byte0 = this.entityData.getByte(16);
		if (flag) {
			this.entityData.set(16, (byte)(byte0 | 1));
		} else {
			this.entityData.set(16, (byte)(byte0 & 0xFFFFFFFE));
		}
	}

	public ItemStack getAxolotlHeldItem() {
		ItemStack stack = this.entityData.getItemStack(15);
		if (stack == ItemStack.NO_ITEM) {
			stack = null;
		}
		return stack;
	}

	public void setAxolotlHeldItem(ItemStack itemStack) {
		if (itemStack == null) {
			itemStack = ItemStack.NO_ITEM;
		}
		this.entityData.set(15, itemStack);
	}

	public boolean isAxolotlTamed() {
		return (this.entityData.getByte(16) & 4) != 0;
	}

	public void setAxolotlTamed(boolean flag) {
		byte byte0 = this.entityData.getByte(16);
		if (flag) {
			this.entityData.set(16, (byte)(byte0 | 4));
		} else {
			this.entityData.set(16, (byte)(byte0 & 0xFFFFFFFB));
		}
	}


}
