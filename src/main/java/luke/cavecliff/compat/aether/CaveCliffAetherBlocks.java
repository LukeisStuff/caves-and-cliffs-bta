package luke.cavecliff.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.cavecliff.CaveCliffConfig.blockID;
import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffAetherBlocks {
    public static Block<?> BLOCK_GRAVITITE_RAW;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeBlocks();
        }
    }

    public static void initializeBlocks() {
        BlockBuilder metal = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.5f))
            .setHardness(5.0f)
            .setResistance(10.0f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BLOCK_GRAVITITE_RAW = metal
            .build("block.gravitite.raw", "block_gravitite_raw", blockID("BLOCK_GRAVITITE_RAW"), BlockLogicRawOreGravitite::new);
    }
}
