package animeware.util.render;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

public class ColorUtils {
  static Minecraft mc = Minecraft.getMinecraft();
  
  static FontRenderer fr = mc.fontRendererObj;
  
  public static void glColor(int hex) {
    float alpha = (hex >> 24 & 0xFF) / 255.0F;
    float red = (hex >> 16 & 0xFF) / 255.0F;
    float green = (hex >> 8 & 0xFF) / 255.0F;
    float blue = (hex & 0xFF) / 255.0F;
    GL11.glColor4f(red, green, blue, alpha);
  }
  
  public static Color getColor(int red, int green, int blue, int alpha) {
    int color = 0;
    color |= alpha << 24;
    color |= red << 16;
    color |= green << 8;
    color |= blue;
    return new Color(red, green, blue, alpha);
  }
  
  public static int astolfoColors(int yOffset, int yTotal) {
    float speed = 2900.0F;
    float hue = (float)(System.currentTimeMillis() % (int)speed) + ((yTotal - yOffset) * 9);
    while (hue > speed)
      hue -= speed; 
    hue /= speed;
    if (hue > 0.5D)
      hue = 0.5F - hue - 0.5F; 
    hue += 0.5F;
    return Color.HSBtoRGB(hue, 0.5F, 1.0F);
  }
  
  public static int astolfoColors(int yOffset, int yTotal, long index) {
    float speed = 10000.0F;
    float hue = (float)((System.currentTimeMillis() + index) % (int)speed) + ((yTotal - yOffset) * 9);
    while (hue > speed)
      hue -= speed; 
    hue /= speed;
    if (hue > 0.5D)
      hue = 0.5F - hue - 0.5F; 
    hue += 0.5F;
    return Color.HSBtoRGB(hue, 0.6F, 1.0F);
  }
  
  public static int rainbowWawe(int delay) {
    AtomicInteger ColorIndex = new AtomicInteger();
    int clrd = ColorIndex.get() / delay;
    ColorIndex.getAndIncrement();
    return rainbowColor(clrd);
  }
  
  public static int rainbowStatic(int delay) {
    return rainbowColor(delay);
  }
  
  public static int rainbowColor(int delay) {
    double rainbowState = Math.ceil(((System.currentTimeMillis() + delay) / 10L));
    rainbowState %= 360.0D;
    return Color.getHSBColor((float)(rainbowState / 360.0D), 1.0F, 1.0F).getRGB();
  }
  
  public static Color rainbowColor2(int delay) {
    double rainbowState = Math.ceil(((System.currentTimeMillis() + delay) / 40L));
    rainbowState %= 360.0D;
    return Color.getHSBColor((float)(rainbowState / 360.0D), 1.0F, 1.0F);
  }
  
  public static void glColor(Color color) {
    GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
  }
  
  public static void glColorInt(int hex) {
    float alpha = (hex >> 24 & 0xFF) / 255.0F;
    float red = (hex >> 16 & 0xFF) / 255.0F;
    float green = (hex >> 8 & 0xFF) / 255.0F;
    float blue = (hex & 0xFF) / 255.0F;
    GL11.glColor4f(red, green, blue, alpha);
  }
  
  public static Color transition(Color c1, Color c2, double prog) {
    double progress = (prog > 1.0D) ? 1.0D : ((prog < 0.0D) ? 0.0D : prog);
    int redDiff = c1.getRed() - c2.getRed();
    int greenDiff = c1.getGreen() - c2.getGreen();
    int blueDiff = c1.getBlue() - c2.getBlue();
    int alphaDiff = c1.getAlpha() - c2.getAlpha();
    int newRed = (int)(c2.getRed() + redDiff * progress);
    int newGreen = (int)(c2.getGreen() + greenDiff * progress);
    int newBlue = (int)(c2.getBlue() + blueDiff * progress);
    int newAlpha = (int)(c2.getAlpha() + alphaDiff * progress);
    return new Color(newRed, newGreen, newBlue, newAlpha);
  }
  
  public static Color getColorFromInt(int col1) {
    float f = (col1 >> 24 & 0xFF) / 255.0F;
    float f1 = (col1 >> 16 & 0xFF) / 255.0F;
    float f2 = (col1 >> 8 & 0xFF) / 255.0F;
    return new Color(f, f1, f2);
  }
  
  public static void drawChromaString(String string, int x, int y, boolean shadow) {
    Minecraft mc = Minecraft.getMinecraft();
    int xTmp = x;
    byte b;
    int i;
    char[] arrayOfChar;
    for (i = (arrayOfChar = string.toCharArray()).length, b = 0; b < i; ) {
      char textChar = arrayOfChar[b];
      long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
      int j = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
      String tmp = String.valueOf(textChar);
      mc.fontRendererObj.drawString(tmp, xTmp, y, j, shadow);
      xTmp += mc.fontRendererObj.getCharWidth(textChar);
      b++;
    } 
  }
}
