package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import optifine.Config;

public class PackDisplay extends HudMod {

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public PackDisplay() {
		super("PackDisplay", "Shows active pack", new ResourceLocation("Animeware/icons/packoverlay.png"), 0, 71);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		String pack = "";
		if(!Config.getResourcePackNames().equalsIgnoreCase("default"))
			pack = Config.getResourcePackNames().split(",")[Config.getResourcePacks().length -1];
        else
            pack = "default";
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			if(!Config.getResourcePackNames().equals("default")) {
				fr.drawStringWithShadow("§8[§1Pack:§f " + pack + "§8]", getX(), getY(), -1);
			} else {
				fr.drawStringWithShadow("", getX(), getY(), -1);
			}			
		} else if(color.getMode().equals("Cyan")) {
			if(!Config.getResourcePackNames().equals("default")) {
				fr.drawStringWithShadow("§8[§bPack:§f " + pack + "§8]", getX(), getY(), -1);
			} else {
				fr.drawStringWithShadow("", getX(), getY(), -1);
			}
		} else if(color.getMode().equals("Red")) {
			if(!Config.getResourcePackNames().equals("default")) {
				fr.drawStringWithShadow("§8[§4Pack:§f " + pack + "§8]", getX(), getY(), -1);
			} else {
				fr.drawStringWithShadow("", getX(), getY(), -1);
			}
		} else if(color.getMode().equals("Purple")) {
			if(!Config.getResourcePackNames().equals("default")) {
				fr.drawStringWithShadow("§8[§4Pack:§f " + pack + "§8]", getX(), getY(), -1);
			} else {
				fr.drawStringWithShadow("", getX(), getY(), -1);
			}
		} else if(color.getMode().equals("Chroma")) {
			if(!Config.getResourcePackNames().equals("default")) {
				ChromaString.drawChromaString("[Pack: " + pack + "]", getX(), getY(), -1);
			} else {
				ChromaString.drawChromaString("", getX(), getY(), -1);
			}
		} else if(color.getMode().equals("White")) {
			if(!Config.getResourcePackNames().equals("default")) {
				fr.drawStringWithShadow("§8[§fPack: " + pack + "§8]", getX(), getY(), -1);
			} else {
				fr.drawStringWithShadow("", getX(), getY(), -1);
			}
		}
		
		
		super.draw();
	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("§8[§fPack: Uchiha Pack§8]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		String pack = "";
		if(!Config.getResourcePackNames().equalsIgnoreCase("default"))
			pack = Config.getResourcePackNames().split(",")[Config.getResourcePacks().length -1];
        else
            pack = "default";
		return fr.getStringWidth("§8[§fPack: " + pack + "§8]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}	
}
