package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.monster.EntitySnowman;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.entity.vehicle.EntityMinecart;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockPowderSnow extends Block {
	public int ticks;
	public BlockPowderSnow(String key, int id) {
		super(key, id, Material.topSnow);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.fallDistance = 0.0F;
		entity.xd *= 0.6;
		entity.yd *= 0.6;
		entity.zd *= 0.6;
		if (entity instanceof EntitySnowman) {
		} else if (entity instanceof EntityLiving || entity instanceof EntityMinecart || entity instanceof EntityBoat) {
			++this.ticks;
			if (this.ticks >= 40) {
				entity.hurt(null, 1, DamageType.GENERIC);
				this.ticks = 0;
			}
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getSavedLightValue(LightLayer.Block, x, y, z) > 11) {
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	public boolean isSolidRender() {
		return false;
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
            case SILK_TOUCH:
                return new ItemStack[]{new ItemStack(this)};
            default:
				return null;
		}
	}

}
