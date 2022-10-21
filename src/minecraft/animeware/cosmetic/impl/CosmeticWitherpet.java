package animeware.cosmetic.impl;


import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticBase;
import animeware.cosmetic.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CosmeticWitherpet extends CosmeticBase
{
    private final CosmeticWitherpet.CosmeticVilligerNose2 wingsModel;

    public CosmeticWitherpet(RenderPlayer renderPlayer)
    {
        super(renderPlayer);
        this.wingsModel = new CosmeticWitherpet.CosmeticVilligerNose2(renderPlayer, 0.0F);
    }

    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	if(Booleans.Witherpet == true) {
        GL11.glPushMatrix();

        if (player.isSneaking())
        {
            GlStateManager.translate(0.0D, 0.2D, -0.05D);
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/wither/wither.png"));
        GlStateManager.scale(0.4D, 0.4D, 0.4D);
        GlStateManager.translate(1.7D, -1.0D, 0.0D);
        float f = ageInTicks / 60.0F;
        float f1 = f * (float)Math.PI * 1.0F;
        GlStateManager.translate(0.0F, -((float)(Math.sin((double)(f1 + 2.0F)) + 0.5D)) * 0.08F, 0.0F);
        Minecraft.getMinecraft();

        if (player == Minecraft.getMinecraft().thePlayer)
        {
            GlStateManager.color(255.0F, 255.0F, 255.0F);
            this.wingsModel.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }

        GL11.glPopMatrix();
    }
   
   }

    public class CosmeticVilligerNose2 extends CosmeticModelBase
    {
        private ModelRenderer[] field_82905_a;
        private ModelRenderer[] field_82904_b;

        public CosmeticVilligerNose2(RenderPlayer player, float p_i46302_1_)
        {
            super(player);
            this.textureWidth = 64;
            this.textureHeight = 64;
            this.field_82905_a = new ModelRenderer[3];
            (this.field_82905_a[0] = new ModelRenderer(this, 0, 16)).addBox(-10.0F, 3.9F, -0.5F, 20, 3, 3, p_i46302_1_);
            (this.field_82905_a[1] = (new ModelRenderer(this)).setTextureSize(this.textureWidth, this.textureHeight)).setRotationPoint(-2.0F, 6.9F, -0.5F);
            this.field_82905_a[1].setTextureOffset(0, 22).addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, p_i46302_1_);
            this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0F, 1.5F, 0.5F, 11, 2, 2, p_i46302_1_);
            this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0F, 4.0F, 0.5F, 11, 2, 2, p_i46302_1_);
            this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0F, 6.5F, 0.5F, 11, 2, 2, p_i46302_1_);
            (this.field_82905_a[2] = new ModelRenderer(this, 12, 22)).addBox(0.0F, 0.0F, 0.0F, 3, 6, 3, p_i46302_1_);
            this.field_82904_b = new ModelRenderer[3];
            (this.field_82904_b[0] = new ModelRenderer(this, 0, 0)).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, p_i46302_1_);
            (this.field_82904_b[1] = new ModelRenderer(this, 32, 0)).addBox(-4.0F, -4.0F, -4.0F, 6, 6, 6, p_i46302_1_);
            this.field_82904_b[1].rotationPointX = -8.0F;
            this.field_82904_b[1].rotationPointY = 4.0F;
            (this.field_82904_b[2] = new ModelRenderer(this, 32, 0)).addBox(-4.0F, -4.0F, -4.0F, 6, 6, 6, p_i46302_1_);
            this.field_82904_b[2].rotationPointX = 10.0F;
            this.field_82904_b[2].rotationPointY = 4.0F;
        }

        public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale)
        {
            GlStateManager.pushMatrix();

            for (ModelRenderer modelrenderer : this.field_82904_b)
            {
                modelrenderer.render(scale);
            }

            for (ModelRenderer modelrenderer1 : this.field_82905_a)
            {
                modelrenderer1.render(scale);
            }

            GlStateManager.popMatrix();
        }
    }
}