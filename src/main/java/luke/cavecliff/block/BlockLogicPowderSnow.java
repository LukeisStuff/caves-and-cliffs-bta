package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobSnowman;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.entity.vehicle.EntityMinecart;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockLogicPowderSnow extends BlockLogic {
	public int ticks;

	public BlockLogicPowderSnow(Block<?> block) {
		super(block, Material.topSnow);
	}


	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.fallDistance = 0.0F;
		entity.xd *= 0.6;
		entity.yd *= 0.6;
		entity.zd *= 0.6;
		if (entity instanceof MobSnowman) {
		} else if (entity instanceof Mob || entity instanceof EntityMinecart || entity instanceof EntityBoat) {
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

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			if (((Player)entity).inventory.armorInventory[0] != null && ((Player) entity).inventory.armorInventory[0].getItem().equals(Items.ARMOR_BOOTS_LEATHER)) {
				AABB.getTemporaryBB(0.0f, 0.0f , 0.0f , 1.0f, 1.0f, 1.0f);
			} else {
				AABB.getTemporaryBB(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
			}
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
        return null;
    }

	public boolean isCubeShaped() {
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
