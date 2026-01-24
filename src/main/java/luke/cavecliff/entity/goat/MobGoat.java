package luke.cavecliff.entity.goat;

import com.mojang.nbt.tags.CompoundTag;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.animal.MobAnimal;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemBucketEmpty;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

public class MobGoat extends MobAnimal {
    public MobGoat(World world) {
        super(world);
        this.textureIdentifier = NamespaceID.getPermanent("cavecliff", "goat_mountain");
        this.setSize(0.8F, 1.2F);
        this.mobDrops.add(new WeightedRandomLootObject(CaveCliffItems.HORN_GOAT.getDefaultStack(), 0, 2));
    }

    @Override
    public boolean interact(@NotNull Player player) {
        ItemStack itemstack = player.inventory.getCurrentItem();
        if (itemstack != null && itemstack.itemID == Items.BUCKET.id) {
            ItemBucketEmpty.useBucket(player, new ItemStack(Items.BUCKET_MILK));
            return true;
        } else {
            return super.interact(player);
        }
    }

    @Override
    public boolean isFavouriteItem(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem().hasTag(ItemTags.COWS_FAVOURITE_ITEM);
    }

    @Override
    public String getLivingSound() {
        if (this.random.nextInt(10) == 0) {
            return "cavecliff:mob.goat.scream";
        }
        return "cavecliff:mob.goat.idle";
    }

    @Override
    public String getHurtSound() {
        return "cavecliff:mob.goat.idle";
    }

    @Override
    public String getDeathSound() {
        return "cavecliff:mob.goat.death";
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

}
