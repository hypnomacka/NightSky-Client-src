package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBandana extends ModelPlayer {
  private Minecraft mc;
  
  public ResourceLocation location;
  
  private ModelRenderer band1;
  
  private ModelRenderer band2;
  
  private ModelRenderer band3;
  
  private ModelRenderer band4;
  
  private boolean playerUsesFullHeight;
  
  public RenderBandana(float p_i46304_1_, boolean p_i46304_2_) {
    super(p_i46304_1_, p_i46304_2_);
    this.mc = Minecraft.getMinecraft();
    this.location = new ResourceLocation("Animeware/cosmetic/bandana.png");
    this.playerUsesFullHeight = true;
    this.band1 = new ModelRenderer((ModelBase)this, 0, 0);
    this.band1.addBox(-4.5F, -7.0F, -4.7F, 9, 2, 1);
    this.band2 = new ModelRenderer((ModelBase)this, 0, 0);
    this.band2.addBox(3.5F, -7.0F, -3.5F, 1, 2, 8);
    this.band3 = new ModelRenderer((ModelBase)this, 0, 0);
    this.band3.addBox(-4.5F, -7.0F, -3.5F, 1, 2, 8);
    this.band4 = new ModelRenderer((ModelBase)this, 0, 0);
    this.band4.addBox(-4.5F, -7.0F, 4.0F, 9, 2, 1);
  }
  
  public void render(AbstractClientPlayer var1) {
    GlStateManager.pushMatrix();
    if (var1.isSneaking())
      GL11.glTranslated(0.0D, 0.225D, 0.0D); 
    renderA((Entity)var1, 0.0625F);
    GL11.glColor3f(1.0F, 1.0F, 1.0F);
    GL11.glPopMatrix();
  }
  
  public void renderA(Entity var1, float var7) {
    GlStateManager.pushMatrix();
    copyModelAngles(this.bipedHead, this.band1);
    this.band1.rotationPointX = 0.0F;
    this.band1.rotationPointY = 0.0F;
    this.band1.render(var7);
    copyModelAngles(this.bipedHead, this.band2);
    this.band2.rotationPointX = 0.0F;
    this.band2.rotationPointY = 0.0F;
    this.band2.render(var7);
    copyModelAngles(this.bipedHead, this.band3);
    this.band3.rotationPointX = 0.0F;
    this.band3.rotationPointY = 0.0F;
    this.band3.render(var7);
    copyModelAngles(this.bipedHead, this.band4);
    this.band4.rotationPointX = 0.0F;
    this.band4.rotationPointY = 0.0F;
    this.band4.render(var7);
    GlStateManager.popMatrix();
  }
  public void onRenderPlayer(EntityPlayer player, float partialTick) {
	    if (player.equals(this.mc.thePlayer) && !player.isInvisible() && !player.isDead)
	    	renderA(player, partialTick); 
	  }
  
  private float interpolate(float yaw1, float yaw2, float percent) {
    float f = (yaw1 + (yaw2 - yaw1) * percent) % 360.0F;
    if (f < 0.0F)
      f += 360.0F; 
    return f;
  }
}
