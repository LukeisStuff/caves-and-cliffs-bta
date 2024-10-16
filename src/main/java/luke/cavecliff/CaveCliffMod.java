package luke.cavecliff;

import luke.cavecliff.entity.EntityAxolotl;
import luke.cavecliff.entity.EntityGlowSquid;
import luke.cavecliff.entity.EntityGoat;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.EnumCreatureType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.server.entity.ServerSkinVariantList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "cavecliff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerSkinVariantList.registerSkinCount(EntityGoat.class, 4);
		ServerSkinVariantList.registerSkinCount(EntityGlowSquid.class, 4);
		ServerSkinVariantList.registerSkinCount(EntityAxolotl.class, 5);

		for (Biome b : Registries.BIOMES) {
			b.getSpawnableList(EnumCreatureType.waterCreature).add(new SpawnListEntry(EntityGlowSquid.class, 5));
			b.getSpawnableList(EnumCreatureType.waterCreature).add(new SpawnListEntry(EntityAxolotl.class, 25));
			b.getSpawnableList(EnumCreatureType.creature).add(new SpawnListEntry(EntityGoat.class, 102));
		}
		CaveCliffSounds.init();
		LOGGER.info("Caves and Cliffs initialized.");
	}

	@Override
	public void beforeGameStart() {
		new CaveCliffBlocks().initializeBlocks();
		new CaveCliffItems().initilizeItems();
		new CaveCliffEntities().initializeEntities();
	}

	@Override
	public void afterGameStart() {
		new CaveCliffBlocks().initializeBlockDetails();

		MobInfoRegistry.register(EntityGoat.class, "guidebook.section.mob.goat.name", "guidebook.section.mob.goat.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.hornGoat), 1.0f, 0, 2)});

		MobInfoRegistry.register(EntityGlowSquid.class, "guidebook.section.mob.squid.glow.name", "guidebook.section.mob.squid.glow.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.inkSacGlow, 1, 0), 1.0f, 1, 3)});

		MobInfoRegistry.register(EntityAxolotl.class, "guidebook.section.mob.axolotl.name", "guidebook.section.mob.axolotl.desc",
			8, 500, null);

	}

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {

	}
}
