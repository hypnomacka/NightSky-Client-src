package animeware.util.render;


import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LINE_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_LINE_SMOOTH_HINT;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_POINT_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_POINT_SMOOTH_HINT;
import static org.lwjgl.opengl.GL11.GL_POLYGON_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_POLYGON_SMOOTH_HINT;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glScissor;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class RenderUtil {
	
	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static Framebuffer createFrameBuffer(Framebuffer framebuffer) {
        if (framebuffer == null || framebuffer.framebufferWidth != mc.displayWidth || framebuffer.framebufferHeight != mc.displayHeight) {
            if (framebuffer != null) {
                framebuffer.deleteFramebuffer();
            }
            return new Framebuffer(mc.displayWidth, mc.displayHeight, true);
        }
        return framebuffer;
    }
	public static void cbLogo(ResourceLocation resourceLocation, float f, float f2, float f3) {
        float f4 = f * 2.0f;
        float f5 = f * 2.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        GL11.glEnable(3042);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        GL11.glBegin(7);
        GL11.glTexCoord2d(f6 / f, f7 / f);
        GL11.glVertex2d(f2, f3);
        GL11.glTexCoord2d(f6 / f, (f7 + f) / f);
        GL11.glVertex2d(f2, f3 + f5);
        GL11.glTexCoord2d((f6 + f) / f, (f7 + f) / f);
        GL11.glVertex2d(f2 + f4, f3 + f5);
        GL11.glTexCoord2d((f6 + f) / f, f7 / f);
        GL11.glVertex2d(f2 + f4, f3);
        //GL11.glRotated(10, f, f2, f3);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    public static void drawImg(ResourceLocation loc, double posX, double posY, double width, double height) {
        mc.getTextureManager().bindTexture(loc);
        float f = 1.0F / (float) width;
        float f1 = 1.0F / (float) height;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(posX, (posY + height), 0.0D).tex(0 * f, ((0 + (float) height) * f1)).endVertex();
        worldrenderer.pos((posX + width), (posY + height), 0.0D).tex((0 + (float) width) * f, (0 + (float) height) * f1).endVertex();
        worldrenderer.pos((posX + width), posY, 0.0D).tex((0 + (float) width) * f, 0 * f1).endVertex();
        worldrenderer.pos(posX, posY, 0.0D).tex(0 * f, 0 * f1).endVertex();
        tessellator.draw();
    }
    public static void resetColor() {
        GlStateManager.color(1, 1, 1, 1);
    }
    public static void color(int color, float alpha) {
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        GlStateManager.color(r, g, b, alpha);
    }

    // Colors the next texture without a specified alpha value
    public static void color(int color) {
        color(color, (float) (color >> 24 & 255) / 255.0F);
    }

    public static void drawGradientRect(double left, double top, double right, double bottom, int startColor, int endColor) {
        float f = (float) (startColor >> 24 & 255) / 255.0F;
        float f1 = (float) (startColor >> 16 & 255) / 255.0F;
        float f2 = (float) (startColor >> 8 & 255) / 255.0F;
        float f3 = (float) (startColor & 255) / 255.0F;
        float f4 = (float) (endColor >> 24 & 255) / 255.0F;
        float f5 = (float) (endColor >> 16 & 255) / 255.0F;
        float f6 = (float) (endColor >> 8 & 255) / 255.0F;
        float f7 = (float) (endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(right, top, 0.0D).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos(left, top, 0.0D).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos(left, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void startSmooth() {
        glEnable(GL_LINE_SMOOTH);
        glEnable(GL_POLYGON_SMOOTH);
        glEnable(GL_POINT_SMOOTH);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        glHint(GL_POLYGON_SMOOTH_HINT, GL_NICEST);
        glHint(GL_POINT_SMOOTH_HINT, GL_NICEST);
    }

    public static void endSmooth() {
        glDisable(GL_LINE_SMOOTH);
        glDisable(GL_POLYGON_SMOOTH);
        glEnable(GL_POINT_SMOOTH);
    }

    public static Color fade(final Color color, int index, int count) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);

        float brightness = Math.abs((((System.currentTimeMillis() % 2000) / 1000F + (index / (float) count) * 2F) % 2F) - 1);
        brightness = 0.5f + (0.5f * brightness);

        hsb[2] = brightness % 2F;
        return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
    }

    public static void scissor(double x, double y, double width, double height) {
        ScaledResolution sr = new ScaledResolution(mc);
        final double scale = sr.getScaleFactor();

        y = sr.getScaledHeight() - y;

        x *= scale;
        y *= scale;
        width *= scale;
        height *= scale;

        glScissor((int) x, (int) (y - height), (int) width, (int) height);
    }

    public static int getOppositeColor(int color) {
        int R = color & 255;
        int G = (color >> 8) & 255;
        int B = (color >> 16) & 255;
        int A = (color >> 24) & 255;
        R = 255 - R;
        G = 255 - G;
        B = 255 - B;
        return R + (G << 8) + (B << 16) + (A << 24);
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
      public static void scissor(int x, int y, int x2, int y2) {
    	  GL11.glScissor(x * new ScaledResolution(mc).getScaleFactor(), 
    			  (new ScaledResolution(mc).getScaledHeight() - y2) * new ScaledResolution(mc).getScaleFactor(), 
    			  (x2 - x) * new ScaledResolution(mc).getScaleFactor(), 
    			  (y2 - y) * new ScaledResolution(mc).getScaleFactor());
      }
      public static void scissor2(int x, int y, int x2, int y2) {
    	  GL11.glScissor(x * new ScaledResolution(mc).getScaleFactor(), 
    			  (new ScaledResolution(mc).getScaledHeight() - y2) * new ScaledResolution(mc).getScaleFactor(), 
    			  (x - x2) * new ScaledResolution(mc).getScaleFactor(), 
    			  (y - y2) * new ScaledResolution(mc).getScaleFactor());
      }

}