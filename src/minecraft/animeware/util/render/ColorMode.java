package animeware.util.render;

import java.awt.Color;

public class ColorMode {
	
	public static boolean mode = false;
	
	public static boolean getMode() {
		return mode;
	}
	
	public static void setMode(boolean mode) {
		ColorMode.mode = mode;
	}
	
	public static void toggleMode() {
		setMode(!mode);
	}
	
	public static int getBgColor() {
		if(mode) {
			return new Color(90, 90, 90, 180).getRGB();
		}
		if(!mode) {
			return new Color(0, 0, 0, 150).getRGB();
		} else {
			return -1;
		}
	}
	public static int getModColor() {
		if(mode) {
			return new Color(111, 111, 111, 255).getRGB();
		}
		if(!mode) {
			return new Color(0, 0, 0, 255).getRGB();
		} else {
			return -1;
		}
	}
	public static int getClickGuiColor() {
		return new Color(25, 25, 25, 255).getRGB();
	}
	public static int getClickGuiInnerColor() {
		return new Color(50, 50, 50, 255).getRGB();
	}
	public static int getClickGuiMidColor() {
		return new Color(35, 35, 35, 255).getRGB();
	}
	public static int getLoginColor() {
		return new Color(0, 0, 0, 70).getRGB();
	}
	public static int getWhiteColor() {
		return new Color(255, 255, 255, 255).getRGB();
	}
	public static int getRedColor() {
		return new Color(200, 0, 0, 0).getRGB();
	}
	public static int getBGColor() {
		return new Color(200, 200, 200, 100).getRGB();
	}
	public static int getDarkColor() {
		return new Color(0, 0, 0, 170).getRGB();
	}
	public static int getMidDarkColor() {
		return new Color(0, 0, 0, 80).getRGB();
	}
	public static int getSettingButtonAqua() {
		return new Color(0, 200, 230, 255).getRGB();
	}
	public static int getSettingButtonAquaInside() {
		return new Color(0, 140, 180, 255).getRGB();
	}
}
