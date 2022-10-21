package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.BooleanSetting;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class FPSMod extends HudMod {
	
	//public ModeSetting Color = new ModeSetting("Blue", "Cyan", "Purple", "Red");
	//public BooleanSetting White = new BooleanSetting("White", true);
	//public ModeSetting Color = new ModeSetting("Color", "White", "Blue", "Red");
	
	//public BooleanSetting blue = new BooleanSetting("Blue", false);
	//public BooleanSetting cyan = new BooleanSetting("Cyan", false);
	//public BooleanSetting red = new BooleanSetting("Red", false);
	//public BooleanSetting purple = new BooleanSetting("Purple", false);
	//public BooleanSetting chroma = new BooleanSetting("Chroma", false);
	public ModeSetting color1 = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	BooleanSetting invertXSetting = new BooleanSetting(90.0f, 100.0f, "Invert X");
	
	private HudMod hudMod;

	public FPSMod() {
		super("FPS", "Displays fps", new ResourceLocation("Animeware/icons/fps.png"), 0, 1);
		//this.addSettings(Blue);
		//this.addSettings(blue, cyan, red, purple, chroma);
		//this.addSettings(Cyan);
		//this.addSettings(Red);
		//this.addSettings(Purple);
		//this.addSettings(Chroma);
		this.addSettings(color1);
		this.invertXSetting.setEnabled(false);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		//if(Blue.isEnabled()) {
		//fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		//} else {
		
			
		if(color1.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color1.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[FPS:" + mc.getDebugFPS() + "]", getX(), getY(), -1);
		} else if(color1.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		}
			
			//ChromaString.drawChromaString("FPS:" + mc.getDebugFPS() + "]", getX(), getY(), -1);
		//}
		//super.draw();
	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color1.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color1.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color1.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[FPS:" + mc.getDebugFPS() + "]", getX(), getY(), -1);
		} else if(color1.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		}
		//this.drawHollowRect(hudMod.getX(), hudMod.getY(), hudMod.getX() + hudMod.getWidth(), hudMod.getY() + hudMod.getHeight(), 0x33FFFFFF);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	

}

