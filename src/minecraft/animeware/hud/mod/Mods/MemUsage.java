package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class MemUsage extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;

    public MemUsage() {
		super("Memory", "Memory usage", new ResourceLocation("Animeware/icons/ram.png"), 50, 137);
		this.addSettings(color);
	}

    @Override
    public int getWidth() {
        Runtime runtime = Runtime.getRuntime();
        String str = "Mem: " + (runtime.totalMemory() - runtime.freeMemory()) * 100L / runtime.maxMemory() + "% ";
        return fr.getStringWidth(str) + 8;
    }

    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT + 9;
    }

    @Override
    public void draw() {
        //Gui.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 50).getRGB());
    	Gui.drawRect(getX() + 3, getY() + 3, getX() + getWidth() - 5, getY() + getHeight() - 4, new Color(0, 0, 0, 170).getRGB());
        
        Runtime runtime = Runtime.getRuntime();
        String str = "Mem: " + (runtime.totalMemory() - runtime.freeMemory()) * 100L / runtime.maxMemory() + "% ";
        
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§1" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§b" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§5" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString(str, getX() + 6, getY() + 5, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow(str, getX() + 6, getY() + 5, -1);
		}
        
        
    }
    
    @Override
    public void renderDummy(int mouseX, int mouseY) {
        Runtime runtime = Runtime.getRuntime();
        String str = "Mem: " + (runtime.totalMemory() - runtime.freeMemory()) * 100L / runtime.maxMemory() + "% ";
        
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§1" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§b" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§5" + str, getX() + 6, getY() + 5, -1);
			//fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString(str, getX() + 6, getY() + 5, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow(str, getX() + 6, getY() + 5, -1);
		}
        super.renderDummy(mouseX, mouseY);
    }

}