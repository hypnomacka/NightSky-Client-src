package animeware.cosmetic.impl;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.Cosmetic;
import animeware.cosmetic.CosmeticChecker;
import animeware.util.cosmetic.AnimUtil;
import animeware.util.render.AnimatedResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class Cape extends Cosmetic
{
	public AnimatedResourceLocation gif;
	
	public boolean nocape;
	
	LayerCape lCape;
	
    private final RenderPlayer playerRenderer;

    public Cape(RenderPlayer renderPlayer) {
    	super("Cape", true, renderPlayer);
    	this.playerRenderer = renderPlayer;
    }
    
    
    public boolean shouldCombineTextures()
    {
        return false;
    } 
    
    	  
    public static void update() {
    	//timer = timer + mc.thePlayer.ticksExisted;
    	/*if(NightSky.timer == 50) {
    		NightSky.timer = 0;
    	}
    	int maxFrames = 2;
    	if (NightSky.timer == 49)
    		//ticks = 1;
    		NightSky.ticks++;
            System.out.println(NightSky.ticks);
            
    	if (NightSky.ticks > maxFrames) {
    		NightSky.ticks = 1;
        }*/
    }
    
	@Override
	public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		gif = new AnimatedResourceLocation("Animeware/cosmetic/capes/anim/lightning", 10, 5);
		if (entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE)/* && CapeChecker.ownsZeroTwoCape(entitylivingbaseIn)*/)
        {
			
			//gif = new AnimatedResourceLocation("Animeware/cosmetic/capes/anim/lightning", 10, 5);
        	//if(CosmeticController.shouldZeroTwoCape(entitylivingbaseIn) && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            //if (Animeware.QuickCape && ServerShitCapes.isWearingCape1(((AbstractClientPlayer) entitylivingbaseIn).getGameProfile().getName())) {
            try {
            if(entitylivingbaseIn == Minecraft.getMinecraft().thePlayer && !entitylivingbaseIn.isInvisible()) {
            if (Booleans.QuickCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/quick.png"));
              } else if (Booleans.PlanetsCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/planetscape.png"));
              } else if (Booleans.QuavCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/quav_cape.png"));
              } else if (Booleans.ReptyllCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/reptyll.png"));
              } else if (Booleans.SwordCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/swordcape.png"));
              } else if (Booleans.EmeraldCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/emeraldcape.png"));
              } else if (Booleans.LCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/lcape.png"));
              } else if (Booleans.NitroCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/nitro.png"));
              } else if (Booleans.DarkCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/darkcape.png"));
              } else if (Booleans.Cape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/cape.png"));
              } else if (Booleans.YTCape && CosmeticChecker.ownsYtCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/yt.png"));
              } else if (Booleans.DevCape && CosmeticChecker.ownsDevCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/devcape.png"));
              } else if (Booleans.OwnerCape && CosmeticChecker.ownsOwnerCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/ownercape.png"));
              } else if (Booleans.GradientBlack && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/gradientblack.png"));
              } else if (Booleans.GradientBlue && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/gradientblue.png"));
              } else if (Booleans.GradientGreen && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/gradientgreen.png"));
              } else if (Booleans.GradientPurple && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/gradientpurple.png"));
              } else if (Booleans.GradientRed && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/gradientred.png"));
              } else if (Booleans.tanjirocape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/tanjirocape.png"));
              } else if (Booleans.kocho2cape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/kocho2cape.png"));
              } else if (Booleans.kocho3cape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/kocho3cape.png"));
              } else if (Booleans.dseyes2cape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/dseyes2cape.png"));
              } else if (Booleans.dseyescape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/dseyescape.png"));
              } else if (Booleans.wintercape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/wintercape.png"));
              } else if (Booleans.Sparkofyt && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/discord/sparkofytcape.png"));
              } else if (Booleans.Sparkofyt2 && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/discord/sparkofyt2cape.png"));
              } else if (Booleans.RinneCape && CosmeticChecker.ownsZeroTwoCape(entitylivingbaseIn)) {
                this.playerRenderer.bindTexture(new ResourceLocation("Animeware/cosmetic/capes/ani/rinnegan/" + AnimUtil.frames + ".png")); //Animeware/cosmetic/capes/blank.png
              } else {
            	  //this.nocape = true;
            	  //this.playerRenderer.bindTexture(new ResourceLocation(null)); //Animeware/cosmetic/capes/blank.png
              }
            }
            } catch(NullPointerException e) {
            	this.playerRenderer.bindTexture(new ResourceLocation(null));
            	e.printStackTrace();
            }
            
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.0F, 0.125F);
            double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double)partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double)partialTicks);
            double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double)partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double)partialTicks);
            double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double)partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double)partialTicks);
            float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
            double d3 = (double)MathHelper.sin(f * (float)Math.PI / 180.0F);
            double d4 = (double)(-MathHelper.cos(f * (float)Math.PI / 180.0F));
            float f1 = (float)d1 * 10.0F;
            f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;

            if (f2 < 0.0F)
            {
                f2 = 0.0F;
            }

            float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
            f1 = f1 + MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;

            if (entitylivingbaseIn.isSneaking())
            {
                f1 += 25.0F;
            }
            if (entitylivingbaseIn.isSneaking())
            {
                //f1 += 25.0F;
                GlStateManager.translate(0.0F, 0.142F, -0.0178F);
                //GlStateManager.translate(0.0F, 0.0F, 0.0F);
            }

            GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            this.playerRenderer.getMainModel().renderCape(0.0625F);
            GlStateManager.popMatrix();
        	}
        }
	}
