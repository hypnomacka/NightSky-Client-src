package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class ServerIP extends HudMod{
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public ServerIP() {
		super("ServerIP", "Displays server ip", new ResourceLocation("Animeware/icons/servers.png"), 0, 21);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		String address = "Singleplayer";
        if( Minecraft.getMinecraft().getCurrentServerData() != null) {
            address = Minecraft.getMinecraft().getCurrentServerData().serverIP;
        }
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1IP:§f" + address + "§8]", getX(), getY(), -1);		
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bIP:§f" + address + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4IP:§f" + address + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5IP:§f" + address + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[IP:" + address + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fIP:§f" + address + "§8]", getX(), getY(), -1);
		}
		super.draw();
	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("§8[§fIP:§fhypixel.net§8]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		String address = "Singleplayer";
        if( Minecraft.getMinecraft().getCurrentServerData() != null) {
            address = Minecraft.getMinecraft().getCurrentServerData().serverIP;
        }
		return fr.getStringWidth("§8[§fIP:§f" + address + "§8]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
