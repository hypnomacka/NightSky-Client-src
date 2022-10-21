package animeware.cosmetic.impl;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;


public class CosmeticCreeperLightning extends CosmeticBase
{
    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("Animeware/cosmetic/creeper_armor.png");
    private final RenderPlayer renderPlayer;
    private ModelPlayer playerModel;

    public CosmeticCreeperLightning(RenderPlayer renderPlayer)
    {
        super(renderPlayer);
        this.renderPlayer = renderPlayer;
        this.playerModel = renderPlayer.getMainModel();
    }

    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {


          if(Booleans.CreeperLightning == true) {
            boolean flag = player.isInvisible();
            GlStateManager.depthMask(!flag);
            this.playerModel = this.renderPlayer.getMainModel();
            this.renderPlayer.bindTexture(LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float f = (float)player.ticksExisted + partialTicks;
            double d0 = 0.5;
            GlStateManager.translate((double)1 / -100, (double)f * d0, 0.0D);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();

            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.playerModel.setModelAttributes(this.renderPlayer.getMainModel());
            this.playerModel.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, 0.0625F);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(flag);
            GlStateManager.disableLighting();
          }

    }
}
