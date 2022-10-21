package animeware.util.render.theme;


import com.google.gson.annotations.Expose;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class Theme {
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	public String name;
	public double version;
	public ResourceLocation mainMenuBg;
	public int mainColor;
	public int secondaryColor;
	
	public Theme(String name, double version, ResourceLocation mainMenuBg, int mainColor, int secondaryColor) {
		this.name = name;
		this.version = version;
		this.mainMenuBg = mainMenuBg;
		this.mainColor = mainColor;
		this.secondaryColor = secondaryColor;
	}

	public String getName() {
		return name;
	}

	public double getVersion() {
		return version;
	}

	public ResourceLocation getMainMenuBg() {
		return mainMenuBg;
	}

	public int getMainColor() {
		return mainColor;
	}
	
	public int getSecondaryColor() {
		return secondaryColor;
	}
}
