package animeware.util.misc;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animeware.util.render.ColorUtils;
import animeware.util.render.GLUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Timer;

public class RenderUtil {
  static final Minecraft mc = Minecraft.getMinecraft();
  
  public static void drawHead(EntityPlayer player, float x, float y, float w, float h) {
    NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(player.getUniqueID());
    if (playerInfo != null) {
      mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawScaledCustomSizeModalRect(x, y, 8.0F, 8.0F, 8, 8, w, h, 64.0F, 64.0F);
    } 
  }
  
  public static void drawLines(AxisAlignedBB boundingBox) {
    int i = 3;
    GL11.glPushMatrix();
    GL11.glBegin(i);
    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    GL11.glEnd();
    GL11.glBegin(i);
    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    GL11.glEnd();
    GL11.glBegin(1);
    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    GL11.glEnd();
    GL11.glPopMatrix();
  }
  
  public static void drawBoxFilled(AxisAlignedBB axisAlignedBB) {
    GL11.glBegin(7);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
    GL11.glVertex3d(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glVertex3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    GL11.glEnd();
  }
  
  public static void drawPlatform(Entity entity, Color color) {
    RenderManager renderManager = mc.getRenderManager();
    Timer timer = mc.timer;
    double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * timer.renderPartialTicks - renderManager.renderPosX;
    double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * timer.renderPartialTicks - renderManager.renderPosY;
    double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * timer.renderPartialTicks - renderManager.renderPosZ;
    AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().offset(-entity.posX, -entity.posY, -entity.posZ).offset(d, d2, d3);
  }
  
  public static void drawCircle(double ballX, double ballY, float radius, int sections, int color) {
    double dAngle = 6.283185307179586D / sections;
    GL11.glPushAttrib(8192);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glLineWidth(2.0F);
    GL11.glBegin(6);
    int i;
    for (i = 0; i < sections; i++) {
      float x = (float)(radius * Math.sin(i * dAngle));
      float y = (float)(radius * Math.cos(i * dAngle));
      ColorUtils.glColor(color);
      GL11.glVertex2d(ballX + x, ballY + y);
    } 
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnd();
    GL11.glBegin(2);
    for (i = 0; i < sections; i++) {
      float x = (float)(radius * Math.sin(i * dAngle));
      float y = (float)(radius * Math.cos(i * dAngle));
      ColorUtils.glColor(color);
      GL11.glVertex2d(ballX + x, ballY + y);
    } 
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnd();
    GL11.glPopAttrib();
  }
  
  public static int getRainbow(int x, int y, float saturation) {
    long l = System.currentTimeMillis() - x * 10L - y * 10L;
    return Color.HSBtoRGB((float)(l % 6000L) / 6000.0F, saturation, 1.0F);
  }
  
  public static void drawFullCircle(float cx, float cy, float r, int c) {
    r *= 2.0F;
    cx *= 2.0F;
    cy *= 2.0F;
    float theta = 0.19634953F;
    float p = (float)Math.cos(theta);
    float s = (float)Math.sin(theta);
    float x = r;
    float y = 0.0F;
    GLUtils.pre2D();
    GL11.glEnable(2848);
    GL11.glHint(3154, 4354);
    GL11.glEnable(3024);
    GL11.glScalef(0.5F, 0.5F, 0.5F);
    ColorUtils.glColorInt(c);
    GL11.glBegin(9);
    for (int ii = 0; ii < 32; ii++) {
      GL11.glVertex2f(x + cx, y + cy);
      float t = x;
      x = p * x - s * y;
      y = s * t + p * y;
    } 
    GL11.glEnd();
    GL11.glScalef(2.0F, 2.0F, 2.0F);
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    GLUtils.post2D();
  }
  
  public static void drawGradient(double x, double y, double x2, double y2, int col1, int col2) {
    float f = (col1 >> 24 & 0xFF) / 255.0F;
    float f1 = (col1 >> 16 & 0xFF) / 255.0F;
    float f2 = (col1 >> 8 & 0xFF) / 255.0F;
    float f3 = (col1 & 0xFF) / 255.0F;
    float f4 = (col2 >> 24 & 0xFF) / 255.0F;
    float f5 = (col2 >> 16 & 0xFF) / 255.0F;
    float f6 = (col2 >> 8 & 0xFF) / 255.0F;
    float f7 = (col2 & 0xFF) / 255.0F;
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glShadeModel(7425);
    GL11.glPushMatrix();
    GL11.glBegin(7);
    GL11.glColor4f(f1, f2, f3, f);
    GL11.glVertex2d(x2, y);
    GL11.glVertex2d(x, y);
    GL11.glColor4f(f5, f6, f7, f4);
    GL11.glVertex2d(x, y2);
    GL11.glVertex2d(x2, y2);
    GL11.glEnd();
    GL11.glPopMatrix();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glShadeModel(7424);
  }
  
  public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
    float f = (col1 >> 24 & 0xFF) / 255.0F;
    float f1 = (col1 >> 16 & 0xFF) / 255.0F;
    float f2 = (col1 >> 8 & 0xFF) / 255.0F;
    float f3 = (col1 & 0xFF) / 255.0F;
    float f4 = (col2 >> 24 & 0xFF) / 255.0F;
    float f5 = (col2 >> 16 & 0xFF) / 255.0F;
    float f6 = (col2 >> 8 & 0xFF) / 255.0F;
    float f7 = (col2 & 0xFF) / 255.0F;
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glShadeModel(7425);
    GL11.glPushMatrix();
    GL11.glBegin(7);
    GL11.glColor4f(f1, f2, f3, f);
    GL11.glVertex2d(left, top);
    GL11.glVertex2d(left, bottom);
    GL11.glColor4f(f5, f6, f7, f4);
    GL11.glVertex2d(right, bottom);
    GL11.glVertex2d(right, top);
    GL11.glEnd();
    GL11.glPopMatrix();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glShadeModel(7424);
  }
  
