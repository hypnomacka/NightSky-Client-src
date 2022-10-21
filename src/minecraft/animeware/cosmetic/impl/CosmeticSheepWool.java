package animeware.cosmetic.impl;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class CosmeticSheepWool implements LayerRenderer<AbstractClientPlayer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    private final RenderPlayer playerrenderer;
    private final ModelPlayer sheepModel;

    public CosmeticSheepWool(RenderPlayer player, ModelPlayer sheepModel) {
        this.playerrenderer = player;
        this.sheepModel = sheepModel;
    }

    @Override
    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
        if (!entitylivingbaseIn.isInvisible())
        {
            this.playerrenderer.bindTexture(TEXTURE);


                //float[] afloat = EntitySheep.func_175513_a(RenderSheep.getFleeceColor());
                GlStateManager.color(1, 0,1);


            //this.sheepModel.setModelAttributes(this.playerrenderer.getMainModel());
            //this.sheepModel.setLivingAnimations(entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks);
            //this.sheepModel.render(entitylivingbaseIn, 1, 2, 3,4, 5, 1);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
