package luke.cavecliff.item;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Objects;

public class ItemHorn extends Item {


	public ItemHorn(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		this.maxStackSize = 1;
		this.setMaxDamage(256);
	}

	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		if (itemstack.getMetadata() > 0) {
			itemstack.damageItem(-1, entity);
		}
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player Player) {
		if (Objects.requireNonNull(Player.getHeldItem()).getMetadata() <= 0) {
			world.playSoundAtEntity(Player, Player, "cavecliff.goathorn", 1.0F, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
			Player.swingItem();
			Player.getHeldItem().damageItem(256, Player);
		}
		return itemstack;
	}

}
