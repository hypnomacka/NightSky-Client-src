package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

public class Ping extends HudMod{

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public Ping() {
		super("Ping", "Displays ping", new ResourceLocation("Animeware/icons/glacier/ping.png"), 0, 41);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				fr.drawStringWithShadow("§8[§1Ping:§f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms§8]", getX(), getY(), -1);
				} else {
					fr.drawStringWithShadow("§8[§1Ping:§f00ms§8]", getX(), getY(), -1);
				}			
		} else if(color.getMode().equals("Cyan")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				fr.drawStringWithShadow("§8[§bPing:§f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms§8]", getX(), getY(), -1);
				} else {
					fr.drawStringWithShadow("§8[§bPing:§f00ms§8]", getX(), getY(), -1);
				}
		} else if(color.getMode().equals("Red")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				fr.drawStringWithShadow("§8[§4Ping:§f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms§8]", getX(), getY(), -1);
				} else {
					fr.drawStringWithShadow("§8[§4Ping:§f00ms§8]", getX(), getY(), -1);
				}
		} else if(color.getMode().equals("Purple")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				fr.drawStringWithShadow("§8[§5Ping:§f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms§8]", getX(), getY(), -1);
				} else {
					fr.drawStringWithShadow("§8[§5Ping:§f00ms§8]", getX(), getY(), -1);
				}
		} else if(color.getMode().equals("Chroma")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				ChromaString.drawChromaString("[Ping:" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms]", getX(), getY(), -1);
			} else {
				ChromaString.drawChromaString("[Ping:00ms]", getX(), getY(), -1);
			}
		} else if(color.getMode().equals("White")) {
			if(!MinecraftServer.getServer().isSinglePlayer()) {
				fr.drawStringWithShadow("§8[§fPing:§f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime() + "ms§8]", getX(), getY(), -1);
				} else {
					fr.drawStringWithShadow("§8[§fPing:§f00ms§8]", getX(), getY(), -1);
				}
		}
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("§8[§fPing:§f00ms§8]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("§8[§fPing:§f00ms§8]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
