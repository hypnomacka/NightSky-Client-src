package animeware.cosmetic.impl;

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
import net.minecraft.util.ResourceLocation;

public class CosmeticSusanno extends CosmeticBase
{
    private static final ResourceLocation susanno = new ResourceLocation("Animeware/cosmetic/susanno.png");
    private final CosmeticSusanno.SusannoModel susannoModel;

    public CosmeticSusanno(RenderPlayer player)
    {
        super(player);
        this.susannoModel = new CosmeticSusanno.SusannoModel(player);
    }

    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {



            
                if (player == Minecraft.getMinecraft().thePlayer && CosmeticController.shouldRenderTopHat(player)) {
                    GlStateManager.pushMatrix();

                    this.renderPlayer.bindTexture(susanno);
                    GlStateManager.enableBlend();

                    GlStateManager.color(1,0,1);

                    GlStateManager.blendFunc(77, 77);
                    this.susannoModel.render(player, limbSwing, limbSwingAmount, ageInTicks, headPitch, headPitch, scale);

                    GL11.glPopMatrix();
                }
            


    }


    public static class SusannoModel extends CosmeticModelBase
    {
        ModelRenderer leftRib12;
        ModelRenderer leftRib22;
        ModelRenderer leftRib32;
        ModelRenderer leftRib42;
        ModelRenderer rightRib12;
        ModelRenderer rightRib22;
        ModelRenderer rightRib32;
        ModelRenderer rightRib42;
        ModelRenderer Spine;
        ModelRenderer leftRib41;
        ModelRenderer rightRib41;
        ModelRenderer leftRib31;
        ModelRenderer leftRib21;
        ModelRenderer leftRib11;
        ModelRenderer rightRib31;
        ModelRenderer rightRib21;
        ModelRenderer rightRib11;
        ModelRenderer leftRib43;
        ModelRenderer leftRib33;
        ModelRenderer leftRib23;
        ModelRenderer leftRib13;
        ModelRenderer rightRib43;
        ModelRenderer rightRib33;
        ModelRenderer rightRib23;
        ModelRenderer rightRib13;

