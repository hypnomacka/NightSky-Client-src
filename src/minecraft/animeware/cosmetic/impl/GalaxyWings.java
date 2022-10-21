package animeware.cosmetic.impl;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class GalaxyWings extends ModelBase implements LayerRenderer<AbstractClientPlayer> {
	

	private final RenderPlayer playerRenderer;

	private Minecraft mc;

	private ResourceLocation location;

	private ModelRenderer wing;

	private ModelRenderer wingTip;

	private boolean playerUsesFullHeight;

	public GalaxyWings(RenderPlayer playerRendererIn) {

		this.playerRenderer = playerRendererIn;
		this.mc = Minecraft.getMinecraft();
		this.location = new ResourceLocation("Animeware/cosmetic/gwings1.png");
		setTextureOffset("wing.bone", 0, 0);
		setTextureOffset("wing.skin", -10, 8);
		setTextureOffset("wingtip.bone", 0, 5);
		setTextureOffset("wingtip.skin", -10, 18);
		this.wing = new ModelRenderer(this, "wing");
		this.wing.setTextureSize(30, 30);
		this.wing.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.wing.addBox("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
		this.wing.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
		this.wingTip = new ModelRenderer(this, "wingtip");
		this.wingTip.setTextureSize(30, 30);
		this.wingTip.setRotationPoint(-10.0F, 0.0F, 0.0F);
		this.wingTip.addBox("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
		this.wingTip.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
		this.wing.addChild(this.wingTip);
	}

	private float interpolate(float yaw1, float yaw2, float percent) {
		float f = (yaw1 + (yaw2 - yaw1) * percent) % 360.0F;
		if (f < 0.0F)
			f += 360.0F;
		return f;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_,
			float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scalee) {

		if (entitylivingbaseIn == Minecraft.getMinecraft().thePlayer && !entitylivingbaseIn.isInvisible() && Booleans.GalaxyWings) {
			double rotate = interpolate(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTicks);
			GL11.glPushMatrix();
			GL11.glScaled(-0.6, -0.6, 0.6);
			GL11.glTranslated(0.0D, -1.45, 0.1D);
			GL11.glTranslated(0.0D, 1.3D, 0.2D);
			if (entitylivingbaseIn.isSneaking()) {
				GlStateManager.translate(0.0F, -0.142F, -0.0178F);
			}
			GL11.glRotated(130, 1, 0, 0);
			GL11.glRotated(180, 0, 1, 0);

			GL11.glColor3f(1, 1, 1);
			this.mc.getTextureManager().bindTexture(this.location);
			for (int j = 0; j < 2; j++) {
				GL11.glEnable(2884);
				float f11 = (float) (System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F;
				this.wing.rotateAngleX = (float) Math.toRadians(-80.0D) - (float) Math.cos(f11) * 0.2F;
				this.wing.rotateAngleY = (float) Math.toRadians(20.0D) + (float) Math.sin(f11) * 0.4F;
				this.wing.rotateAngleZ = (float) Math.toRadians(20.0D);
				this.wingTip.rotateAngleZ = -((float) (Math.sin((f11 + 2.0F)) + 0.5D)) * 0.95F;
				this.wing.render(0.0615F);
				GL11.glScalef(-1.0F, 1.0F, 1.0F);
				if (j == 0)
					GL11.glCullFace(1028);
			}
			GL11.glCullFace(1029);
			GL11.glDisable(2884);
			GL11.glColor3f(255.0F, 255.0F, 255.0F);
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}