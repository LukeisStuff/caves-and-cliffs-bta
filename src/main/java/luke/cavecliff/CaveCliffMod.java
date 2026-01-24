package luke.cavecliff;

import luke.cavecliff.block.CaveCliffBlocks;
import luke.cavecliff.entity.CaveCliffEntities;
import luke.cavecliff.item.CaveCliffItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.sound.SoundTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "cavecliff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Material copper;

    @Override
    public void onInitialize() {
        LOGGER.info("Caves and Cliffs initialized.");
    }

    @Override
    public void beforeGameStart() {
        copper = (new Material(MaterialColor.paintedOrange)).setConductivity(99999999).setAsMetal().notAlwaysDestroyable();

        CaveCliffConfig.init();
        CaveCliffBlocks.init();
        CaveCliffItems.init();
        CaveCliffEntities.init();

        SoundTypes.loadSoundsJson(MOD_ID);
    }

    @Override
    public void afterGameStart() {
        new CaveCliffBlocks().initializeBlockDetails();

    }

}
