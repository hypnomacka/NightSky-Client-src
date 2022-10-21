package animeware.cosmetic.impl;

import java.awt.Color;

import animeware.cosmetic.CosmeticController;
import animeware.util.RainbowColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;


public class CosmeticWitherArmor implements LayerRenderer<AbstractClientPlayer>
{
    private static final ResourceLocation WITHER_ARMOR = new ResourceLocation("Animeware/cosmetic/creeper_armor.png");
    private final RenderPlayer renderPlayer;
    private final ModelPlayer playerModel;

    public CosmeticWitherArmor(RenderPlayer renderPlayer)
    {
        this.renderPlayer = renderPlayer;
        this.playerModel = renderPlayer.getMainModel();
    }



    public void doRenderLayer(AbstractClientPlayer player, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale)
    {



            
                if (player == Minecraft.getMinecraft().thePlayer && CosmeticController.shouldRenderTopHat(player)) {
                    GlStateManager.depthMask(!player.isInvisible());
                    this.renderPlayer.bindTexture(WITHER_ARMOR);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.loadIdentity();
                    float f = (float) player.ticksExisted + partialTicks;
                    float f1 = MathHelper.cos(f * 0.004F) * 3.0F;
                    float f2 = f * 0.004F;
                    GlStateManager.translate(f1, f2, 0.0F);
                    GlStateManager.matrixMode(5888);
                    GlStateManager.enableBlend();
                    float f3 = 0.5F;
                    //GlStateManager.color(f3, f3, f3, 1.0F);
                    Color.getColor(String.valueOf(RainbowColor.colorLerpv2(Color.DARK_GRAY, Color.RED, 1)));
                    GlStateManager.disableLighting();
                    GlStateManager.blendFunc(1, 1);
                    this.playerModel.setLivingAnimations(player, p_177141_2_, p_177141_3_, partialTicks);
                    this.playerModel.setModelAttributes(this.renderPlayer.getMainModel());
                    this.playerModel.render(player, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.loadIdentity();
                    GlStateManager.matrixMode(5888);
                    GlStateManager.enableLighting();
                    GlStateManager.disableBlend();
                }
            


    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
