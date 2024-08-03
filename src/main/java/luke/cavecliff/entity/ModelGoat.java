package luke.cavecliff.entity;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelQuadruped;

public class ModelGoat extends ModelQuadruped {
	Cube horn1;
	Cube horn2;

	public ModelGoat() {
		super(12, 0.0F);
		this.head = new Cube(0, 0);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.horn1 = new Cube(22, 0);
		this.horn1.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.horn1.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.horn2 = new Cube(22, 0);
		this.horn2.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.horn2.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.body = new Cube(18, 4);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
		this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
		--this.leg1.rotationPointX;
		++this.leg2.rotationPointX;
		Cube var10000 = this.leg1;
		var10000.rotationPointZ += 0.0F;
		var10000 = this.leg2;
		var10000.rotationPointZ += 0.0F;
		--this.leg3.rotationPointX;
		++this.leg4.rotationPointX;
		--this.leg3.rotationPointZ;
		--this.leg4.rotationPointZ;
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.render(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.horn1.render(scale);
		this.horn2.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.horn1.rotateAngleY = this.head.rotateAngleY;
		this.horn1.rotateAngleX = this.head.rotateAngleX;
		this.horn2.rotateAngleY = this.head.rotateAngleY;
		this.horn2.rotateAngleX = this.head.rotateAngleX;
	}
}
