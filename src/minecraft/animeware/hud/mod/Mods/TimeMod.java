package animeware.hud.mod.Mods;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class TimeMod extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
    public TimeMod() {
		super("TimeMod", "Displays real time", new ResourceLocation("Animeware/icons/timedisplay.png"), 0, 61);
		this.addSettings(color);
	}

	@Override
    public void draw() {
  
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime);
        //Minecraft.getMinecraft().fontRendererObj.drawString(time, getX(), getY(), -1);
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§8[§1" + time + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§b" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[" + time + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§f" + time + "§8]", getX(), getY(), -1);
		}
        
    }
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime);
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§8[§1" + time + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§b" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5" + time + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[" + time + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§f" + time + "§8]", getX(), getY(), -1);
		}
		super.renderDummy(mouseX, mouseY);
	}

    @Override
    public int getWidth() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime);
    	return fr.getStringWidth("§8[§f" + time + "§8]");
    }

    @Override
    public int getHeight() {
        return 10;
    }
}
