package animeware.util;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class RenderUtil {
	
	public static void drawChromaString(String string, int x, int y, boolean shadow)
    {
        Minecraft mc = Minecraft.getMinecraft();

        int xTmp = x;
        for (char textChar : string.toCharArray())
        {
            long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
            int i = Color.HSBtoRGB(l % (int) 2000.0F / 2000.0F, 0.8F, 0.8F);
            String tmp = String.valueOf(textChar);
            mc.fontRendererObj.drawString(tmp, xTmp, y, i, shadow);
            xTmp += mc.fontRendererObj.getCharWidth(textChar);
        }
    }
	
	public static void drawHollowRect(int x, int y, int w, int h, int color) {
		
		Gui.drawHorizontalLine(x, x + w, y, color);
		Gui.drawHorizontalLine(x, x + w, y + h, color);
		
		Gui.drawVerticalLine(x, y + h, y, color);
		Gui.drawVerticalLine(x + w, y + h, y, color);
		
	}
	
	

}
