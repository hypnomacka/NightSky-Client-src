package animeware.cosmetic.impl;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.CosmeticBase;
import animeware.cosmetic.CosmeticController;
import animeware.cosmetic.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticEnderCrystal extends CosmeticBase
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("Animeware/cosmetic/endercrystal.png");
    public int innerRotation;
    private CosmeticEnderCrystal.EnderCrystalModel enderCrystalModel;

    public CosmeticEnderCrystal(RenderPlayer player)
    {
        super(player);
        this.enderCrystalModel = new CosmeticEnderCrystal.EnderCrystalModel(player);
        this.innerRotation = (new Random()).nextInt(100000);
    }

    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {


        
            if (player == Minecraft.getMinecraft().thePlayer && CosmeticController.shouldRenderTopHat(player)) {
                this.enderCrystalModel = new CosmeticEnderCrystal.EnderCrystalModel(this.renderPlayer);
                ++this.innerRotation;
                GlStateManager.pushMatrix();
                this.renderPlayer.bindTexture(TEXTURE);

                if (player.isSneaking()) {
                    GL11.glTranslated(0.0D, 0.3D, 0.0D);
                }

                GL11.glTranslated(0.0D, -0.9D, 0.0D);
                float f = (float) this.innerRotation;
                float f1 = MathHelper.sin(f * 0.2F) / 2.0F + 0.5F;
                f1 = f1 * f1 + f1;
                this.enderCrystalModel.render(player, 0.0F, f * 0.05F, f1 * 0.002F, 0.0F, 0.0F, 0.1F);
                GL11.glPopMatrix();
            }
     }



    

    public static class EnderCrystalModel extends CosmeticModelBase
    {
        ModelRenderer glass = new ModelRenderer(this, "glass");

        public EnderCrystalModel(RenderPlayer player)
        {
            super(player);
            this.glass.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        }

        public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
        {
            GlStateManager.pushMatrix();
            GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.8F + p_78088_4_, 0.0F);
            GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
            this.glass.render(scale);
            float f = 0.875F;
            GlStateManager.scale(f, f, f);
            GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
            GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
            this.glass.render(scale);
            GlStateManager.popMatrix();
        }
    }
}
