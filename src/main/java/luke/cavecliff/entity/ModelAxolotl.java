package luke.cavecliff.entity;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

public class ModelAxolotl extends ModelBase {
	public Cube axolotlHead;
	public Cube axolotlBody;
	public Cube axolotlArm1;
	public Cube axolotlArm2;
	public Cube axolotlLeg1;
	public Cube axolotlLeg2;
	public Cube axolotlTail1;
	public Cube axolotlTail2;
	public Cube axolotlGills1;
	public Cube axolotlGills2;

	public ModelAxolotl() {
		super();
		this.axolotlHead = new Cube(0, 0);
		this.axolotlHead.addBox(-4.0f, -2.5f, -5.0f, 8, 5, 5, 0.0F);
		this.axolotlHead.setRotationPoint(0.0f, 21.5f, -5.0f);

		this.axolotlBody = new Cube(0, 10);
		this.axolotlBody.addBox(-4.0f, -2.0f, -5.0f, 8, 4, 10, 0.0F);
		this.axolotlBody.setRotationPoint(0.0F, 22.0f, 0.0F);

		// Left Arm
		this.axolotlArm1 = new Cube(-3, 16);
		this.axolotlArm1.addBox(0.0F, 0.0f, -2.0F, 5, 0, 3);
		this.axolotlArm1.setRotationPoint(4.0F, 22.0f, -3.0F);

		// Right Arm
		this.axolotlArm2 = new Cube(-3, 13);
		this.axolotlArm2.addBox(-5.0F, 0.0f, -2.0F, 5, 0, 3);
		this.axolotlArm2.setRotationPoint(-4.0F, 22.0f, -3.0F);

		// Left Leg
		this.axolotlLeg1 = new Cube(-3, 16);
		this.axolotlLeg1.addBox(0.0F, 0.0f, -2.0F, 5, 0, 3);
		this.axolotlLeg1.setRotationPoint(4.0F, 22.0f, 3.0F);

		// Right Leg
		this.axolotlLeg2 = new Cube(-3, 13);
		this.axolotlLeg2.addBox(-5.0F, 0.0f, -2.0F, 5, 0, 3);
		this.axolotlLeg2.setRotationPoint(-4.0F, 22.0f, 3.0F);

		this.axolotlTail1 = new Cube(2, 17);
		this.axolotlTail1.addBox(0.0f, -3.0f, -5.0F, 0, 5, 9);
		this.axolotlTail1.setRotationPoint(0.0F, 22.0f, 0.0F);

		this.axolotlTail2 = new Cube(16, 12);
		this.axolotlTail2.addBox(0.0f, -3.0f, 4.0F, 0, 5, 13);
		this.axolotlTail2.setRotationPoint(0.0F, 22.0f, 0.0F);

		this.axolotlGills1 = new Cube(27, 0);
		this.axolotlGills1.addBox(-4.0f, -5.5f, -1.0F, 8, 3, 0);
		this.axolotlGills1.setRotationPoint(0.0f, 21.5f, -5.0f);

		this.axolotlGills2 = new Cube(32, 3);
		this.axolotlGills2.addBox(-7.0f, -4.5f, -1.0F, 14, 7, 0);
		this.axolotlGills2.setRotationPoint(0.0f, 21.5f, -5.0f);

	}

	@Override
	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.axolotlHead.render(scale);
		this.axolotlGills1.render(scale);
		this.axolotlGills2.render(scale);
		this.axolotlBody.render(scale);
		this.axolotlArm1.render(scale);
		this.axolotlArm2.render(scale);
		this.axolotlLeg1.render(scale);
		this.axolotlLeg2.render(scale);
		this.axolotlTail1.render(scale);
		this.axolotlTail2.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.axolotlHead.rotateAngleY = headYaw / 57.29578f;
		this.axolotlHead.rotateAngleX = headPitch / 57.29578f;

		this.axolotlGills1.rotateAngleY = this.axolotlHead.rotateAngleY;
		this.axolotlGills1.rotateAngleX = this.axolotlHead.rotateAngleX;
		this.axolotlGills2.rotateAngleY = this.axolotlHead.rotateAngleY;
		this.axolotlGills2.rotateAngleX = this.axolotlHead.rotateAngleX;

		this.axolotlTail1.rotateAngleY = this.axolotlBody.rotateAngleY;
		this.axolotlTail1.rotateAngleX = this.axolotlBody.rotateAngleX;
		this.axolotlTail2.rotateAngleY = this.axolotlBody.rotateAngleY;
		this.axolotlTail2.rotateAngleX = this.axolotlBody.rotateAngleX;


		this.axolotlLeg2.rotateAngleZ = -0.75f * 0.74f;
		this.axolotlLeg1.rotateAngleZ = 0.75f * 0.74f;

		this.axolotlArm2.rotateAngleZ = -0.75f * 0.74f;
		this.axolotlArm1.rotateAngleZ = 0.75f * 0.74f;

		this.axolotlLeg2.rotateAngleY = 0.375f - 0.0f;
		this.axolotlLeg1.rotateAngleY = -0.375f + 0.0f;

		this.axolotlArm2.rotateAngleY = -0.375f - 0.0f;
		this.axolotlArm1.rotateAngleY = 0.375f + 0.0f;

		float pair2Y = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 3.141593f) * 0.4f) * limbYaw;
		float pair3Y = -(MathHelper.cos(limbSwing * 0.6662f * 2.0f + 1.570796f) * 0.4f) * limbYaw;
		float pair2Z = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 3.141593f) * 0.4f) * limbYaw;
		float pair3Z = Math.abs(MathHelper.sin(limbSwing * 0.6662f + 1.570796f) * 0.4f) * limbYaw;
		this.axolotlLeg2.rotateAngleY += pair2Y;
        this.axolotlLeg1.rotateAngleY -= pair2Y;

		this.axolotlArm2.rotateAngleY += pair3Y;
        this.axolotlArm1.rotateAngleY -= pair3Y;

		this.axolotlLeg2.rotateAngleZ += pair2Z;
        this.axolotlLeg1.rotateAngleZ -= pair2Z;

		this.axolotlArm2.rotateAngleZ += pair3Z;
        this.axolotlArm1.rotateAngleZ -= pair3Z;
	}
}
