package luke.cavecliff.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.FogManager;
import net.minecraft.client.render.camera.CameraUtil;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= FogManager.class,remap=false)
public class FogManagerMixin {

	@Unique
	public final Minecraft mc;

	@Unique
	public float fogRed;
	@Unique
	public float fogGreen;
	@Unique
	public float fogBlue;

	public FogManagerMixin(Minecraft mc) {
		this.mc = mc;
	}

	@Inject(method = "updateFogColor", at = @At(value = "TAIL", target = "Lnet/minecraft/client/render/FogManager;updateFogColor(F)V"), cancellable = true)
	public void updateFogColor(float partialTick, CallbackInfo ci) {
		World world = this.mc.theWorld;
		if (CameraUtil.isUnderLiquid(this.mc.activeCamera, world, Material.topSnow, partialTick)) {
			this.fogRed = 0.9f;
			this.fogGreen = 0.9f;
			this.fogBlue = 1.0f;
		}
		ci.cancel();
		GL11.glClearColor(this.fogRed, this.fogGreen, this.fogBlue, 0.0f);
	}
}
