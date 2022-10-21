package animeware.util.render;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiUtils {
  static final Minecraft mc = Minecraft.getMinecraft();
  
  static final FontRenderer fr = mc.fontRendererObj;
  
  public static Color brandingForegroundColor = new Color(255, 255, 255, 30),
          brandingForegroundOutline = new Color(255, 255, 255, 150),
          brandingBackgroundColor = new Color(0, 0, 0, 100),
          brandingSecondBackgroundColor =new Color(175, 175, 175, 26),
          brandingIconColor = new Color(255, 255, 255, 150),

          brandingEnabledColor = new Color(101, 220, 138, 200),
          brandingDisabledColor = new Color(248, 92, 92, 200);
  
  public static void drawChromaString(String string, int x, int y, boolean shadow) {
    int xTmp = x;
    for (char textChar : string.toCharArray()) {
      long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
      int i = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
      String tmp = String.valueOf(textChar);
      mc.fontRendererObj.drawString(tmp, xTmp, y, i, shadow);
      xTmp += mc.fontRendererObj.getCharWidth(textChar);
    } 
  }
  
  public static int chromaColor() {
    int i = Color.HSBtoRGB((float)(System.currentTimeMillis() % 2000L) / 2000.0F, 0.8F, 0.8F);
    return i;
  }
  
  
  
  
  
  
  
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
  
  public static void bindTexture(ResourceLocation resourceLocation) {
      ITextureObject texture = Minecraft.getMinecraft().getTextureManager().getTexture(resourceLocation);
      if (texture == null) {
          texture = new SimpleTexture(resourceLocation);
          Minecraft.getMinecraft().getTextureManager().loadTexture(resourceLocation, texture);
      }
      GL11.glBindTexture(3553, texture.getGlTextureId());
  }
  
  public static void drawTexture(ResourceLocation resourceLocation, float x, float y, float width, float height) {
      GL11.glPushMatrix();
      float size = width / 2.0f;
      GL11.glEnable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2848);
      GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
      GuiUtils.bindTexture(resourceLocation);
      GL11.glBegin(7);
      GL11.glTexCoord2d(0.0f / size, 0.0f / size);
      GL11.glVertex2d(x, y);
      GL11.glTexCoord2d(0.0f / size, (0.0f + size) / size);
      GL11.glVertex2d(x, y + height);
      GL11.glTexCoord2d((0.0f + size) / size, (0.0f + size) / size);
      GL11.glVertex2d(x + width, y + height);
      GL11.glTexCoord2d((0.0f + size) / size, 0.0f / size);
      GL11.glVertex2d(x + width, y);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
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
  }
  
  public static void drawRoundedRect(float x, float y, float x1, float y1, float radius, int color) {
    GL11.glPushAttrib(0);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
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
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glDisable(2848);
    GL11.glShadeModel(7424);
  }
  
  
  
  public static int glToRGB(float red, float green, float blue, float alpha) {
    return (new Color((int)red * 255, (int)green * 255, (int)blue * 255, (int)alpha * 255)).getRGB();
  }
  
  public static float rgbToGl(int rgb) {
    return rgb / 255.0F;
  }
  
  public static void setGlColor(int color) {
    float alpha = (color >> 24 & 0xFF) / 255.0F;
    float red = (color >> 16 & 0xFF) / 255.0F;
    float green = (color >> 8 & 0xFF) / 255.0F;
    float blue = (color & 0xFF) / 255.0F;
    GlStateManager.color(red, green, blue, alpha);
  }
  
  public static void setGlColor(int color, float alpha) {
    float red = (color >> 16 & 0xFF) / 255.0F;
    float green = (color >> 8 & 0xFF) / 255.0F;
    float blue = (color & 0xFF) / 255.0F;
    GlStateManager.color(red, green, blue, alpha);
  }
  
  public static int getRGB(int color, int alpha) {
    return (new Color(color >> 16 & 0xFF, color >> 8 & 0xFF, color & 0xFF, alpha)).getRGB();
  }
  
  public static Color getColor(int color) {
    return new Color(color, true);
  }
  
  public static int getAlpha(int color) {
    return color >> 24 & 0xFF;
  }
  
  public static int hsvToRgb(int hue, int saturation, int value) {
    float m;
    hue %= 360;
    float s = saturation / 100.0F;
    float v = value / 100.0F;
    float c = v * s;
    float h = hue / 60.0F;
    float x = c * (1.0F - Math.abs(h % 2.0F - 1.0F));
    float r = 0.0F;
    float g = 0.0F;
    float b = 0.0F;
    switch (hue / 60) {
      case 0:
        r = c;
        g = x;
        b = 0.0F;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
      case 1:
        r = x;
        g = c;
        b = 0.0F;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
      case 2:
        r = 0.0F;
        g = c;
        b = x;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
      case 3:
        r = 0.0F;
        g = x;
        b = c;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
      case 4:
        r = x;
        g = 0.0F;
        b = c;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
      case 5:
        r = c;
        g = 0.0F;
        b = x;
        m = v - c;
        return (int)((r + m) * 255.0F) << 16 | (int)((g + m) * 255.0F) << 8 | (int)((b + m) * 255.0F);
    } 
    return 0;
  }
  
  public static int[] rgbToHsv(int rgb) {
    float h, r = ((rgb & 0xFF0000) >> 16) / 255.0F;
    float g = ((rgb & 0xFF00) >> 8) / 255.0F;
    float b = (rgb & 0xFF) / 255.0F;
    float M = (r > g) ? Math.max(r, b) : Math.max(g, b);
    float m = (r < g) ? Math.min(r, b) : Math.min(g, b);
    float c = M - m;
    if (M == r) {
      for (h = (g - b) / c; h < 0.0F; h += 6.0F);
      h %= 6.0F;
    } else if (M == g) {
      h = (b - r) / c + 2.0F;
    } else {
      h = (r - g) / c + 4.0F;
    } 
    h *= 60.0F;
    float s = c / M;
    return new int[] { (c == 0.0F) ? -1 : (int)h, (int)(s * 100.0F), (int)(M * 100.0F) };
  }
  
  public static int getIntermediateColor(int a, int b, float percent) {
    float avgRed = (a >> 16 & 0xFF) * percent + (b >> 16 & 0xFF) * (1.0F - percent);
    float avgGreen = (a >> 8 & 0xFF) * percent + (b >> 8 & 0xFF) * (1.0F - percent);
    float avgBlue = (a >> 0 & 0xFF) * percent + (b >> 0 & 0xFF) * (1.0F - percent);
    float avgAlpha = (a >> 24 & 0xFF) * percent + (b >> 24 & 0xFF) * (1.0F - percent);
    try {
      return (new Color(avgRed / 255.0F, avgGreen / 255.0F, avgBlue / 255.0F, avgAlpha / 255.0F)).getRGB();
    } catch (IllegalArgumentException e) {
      return Integer.MIN_VALUE;
    } 
  }
  
  public static int convertPercentToValue(float percent) {
    return (int)(percent * 255.0F);
  }
  
  public static void scissorHelper(int x1, int y1, int x2, int y2) {
    x2 -= x1;
    y2 -= y1;
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution resolution = new ScaledResolution(mc);
    GL11.glScissor(x1 * resolution.getScaleFactor(), mc.displayHeight - y1 * resolution
        .getScaleFactor() - y2 * resolution.getScaleFactor(), x2 * resolution
        .getScaleFactor(), y2 * resolution
        .getScaleFactor());
  }
}
