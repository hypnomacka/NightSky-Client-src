package animeware.cosmetic.impl;


import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.Cosmetic;
import animeware.cosmetic.CosmeticModule;
import animeware.event.EventListener;
import animeware.event.impl.Render3DEvent;
import animeware.hud.Category;
import animeware.util.MathUtils;
import animeware.util.render.ColorUtil;
import animeware.util.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ChinaHat extends Cosmetic {

    //private final BooleanSetting firstPerson = new BooleanSetting("Show in first person", false);

    public ChinaHat(RenderPlayer renderPlayer) {
    	super("ChinaHat", true, renderPlayer);
    	this.playerRenderer = renderPlayer;
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (mc.thePlayer == null || mc.theWorld == null || mc.thePlayer.isInvisible() || mc.thePlayer.isDead || Booleans.ChinaHat == false) return;
        if (mc.gameSettings.thirdPersonView == 0) return;
        
        if(player == Minecraft.getMinecraft().thePlayer && !player.isInvisible()) {

        double posX = mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * mc.timer.renderPartialTicks - mc.getRenderManager().renderPosX,
                posY = mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * mc.timer.renderPartialTicks - mc.getRenderManager().renderPosY - (mc.thePlayer.isSneaking() ? 1 : 1.1),
                posZ = mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * mc.timer.renderPartialTicks - mc.getRenderManager().renderPosZ;

        AxisAlignedBB axisalignedbb = mc.thePlayer.getEntityBoundingBox();
        double height = axisalignedbb.maxY - axisalignedbb.minY + 0.02,
                radius = axisalignedbb.maxX - axisalignedbb.minX;

        GL11.glPushMatrix();
        GlStateManager.disableCull();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glEnable(GL11.GL_BLEND);
        GlStateManager.disableLighting();
        GlStateManager.color(1, 1, 1, 1);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);

        float yaw = MathUtils.interpolate(mc.thePlayer.prevRotationYaw, mc.thePlayer.rotationYaw, mc.timer.renderPartialTicks).floatValue();
        float pitchInterpolate = MathUtils.interpolate(mc.thePlayer.prevRenderArmPitch, mc.thePlayer.renderArmPitch, mc.timer.renderPartialTicks).floatValue();

        GL11.glTranslated(posX, posY, posZ);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glRotated(yaw, posX, posY, posZ);
        GL11.glRotated(pitchInterpolate / 9.0, posX, posY, posZ);
        GL11.glTranslatef(0, 0, -0.0F);
        GL11.glLineWidth(2);
        GL11.glBegin(GL11.GL_LINE_LOOP);

        // outline/border or whatever you call it
        for (int i = 0; i <= 180; i++) {
            int color1 = ColorUtil.rainbow(7, i * 4, 1, 1, .5f).getRGB();
            GlStateManager.color(1, 1, 1, 1);
            RenderUtil.color(color1);
            
            GL11.glVertex3d(
                    posX - Math.sin(i * MathHelper.PI2 / 90) * radius,
                    posY + height - 0.002,
                    posZ + Math.cos(i * MathHelper.PI2 / 90) * radius
            );
            
        }
        GL11.glEnd();

        GL11.glBegin(GL11.GL_TRIANGLE_FAN);
        int color12 = ColorUtil.rainbow(7, 4, 1, 1, .7f).getRGB();
        RenderUtil.color(color12);
        
        
        	GL11.glVertex3d(posX, posY + height - 0.3, posZ);
        
        

        // draw hat
        for (int i = 0; i <= 180; i++) {
            int color1 = ColorUtil.rainbow(7, i * 4, 1, 1, .2f).getRGB();
            GlStateManager.color(1, 1, 1, 1);
            RenderUtil.color(color1);
            GL11.glVertex3d(posX - Math.sin(i * MathHelper.PI2 / 90) * radius,
                    posY + height - 0,
                    posZ + Math.cos(i * MathHelper.PI2 / 90) * radius
            );

        }
        //GL11.glVertex3d(posX, posY + height + 0.3, posZ);
        GL11.glEnd();


        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
    }
	

}
