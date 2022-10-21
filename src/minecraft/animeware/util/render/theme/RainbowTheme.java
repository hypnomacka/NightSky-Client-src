package animeware.util.render.theme;

import java.awt.Color;

import animeware.util.render.ColorUtil;
import net.minecraft.util.ResourceLocation;

public class RainbowTheme extends Theme {

	public RainbowTheme() {
		super("Raindbow", 0.1, new ResourceLocation("Animeware/background/old/bg5.png"), ColorUtil.getRGB(7, 0.9f, 1, 100), -1);
	}
	
	@Override
	public int getMainColor() {
		float hue = ((System.currentTimeMillis() + 100) % (int)(4 * 1000)) / (float)(4 * 1000);
		int color = new Color(255, 254, 255, 255).getRGB();//Color.HSBtoRGB(hue, 0.9f, 1);
		return color;
	}

}
