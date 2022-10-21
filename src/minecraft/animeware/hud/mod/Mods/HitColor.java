package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import animeware.util.settings.ModeSetting;
import net.minecraft.util.ResourceLocation;

public class HitColor extends HudMod {

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public HitColor() {
		super("HitColor", "Changes hit color", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
		this.addSettings(color);
	}
	@Override
	public void onEnable() {
		if(color.getMode().equals("Blue")) {
			Booleans.HitColorBlue = true;			
		} else if(color.getMode().equals("Cyan")) {
			Booleans.HitColorCyan = true;
		} else if(color.getMode().equals("Red")) {
			Booleans.HitColorRed = true;
		} else if(color.getMode().equals("Purple")) {
			Booleans.HitColorPurple = true;
		} else if(color.getMode().equals("Chroma")) {
			Booleans.HitColorChroma = true;
		} else if(color.getMode().equals("White")) {
			Booleans.HitColor = true;
		}
       
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		if(color.getMode().equals("Blue")) {
			Booleans.HitColorBlue = false;			
		} else if(color.getMode().equals("Cyan")) {
			Booleans.HitColorCyan = false;
		} else if(color.getMode().equals("Red")) {
			Booleans.HitColorRed = false;
		} else if(color.getMode().equals("Purple")) {
			Booleans.HitColorPurple = false;
		} else if(color.getMode().equals("Chroma")) {
			Booleans.HitColorChroma = false;
		} else if(color.getMode().equals("White")) {
			Booleans.HitColor = false;
		}
	  
		//super.onDisable();
	}

}