  public static void filledBox(AxisAlignedBB boundingBox, int color, boolean shouldColor) {
    GlStateManager.pushMatrix();
    float var11 = (color >> 24 & 0xFF) / 255.0F;
    float var6 = (color >> 16 & 0xFF) / 255.0F;
    float var7 = (color >> 8 & 0xFF) / 255.0F;
    float var8 = (color & 0xFF) / 255.0F;
    WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
    if (shouldColor)
      GlStateManager.color(var6, var7, var8, var11); 
    byte draw = 7;
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    Tessellator.getInstance().draw();
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    Tessellator.getInstance().draw();
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    Tessellator.getInstance().draw();
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    Tessellator.getInstance().draw();
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    Tessellator.getInstance().draw();
    worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    Tessellator.getInstance().draw();
    GlStateManager.depthMask(true);
    GlStateManager.popMatrix();
  }
  
  public static void drawOutlinedBoundingBox1(AxisAlignedBB boundingBox) {
    Tessellator var1 = Tessellator.getInstance();
    WorldRenderer var2 = var1.getWorldRenderer();
    var2.begin(3, DefaultVertexFormats.POSITION_COLOR);
    var2.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    var1.draw();
    var2.begin(3, DefaultVertexFormats.POSITION_COLOR);
    var2.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    var1.draw();
    var2.begin(1, DefaultVertexFormats.POSITION_COLOR);
    var2.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
    var2.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
    var2.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
    var2.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
    var2.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
    var1.draw();
  }
  
  public static void drawRect(float x, float y, float x1, float y1) {
    GL11.glBegin(7);
    GL11.glVertex2f(x, y1);
    GL11.glVertex2f(x1, y1);
    GL11.glVertex2f(x1, y);
    GL11.glVertex2f(x, y);
    GL11.glEnd();
  }
  
  public static void draw2DImage(ResourceLocation image, float x, float y, float width, float height, Color c) {
    GL11.glDisable(2929);
    GL11.glEnable(3042);
    GL11.glDepthMask(false);
    OpenGlHelper.glBlendFunc(770, 771, 1, 0);
    GL11.glColor4f(c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, c.getAlpha());
    Minecraft.getMinecraft().getTextureManager().bindTexture(image);
    Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
    GL11.glDepthMask(true);
    GL11.glDisable(3042);
    GL11.glEnable(2929);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  }
}
