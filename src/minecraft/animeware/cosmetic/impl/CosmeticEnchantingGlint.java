package animeware.cosmetic.impl;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;


public class CosmeticEnchantingGlint implements LayerRenderer<AbstractClientPlayer>
{
    protected static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("Animeware/cosmetic/enchantGlint.png");
    private final RenderPlayer renderPlayer;
    private final ModelPlayer playerModel;

    public CosmeticEnchantingGlint(RenderPlayer renderPlayer)
    {
        this.renderPlayer = renderPlayer;
        this.playerModel = new ModelPlayer(0.2F, false);
    }

    public void doRenderLayer(AbstractClientPlayer player, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale)
    {


        if (player == Minecraft.getMinecraft().thePlayer && CosmeticController.shouldRenderTopHat(player) && Booleans.EnchantingGlint == true) {
            
                this.createEnchantGlint(player, this.renderPlayer.getMainModel(), p_177141_2_, p_177141_3_, partialTicks, p_177141_5_, p_177141_6_, p_177141_7_, scale);
            }
        




    }

    private void createEnchantGlint(EntityLivingBase entitylivingbaseIn, ModelBase modelbaseIn, float p_177183_3_, float p_177183_4_, float p_177183_5_, float p_177183_6_, float p_177183_7_, float p_177183_8_, float p_177183_9_)
    {

            float f = (float)entitylivingbaseIn.ticksExisted + p_177183_5_;
            this.renderPlayer.bindTexture(ENCHANTED_ITEM_GLINT_RES);



            GlStateManager.enableBlend();
            GlStateManager.depthFunc(514);
            GlStateManager.depthMask(false);
            float f1 = 0.5F;
            GlStateManager.color(f1, f1, f1, 1.0F);

            for (int i = 0; i < 2; ++i)
            {
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(768, 1);
                float f2 = 0.76F;
                GlStateManager.color(0.5F * f2, 0.25F * f2, 0.8F * f2, 1.0F);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                float f3 = 0.33333334F;
                GlStateManager.scale(f3, f3, f3);
                GlStateManager.rotate(30.0F - (float)i * 60.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.translate(0.0F, f * (0.001F + (float)i * 0.003F) * 20.0F, 0.0F);
                GlStateManager.matrixMode(5888);
                modelbaseIn.render(entitylivingbaseIn, p_177183_3_, p_177183_4_, p_177183_6_, p_177183_7_, p_177183_8_, p_177183_9_);
            }

            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();



    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
