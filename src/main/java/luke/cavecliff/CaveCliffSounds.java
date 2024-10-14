package luke.cavecliff;

import turniplabs.halplibe.helper.SoundHelper;

public class CaveCliffSounds {

	public static void init() {
		SoundHelper.addStreaming(CaveCliffMod.MOD_ID, "otherside.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goathorn1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goathorn2.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goathorn3.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goathorn4.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatidle1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatidle2.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatidle3.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatscream1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatscream2.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatdeath1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatdeath2.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "goatdeath3.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotlidle1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotlidle2.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotlhurt1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotlhurt2.ogg");

		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotldeath1.ogg");
		SoundHelper.addSound(CaveCliffMod.MOD_ID, "axolotldeath2.ogg");
	}
}
