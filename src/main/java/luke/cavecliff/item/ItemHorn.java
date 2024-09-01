package luke.cavecliff.item;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemHorn extends Item {

	public ItemHorn(String name, int id) {
		super(name, id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
	}

	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		if (itemstack.getMetadata() > 0) {
			itemstack.damageItem(-1, entity);
		}
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		this.useItemRightClick(world, entityplayer);
        return itemstack;
    }

	public void useItemRightClick(World world, EntityPlayer entityplayer) {
		if (entityplayer.getHeldItem().getMetadata() <= 0) {
			world.playSoundAtEntity(entityplayer, entityplayer, "cavecliff.goathorn1", 1.0F, 1.0F);
			entityplayer.getHeldItem().damageItem(384, entityplayer);
		}
	}

}
