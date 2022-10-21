package animeware.util.font.JCFont;

import java.awt.Font;
import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class Fonts {
  public static Font getFont(int size, String l) {
    Font font = null;
    try {
      InputStream ex = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("Animeware/font/" + l + ".ttf")).getInputStream();
      font = Font.createFont(0, ex);
      font = font.deriveFont(0, size);
    } catch (Exception var3) {
      var3.printStackTrace();
      System.err.println("Font not loaded.  Using serif font.");
      font = new Font("default", 0, size);
    } 
    return font;
  }
  
  public static cFontRenderer getCustomeFont(int size, String l) {
    return new cFontRenderer(getFont(size, l), true, 8);
  }
}
