package animeware.cosmetic.impl;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticChecker;
import animeware.cosmetic.Cosmetic;
import animeware.cosmetic.CosmeticController;
import animeware.cosmetic.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class Halo extends Cosmetic {
	private final HaloRenderer haloModel;

	public Halo(RenderPlayer renderPlayer) {
		super("Halo", false, renderPlayer);
		this.haloModel = new HaloRenderer(renderPlayer);
	}
	@Override
	public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	if(Booleans.Halo && CosmeticChecker.ownsHalo(player) && player == Minecraft.getMinecraft().thePlayer && !player.isInvisible()) {
		GL11.glPushMatrix();
		if(player.isSneaking()) {
			GlStateManager.translate(0, 0.225, 0);
		}

		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/cosmetic/halo.png"));
		float[] color = CosmeticChecker.getHaloColor(player);
		GL11.glColor3d(color[0], color[1], color[2]);
		this.haloModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GL11.glColor3f(1, 1, 1);
		GL11.glPopMatrix();
		}
	}
	
	public class HaloRenderer extends CosmeticModelBase {
		ModelRenderer head;
	    ModelRenderer body;
	    ModelRenderer rightarm;
	    ModelRenderer leftarm;
	    ModelRenderer rightleg;
	    ModelRenderer leftleg;
	    ModelRenderer Halo1;
	    ModelRenderer Halo2;
	    ModelRenderer Halo3;
	    ModelRenderer Halo4;
		
		public HaloRenderer(RenderPlayer player) {
			super(player);
			textureWidth = 64;
		    textureHeight = 32;
		    
		      Halo1 = new ModelRenderer(this, 0, 0);
		      Halo1.addBox(0F, 0F, 0F, 10, 1, 1);
		      Halo1.setRotationPoint(-5F, -11F, 4F);
		      Halo1.setTextureSize(64, 32);
		      Halo1.mirror = true;
		      Halo2 = new ModelRenderer(this, 0, 0);
		      Halo2.addBox(0F, 0F, 0F, 10, 1, 1);
		      Halo2.setRotationPoint(-5F, -11F, -5F);
		      Halo2.setTextureSize(64, 32);
		      Halo2.mirror = true;
		      Halo3 = new ModelRenderer(this, 0, 0);
		      Halo3.addBox(0F, 0F, 0F, 1, 1, 8);
		      Halo3.setRotationPoint(4F, -11F, -4F);
		      Halo3.setTextureSize(64, 32);
		      Halo3.mirror = true;
		      Halo4 = new ModelRenderer(this, 0, 0);
		      Halo4.addBox(0F, 0F, 0F, 1, 1, 8);
		      Halo4.setRotationPoint(-5F, -11F, -4F);
		      Halo4.setTextureSize(64, 32);
		      Halo4.mirror = true;
		}
		
		public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float HeadYaw, float headPitch, float scale) {
			GlStateManager.pushMatrix();
			float f1 = + ageInTicks / 100F;
			float f6 = f1 * 3.1415927F* 1.0F;
			GlStateManager.translate(0, (-(float)(Math.sin(f6 + 2.0F) + 0.5D) * 0.08F), 0);
			GlStateManager.scale(0.9, 0.9, 0.9);
			this.Halo1.render(scale);
			this.Halo2.render(scale);
			this.Halo3.render(scale);
			this.Halo4.render(scale);
			GlStateManager.popMatrix();
		}
	}
}
    