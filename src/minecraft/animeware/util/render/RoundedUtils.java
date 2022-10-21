package animeware.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

public class RoundedUtils {
  static final Minecraft mc = Minecraft.getMinecraft();
  
  static final FontRenderer fr = mc.fontRendererObj;
  
  public static void enableGL2D() {
    GL11.glDisable(2929);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glDepthMask(true);
    GL11.glEnable(2848);
    GL11.glHint(3154, 4354);
    GL11.glHint(3155, 4354);
  }
  
  public static void disableGL2D() {
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glEnable(2929);
    GL11.glDisable(2848);
    GL11.glHint(3154, 4352);
    GL11.glHint(3155, 4352);
  }
  
  public static void drawSmoothRoundedRect(float x, float y, float x1, float y1, float radius, int color) {
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glEnable(2848);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glBegin(9);
    int i;
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    GL11.glEnd();
    GL11.glBegin(2);
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
  }
  
  public static void drawRoundedRect(float x, float y, float x1, float y1, float radius, int color) {
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glEnable(2848);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glBegin(9);
    int i;
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
  }
  
  public static void drawRoundedOutline(float x, float y, float x1, float y1, float radius, float lineWidth, int color) {
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glLineWidth(lineWidth);
    GL11.glBegin(2);
    int i;
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius); 
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
  }
  
  public static void drawSelectRoundedRect(float x, float y, float x1, float y1, float radius1, float radius2, float radius3, float radius4, int color) {
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glBegin(9);
    int i;
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius1) + Math.sin(i * Math.PI / 180.0D) * radius1 * -1.0D, (y + radius1) + Math.cos(i * Math.PI / 180.0D) * radius1 * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius2) + Math.sin(i * Math.PI / 180.0D) * radius2 * -1.0D, (y1 - radius2) + Math.cos(i * Math.PI / 180.0D) * radius2 * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius3) + Math.sin(i * Math.PI / 180.0D) * radius3, (y1 - radius3) + Math.cos(i * Math.PI / 180.0D) * radius3); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius4) + Math.sin(i * Math.PI / 180.0D) * radius4, (y + radius4) + Math.cos(i * Math.PI / 180.0D) * radius4); 
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
  }
  
  public static void drawSelectRoundedOutline(float x, float y, float x1, float y1, float radius1, float radius2, float radius3, float radius4, float lineWidth, int color) {
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glLineWidth(lineWidth);
    GL11.glBegin(2);
    int i;
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x + radius1) + Math.sin(i * Math.PI / 180.0D) * radius1 * -1.0D, (y + radius1) + Math.cos(i * Math.PI / 180.0D) * radius1 * -1.0D); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x + radius2) + Math.sin(i * Math.PI / 180.0D) * radius2 * -1.0D, (y1 - radius2) + Math.cos(i * Math.PI / 180.0D) * radius2 * -1.0D); 
    for (i = 0; i <= 90; i += 3)
      GL11.glVertex2d((x1 - radius3) + Math.sin(i * Math.PI / 180.0D) * radius3, (y1 - radius3) + Math.cos(i * Math.PI / 180.0D) * radius3); 
    for (i = 90; i <= 180; i += 3)
      GL11.glVertex2d((x1 - radius4) + Math.sin(i * Math.PI / 180.0D) * radius4, (y + radius4) + Math.cos(i * Math.PI / 180.0D) * radius4); 
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
  }
  
  public static void setColor(int color) {
    float a = (color >> 24 & 0xFF) / 255.0F;
    float r = (color >> 16 & 0xFF) / 255.0F;
    float g = (color >> 8 & 0xFF) / 255.0F;
    float b = (color & 0xFF) / 255.0F;
    GL11.glColor4f(r, g, b, a);
  }
  
  public static void drawRoundedGradientRectCorner(float x, float y, float x1, float y1, float radius, int color, int color2, int color3, int color4) {
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glShadeModel(7425);
    GL11.glPushAttrib(0);
    GL11.glScaled(0.5D, 0.5D, 0.5D);
    x = (float)(x * 2.0D);
    y = (float)(y * 2.0D);
    x1 = (float)(x1 * 2.0D);
    y1 = (float)(y1 * 2.0D);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    setColor(color);
    GL11.glEnable(2848);
    GL11.glShadeModel(7425);
    GL11.glBegin(9);
    int i;
    for (i = 0; i <= 90; i += 3)
      setColor(color); 
    GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
    for (i = 90; i <= 180; i += 3)
      setColor(color2); 
    GL11.glVertex2d((x + radius) + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
    for (i = 0; i <= 90; i += 3)
      setColor(color3); 
    GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y1 - radius) + Math.cos(i * Math.PI / 180.0D) * radius);
    for (i = 90; i <= 180; i += 3)
      setColor(color4); 
    GL11.glVertex2d((x1 - radius) + Math.sin(i * Math.PI / 180.0D) * radius, (y + radius) + Math.cos(i * Math.PI / 180.0D) * radius);
    GL11.glEnd();
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glScaled(2.0D, 2.0D, 2.0D);
    GL11.glPopAttrib();
    GL11.glLineWidth(1.0F);
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glShadeModel(7424);
  }
}
