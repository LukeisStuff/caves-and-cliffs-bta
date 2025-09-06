package luke.cavecliff.entity.goat;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelQuadruped;

public class ModelGoat extends ModelQuadruped {
	Cube horn1;
	Cube horn2;

	Cube ear1;
	Cube ear2;


	public ModelGoat() {
		super(0, 0.0F);
		this.head = new Cube(0, 0);
		this.head.addBox(-2.0F, -1.0F, -8.0F, 5, 7, 10);
		this.head.setRotationPoint(0.0F, 4.0F, -8.0F);

		this.horn1 = new Cube(0, 0);
		this.horn1.addBox(-1.99F, -6.0F, -1.0F, 2, 7, 2);
		this.horn1.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.horn2 = new Cube(0, 0);
		this.horn2.addBox(0.99F, -6.0F, -1.0F, 2, 7, 2);
		this.horn2.setRotationPoint(0.0F, 4.0F, -8.0F);

		// Left Ear
		this.ear1 = new Cube(0, 17);
		this.ear1.addBox(-5.0F, 0.0F, 0.5F, 3, 2, 1);
		this.ear1.setRotationPoint(0.0F, 4.0F, -8.0F);
		// Right Ear
		this.ear2 = new Cube(0, 17);
		this.ear2.addBox(3.0F, 0.0F, 0.5F, 3, 2, 1);
		this.ear2.setRotationPoint(0.0F, 4.0F, -8.0F);

		this.body = new Cube(23, 5);
		this.body.addBox(-4.0f, -10.0f, -13.0f, 9, 16, 11);
		this.body.setRotationPoint(0.0f, 5.0f, 2.0f);

		// Right Back Leg
		this.leg1 = new Cube(2, 23);
		this.leg1.addBox(0.0F, 0.0F, -3.0F, 3, 6, 3);
		this.leg1.setRotationPoint(-3.0F, 18.0f, 7.0F);

		// Left Back Leg
		this.leg2 = new Cube(2, 23);
		this.leg2.addBox(-2.0F, 0.0F, -3.0F, 3, 6, 3);
		this.leg2.setRotationPoint(3.0F, 18.0f, 7.0F);

		// Right Front Leg
		this.leg3 = new Cube(2, 23);
		this.leg3.addBox(0.0F, 0.0F, -2.0F, 3, 6, 3);
		this.leg3.setRotationPoint(-3.0F, 18.0f, -5.0F);

		// Left Front Leg
		this.leg4 = new Cube(2, 23);
		this.leg4.addBox(-2.0f, 0.0F, -2.0F, 3, 6, 3);
		this.leg4.setRotationPoint(3.0F, 18.0f, -5.0F);
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.render(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.horn1.render(scale);
		this.horn2.render(scale);
		this.ear1.render(scale);
		this.ear2.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.horn1.yRot = this.head.yRot;
		this.horn1.xRot = this.head.xRot;
		this.horn2.yRot = this.head.yRot;
		this.horn2.xRot = this.head.xRot;

		this.ear1.yRot = this.head.yRot;
		this.ear1.xRot = this.head.xRot;
		this.ear2.yRot = this.head.yRot;
		this.ear2.xRot = this.head.xRot;
	}
}