        public SusannoModel(RenderPlayer player)
        {
            super(player);
            this.textureWidth = 128;
            this.textureHeight = 64;
            (this.leftRib12 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
            this.leftRib12.setRotationPoint(9.0F, 18.0F, -5.0F);
            this.leftRib12.setTextureSize(64, 32);
            this.leftRib12.mirror = true;
            this.setRotation(this.leftRib12, 0.0F, 0.0F, 0.0F);
            (this.leftRib22 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 14);
            this.leftRib22.setRotationPoint(11.0F, 10.0F, -7.0F);
            this.leftRib22.setTextureSize(64, 32);
            this.leftRib22.mirror = true;
            this.setRotation(this.leftRib22, 0.0F, 0.0F, 0.0F);
            (this.leftRib32 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 14);
            this.leftRib32.setRotationPoint(11.0F, 2.0F, -7.0F);
            this.leftRib32.setTextureSize(64, 32);
            this.leftRib32.mirror = true;
            this.setRotation(this.leftRib32, 0.0F, 0.0F, 0.0F);
            (this.leftRib42 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
            this.leftRib42.setRotationPoint(9.0F, -5.0F, -5.0F);
            this.leftRib42.setTextureSize(64, 32);
            this.leftRib42.mirror = true;
            this.setRotation(this.leftRib42, 0.0F, 0.0F, 0.0F);
            (this.rightRib12 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
            this.rightRib12.setRotationPoint(-10.0F, 18.0F, -5.0F);
            this.rightRib12.setTextureSize(64, 32);
            this.rightRib12.mirror = true;
            this.setRotation(this.rightRib12, 0.0F, 0.0F, 0.0F);
            (this.rightRib22 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 14);
            this.rightRib22.setRotationPoint(-12.0F, 10.0F, -7.0F);
            this.rightRib22.setTextureSize(64, 32);
            this.rightRib22.mirror = true;
            this.setRotation(this.rightRib22, 0.0F, 0.0F, 0.0F);
            (this.rightRib32 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 14);
            this.rightRib32.setRotationPoint(-12.0F, 2.0F, -7.0F);
            this.rightRib32.setTextureSize(64, 32);
            this.rightRib32.mirror = true;
            this.setRotation(this.rightRib32, 0.0F, 0.0F, 0.0F);
            (this.rightRib42 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
            this.rightRib42.setRotationPoint(-10.0F, -5.0F, -5.0F);
            this.rightRib42.setTextureSize(64, 32);
            this.rightRib42.mirror = true;
            this.setRotation(this.rightRib42, 0.0F, 0.0F, 0.0F);
            (this.Spine = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 4, 26, 3);
            this.Spine.setRotationPoint(-2.0F, -5.0F, 9.0F);
            this.Spine.setTextureSize(64, 32);
            this.Spine.mirror = true;
            this.setRotation(this.Spine, 0.0F, 0.0F, 0.0F);
            (this.leftRib41 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 10, 3, 1);
            this.leftRib41.setRotationPoint(1.5F, -5.0F, 10.3F);
            this.leftRib41.setTextureSize(64, 32);
            this.leftRib41.mirror = true;
            this.setRotation(this.leftRib41, 0.0F, 0.6632251F, 0.0F);
            (this.rightRib41 = new ModelRenderer(this, 0, 0)).addBox(-10.0F, 0.0F, 0.0F, 10, 3, 1);
            this.rightRib41.setRotationPoint(-1.6F, -5.0F, 10.5F);
            this.rightRib41.setTextureSize(64, 32);
            this.rightRib41.mirror = true;
            this.setRotation(this.rightRib41, 0.0F, -0.6894051F, 0.0F);
            (this.leftRib31 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 11, 3, 1);
            this.leftRib31.setRotationPoint(1.3F, 2.0F, 10.0F);
            this.leftRib31.setTextureSize(64, 32);
            this.leftRib31.mirror = true;
            this.setRotation(this.leftRib31, 0.0F, 0.3665191F, 0.0F);
            (this.leftRib21 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 11, 3, 1);
            this.leftRib21.setRotationPoint(1.3F, 10.0F, 10.0F);
            this.leftRib21.setTextureSize(64, 32);
            this.leftRib21.mirror = true;
            this.setRotation(this.leftRib21, 0.0F, 0.3665191F, 0.0F);
            (this.leftRib11 = new ModelRenderer(this, 0, 0)).addBox(0.0F, -1.0F, 0.0F, 10, 3, 1);
            this.leftRib11.setRotationPoint(1.5F, 19.0F, 10.3F);
            this.leftRib11.setTextureSize(64, 32);
            this.leftRib11.mirror = true;
            this.setRotation(this.leftRib11, 0.0F, 0.6632251F, 0.0F);
            (this.rightRib31 = new ModelRenderer(this, 0, 0)).addBox(-11.0F, 0.0F, 0.0F, 11, 3, 1);
            this.rightRib31.setRotationPoint(-1.3F, 2.0F, 10.0F);
            this.rightRib31.setTextureSize(64, 32);
            this.rightRib31.mirror = true;
            this.setRotation(this.rightRib31, 0.0F, -0.3665191F, 0.0F);
            (this.rightRib21 = new ModelRenderer(this, 0, 0)).addBox(-11.0F, 0.0F, 0.0F, 11, 3, 1);
            this.rightRib21.setRotationPoint(-1.3F, 10.0F, 10.0F);
            this.rightRib21.setTextureSize(64, 32);
            this.rightRib21.mirror = true;
            this.setRotation(this.rightRib21, 0.0F, -0.3665191F, 0.0F);
            (this.rightRib11 = new ModelRenderer(this, 0, 0)).addBox(-10.0F, 0.0F, 0.0F, 10, 3, 1);
            this.rightRib11.setRotationPoint(-1.6F, 18.0F, 10.5F);
            this.rightRib11.setTextureSize(64, 32);
            this.rightRib11.mirror = true;
            this.setRotation(this.rightRib11, 0.0F, -0.6894051F, 0.0F);
            (this.leftRib43 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.leftRib43.setRotationPoint(4.6F, -5.0F, -9.5F);
            this.leftRib43.setTextureSize(64, 32);
            this.leftRib43.mirror = true;
            this.setRotation(this.leftRib43, 0.0F, -0.6894051F, 0.0F);
            (this.leftRib33 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.leftRib33.setRotationPoint(6.5F, 2.0F, -11.4F);
            this.leftRib33.setTextureSize(64, 32);
            this.leftRib33.mirror = true;
            this.setRotation(this.leftRib33, 0.0F, -0.6894051F, 0.0F);
            (this.leftRib23 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.leftRib23.setRotationPoint(6.5F, 10.0F, -11.4F);
            this.leftRib23.setTextureSize(64, 32);
            this.leftRib23.mirror = true;
            this.setRotation(this.leftRib23, 0.0F, -0.6894051F, 0.0F);
            (this.leftRib13 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.leftRib13.setRotationPoint(4.6F, 18.0F, -9.5F);
            this.leftRib13.setTextureSize(64, 32);
            this.leftRib13.mirror = true;
            this.setRotation(this.leftRib13, 0.0F, -0.6894051F, 0.0F);
            (this.rightRib43 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.rightRib43.setRotationPoint(-10.0F, -5.0F, -5.0F);
            this.rightRib43.setTextureSize(64, 32);
            this.rightRib43.mirror = true;
            this.setRotation(this.rightRib43, 0.0F, 0.6632251F, 0.0F);
            (this.rightRib33 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.rightRib33.setRotationPoint(-12.0F, 2.0F, -7.0F);
            this.rightRib33.setTextureSize(64, 32);
            this.rightRib33.mirror = true;
            this.setRotation(this.rightRib33, 0.0F, 0.6632251F, 0.0F);
            (this.rightRib23 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.rightRib23.setRotationPoint(-12.0F, 10.0F, -7.0F);
            this.rightRib23.setTextureSize(64, 32);
            this.rightRib23.mirror = true;
            this.setRotation(this.rightRib23, 0.0F, 0.6632251F, 0.0F);
            (this.rightRib13 = new ModelRenderer(this, 0, 0)).addBox(0.0F, 0.0F, 0.0F, 7, 3, 1);
            this.rightRib13.setRotationPoint(-10.0F, 18.0F, -5.0F);
            this.rightRib13.setTextureSize(64, 32);
            this.rightRib13.mirror = true;
            this.setRotation(this.rightRib13, 0.0F, 0.6632251F, 0.0F);
        }

        private void setRotation(ModelRenderer model, float x, float y, float z)
        {
            model.rotateAngleX = x;
            model.rotateAngleY = y;
            model.rotateAngleZ = z;
        }

        public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
        {
            this.leftRib12.render(scale);
            this.leftRib22.render(scale);
            this.leftRib32.render(scale);
            this.leftRib42.render(scale);
            this.rightRib12.render(scale);
            this.rightRib22.render(scale);
            this.rightRib32.render(scale);
            this.rightRib42.render(scale);
            this.Spine.render(scale);
            this.leftRib41.render(scale);
            this.rightRib41.render(scale);
            this.leftRib31.render(scale);
            this.leftRib21.render(scale);
            this.leftRib11.render(scale);
            this.rightRib31.render(scale);
            this.rightRib21.render(scale);
            this.rightRib11.render(scale);
            this.leftRib43.render(scale);
            this.leftRib33.render(scale);
            this.leftRib23.render(scale);
            this.leftRib13.render(scale);
            this.rightRib43.render(scale);
            this.rightRib33.render(scale);
            this.rightRib23.render(scale);
            this.rightRib13.render(scale);
        }
    }
}
