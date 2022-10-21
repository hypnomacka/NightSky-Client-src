package animeware.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

public class GLUtils {
  public static void pre2D() {
    GL11.glDisable(2929);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glDepthMask(true);
    GL11.glEnable(2848);
    GL11.glHint(3154, 4354);
    GL11.glHint(3155, 4354);
  }
  
  public static void post2D() {
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glEnable(2929);
    GL11.glDisable(2848);
    GL11.glHint(3154, 4352);
    GL11.glHint(3155, 4352);
  }
  
  public static void pre3D() {
    GL11.glPushMatrix();
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    GL11.glShadeModel(7425);
    GL11.glDisable(3553);
    GL11.glEnable(2848);
    GL11.glDisable(2929);
    GL11.glDisable(2896);
    GL11.glDepthMask(false);
    GL11.glHint(3154, 4354);
  }
  
  public static void post3D() {
    GL11.glDepthMask(true);
    GL11.glEnable(2929);
    GL11.glDisable(2848);
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glPopMatrix();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  }
  
  public static void makeScissorBox(float x, float y, float x2, float y2) {
    ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
    int factor = scaledResolution.getScaleFactor();
    GL11.glScissor((int)(x * factor), (int)((scaledResolution.getScaledHeight() - y2) * factor), (int)((x2 - x) * factor), (int)((y2 - y) * factor));
  }
  public static void render(int mode, Runnable render){
      glBegin(mode);
      render.run();
      glEnd();
  }
  public static void setup2DRendering(Runnable f) {
      glEnable(GL_BLEND);
      glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
      glDisable(GL_TEXTURE_2D);
      f.run();
      glEnable(GL_TEXTURE_2D);
      GlStateManager.disableBlend();
  }
}
