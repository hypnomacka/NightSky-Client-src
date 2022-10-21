package animeware.util;

import java.awt.Color;

public class RainbowColor
{


    public static Color rainbowColor(int value)
    {
        Color clr = Color.getHSBColor(System.currentTimeMillis() % value * value, 1.0F, 1.0F);
        return clr;
    }

    public static Color colorLerpv2(Color start, Color end, float ratio)
    {
        int i = (int)Math.abs(ratio * (float)start.getRed() + (1.0F - ratio) * (float)end.getRed());
        int j = (int)Math.abs(ratio * (float)start.getGreen() + (1.0F - ratio) * (float)end.getGreen());
        int k = (int)Math.abs(ratio * (float)start.getBlue() + (1.0F - ratio) * (float)end.getBlue());
        return new Color(i, j, k);
    }
}
