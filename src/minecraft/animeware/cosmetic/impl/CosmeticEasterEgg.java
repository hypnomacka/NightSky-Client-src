// 
// Decompiled by Procyon v0.5.36
// 

package animeware.cosmetic.impl;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticBase;
import animeware.cosmetic.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CosmeticEasterEgg extends CosmeticBase
{
    private final CosmeticVilligerNose2 EggsModel;
    
    public CosmeticEasterEgg(final RenderPlayer renderPlayer) {
        super(renderPlayer);
        this.EggsModel = new CosmeticVilligerNose2(renderPlayer);
    }
    
    @Override
    public void render(final AbstractClientPlayer player, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        GL11.glPushMatrix();
        if (player.isSneaking()) {
            GlStateManager.translate(0.0, 0.262, 0.0);
        }
        GlStateManager.rotate(netHeadYaw, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(headPitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(ageInTicks * 17.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        final String uuid = player.getUniqueID().toString();
        if (uuid.contains("dwabdwbo8adb8wbdwa")) {
            this.EggsModel.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GL11.glColor3d(1.0, 1.0, 1.0);
        }
        Minecraft.getMinecraft();
        if (player == Minecraft.thePlayer && Booleans.CosmeticEasterEggs) {
            this.EggsModel.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
        GL11.glPopMatrix();
    }
    
    public class CosmeticVilligerNose2 extends CosmeticModelBase
    {
        public CosmeticVilligerNose2(final RenderPlayer player) {
            super(player);
        }
        
        @Override
        public void render(final Entity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float headYaw, final float headPitch, final float scale) {
            final Minecraft mc = null;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.25, 0.25, 0.25);
            GlStateManager.translate(2.0, 1.5, 0.0);
            final ItemStack itemsword = new ItemStack(Items.egg);
            Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
            GlStateManager.translate(-4.0f, 0.0f, 0.0f);
            Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
            GlStateManager.translate(2.0f, 0.0f, 2.0f);
            Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
            GlStateManager.translate(0.0f, 0.0f, -4.0f);
            Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
        }
    }
}
