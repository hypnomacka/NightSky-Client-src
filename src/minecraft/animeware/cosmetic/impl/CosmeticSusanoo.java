package animeware.cosmetic.impl;

import animeware.NightSky;
import animeware.cosmetic.CosmeticChecker;
import animeware.cosmetic.CosmeticBase;
import animeware.cosmetic.CosmeticModelBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;




public class CosmeticSusanoo extends CosmeticBase {
  private final NAME2 nameModel;
  
  public CosmeticSusanoo(RenderPlayer renderPlayer) {
    super(renderPlayer);
    this.nameModel = new NAME2(renderPlayer);
  }
  
  public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
   
      GlStateManager.pushMatrix();
      GlStateManager.color(1, 0, 0);
      GlStateManager.disableLighting();
 	 GlStateManager.blendFunc(1, 1);
     GlStateManager.enableBlend();
      if(player.isSneaking()) {
    		GlStateManager.rotate(20, 1, 0, 0);
      	GlStateManager.translate(0, 0.20, -0.05);
      }
  	GlStateManager.translate(0, -0.2, 0);
  	
  	
    String uuid = player.getUniqueID().toString();
    if(uuid.contains("dwjandowpiahnbdwoiuadw")) {
	  this.nameModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		 GlStateManager.color(1, 1, 1);
	}
    //if(Animeware.Susanoo && CapeChecker.ownsZeroTwoCape(player) && player instanceof EntityPlayerSP) {
        GlStateManager.disableColorMaterial();
     	 GlStateManager.color(255, 0, 0);
     	 this.nameModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    //}
    GlStateManager.enableLighting();
    GlStateManager.enableLighting();
    GlStateManager.enableColorMaterial();
    GlStateManager.disableBlend();
      GlStateManager.popMatrix();
  }
   class NAME2 extends CosmeticModelBase {
	    ModelRenderer Back;
	    ModelRenderer upperlane;
	    ModelRenderer upperlaneonedown;
	    ModelRenderer upperlanetwodown;
	    ModelRenderer left1;
	    ModelRenderer left2;
	    ModelRenderer left3;
	    ModelRenderer right1;
	    ModelRenderer right2;
	    ModelRenderer right3;
    
    public NAME2(RenderPlayer player) {
      super(player);
      textureWidth = 0;
      textureHeight = 0;
        Back = new ModelRenderer(this, 0, 0);
        Back.addBox(0F, 0F, 0F, 2, 15, 1);
        Back.setRotationPoint(-1F, 0F, 6F);
        Back.setTextureSize(64, 32);
        Back.mirror = true;
        upperlane = new ModelRenderer(this, 0, 0);
        upperlane.addBox(0F, 0F, 0F, 22, 1, 1);
        upperlane.setRotationPoint(-11F, 3F, 6F);
        upperlane.setTextureSize(64, 32);
        upperlane.mirror = true;
        upperlaneonedown = new ModelRenderer(this, 0, 0);
        upperlaneonedown.addBox(0F, 0F, 0F, 22, 1, 1);
        upperlaneonedown.setRotationPoint(-11F, 6F, 6F);
        upperlaneonedown.setTextureSize(64, 32);
        upperlaneonedown.mirror = true;
        upperlanetwodown = new ModelRenderer(this, 0, 0);
        upperlanetwodown.addBox(0F, 0F, 0F, 22, 1, 1);
        upperlanetwodown.setRotationPoint(-11F, 10F, 6F);
        upperlanetwodown.setTextureSize(64, 32);
        upperlanetwodown.mirror = true;
        left1 = new ModelRenderer(this, 0, 0);
        left1.addBox(0F, 0F, 0F, 1, 1, 9);
        left1.setRotationPoint(10F, 3F, -3F);
        left1.setTextureSize(64, 32);
        left1.mirror = true;
        left2 = new ModelRenderer(this, 0, 0);
        left2.addBox(0F, 0F, 0F, 1, 1, 9);
        left2.setRotationPoint(10F, 6F, -3F);
        left2.setTextureSize(64, 32);
        left2.mirror = true;
        left3 = new ModelRenderer(this, 0, 0);
        left3.addBox(0F, 0F, 0F, 1, 1, 9);
        left3.setRotationPoint(10F, 10F, -3F);
        left3.setTextureSize(64, 32);
        left3.mirror = true;
        right1 = new ModelRenderer(this, 0, 0);
        right1.addBox(0F, 0F, 0F, 1, 1, 9);
        right1.setRotationPoint(-11F, 3F, -3F);
        right1.setTextureSize(64, 32);
        right1.mirror = true;
        right2 = new ModelRenderer(this, 0, 0);
        right2.addBox(0F, 0F, 0F, 1, 1, 9);
        right2.setRotationPoint(-11F, 6F, -3F);
        right2.setTextureSize(64, 32);
        right2.mirror = true;
        right3 = new ModelRenderer(this, 0, 0);
        right3.addBox(0F, 0F, 0F, 1, 1, 9);
        right3.setRotationPoint(-11F, 10F, -3F);
        right3.setTextureSize(64, 32);
        right3.mirror = true;
     
    
    }
    
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();
        this.Back.render(scale);
        this.right1.render(scale);
        this.right2.render(scale);
        this.right3.render(scale);
        this.upperlane.render(scale);
        this.upperlaneonedown.render(scale);
        this.upperlanetwodown.render(scale);
        this.left1.render(scale);
        this.left2.render(scale);
        this.left3.render(scale);
       
        GlStateManager.popMatrix();
        
    }
    
  }
}