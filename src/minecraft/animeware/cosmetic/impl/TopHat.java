package animeware.cosmetic.impl;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticChecker;
import animeware.cosmetic.Cosmetic;
import animeware.cosmetic.CosmeticModelBase;
import animeware.cosmetic.HatChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class TopHat extends Cosmetic {

	private final ModelTopHat modelTopHat;
	private static final ResourceLocation TEXTURE = new ResourceLocation("Animeware/cosmetic/hat.png");
	
	public TopHat(RenderPlayer renderPlayer) {
		super("TopHat", false, renderPlayer);
		modelTopHat = new ModelTopHat(renderPlayer);
	}
	
	@Override
	public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if(Booleans.TopHat && /*entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && */CosmeticChecker.ownsHat(entitylivingbaseIn)) {
			GlStateManager.pushMatrix();
			playerRenderer.bindTexture(TEXTURE);
			
			if(entitylivingbaseIn.isSneaking()) {
				GL11.glTranslated(0, 0.225D, 0);
			}
			
			float[] color = CosmeticChecker.getTopHatColor(entitylivingbaseIn);
			GL11.glColor3d(color[0], color[1], color[2]);
			modelTopHat.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, scale);
			GL11.glColor3f(1, 1, 1);
			GL11.glPopMatrix();
		}
		
	}
	
	private static class ModelTopHat extends CosmeticModelBase {

		private ModelRenderer rim;
		private ModelRenderer pointy;
		
		public ModelTopHat(RenderPlayer renderPlayer) {
			super(renderPlayer);
			rim = new ModelRenderer(playerModel, 0, 0);
			rim.addBox(-5.5f, -9f, -5.5f, 11, 2, 11);
			
			pointy = new ModelRenderer(playerModel, 0, 13);
			pointy.addBox(-3.5f, -17f, -3.5f, 7, 8, 7);
		}
		
		public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float headScale, float scale) {
			
			rim.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			rim.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			rim.rotationPointX = 0.0f;
			rim.rotationPointY = 0.0f;
			rim.render(scale);
			
			pointy.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			pointy.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			pointy.rotationPointX = 0.0f;
			pointy.rotationPointY = 0.0f;
			pointy.render(scale);
			
		}
		
		/*public boolean ownsCosmeticHat() {
			if(mc.getSession().getUsername().equalsIgnoreCase("hypnomacka")) return true;
			if(mc.getSession().getUsername().equalsIgnoreCase("Quaversal")) return true;
			
			else return false;
		}*/
	
		
	}

	public static boolean ownsCosmeticHat() {
		if(mc.getSession().getUsername().equalsIgnoreCase("hypnomacka")) return true;
		if(mc.getSession().getUsername().equalsIgnoreCase("Quaversal")) return true;
		
		else return false;
	}
}
