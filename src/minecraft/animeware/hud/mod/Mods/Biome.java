package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class Biome extends HudMod{
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");
	
	public Biome() {
		super("Biome", "Displays what biome you are in", new ResourceLocation("Animeware/icons/xyz.png"), 0, 51);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1Biome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bBiome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4Biome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5Biome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);
			} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[Biome: " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fBiome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);
		}
		
		//fr.drawStringWithShadow("§8[§fBiome:§f " + mc.theWorld.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName + "§8]", getX(), getY(), -1);
		super.draw();
	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("§8[§fBiome:§f " + "Taiga" + "§8]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("§8[§fBiome:§f " + "BiomeBio" + "§8]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}