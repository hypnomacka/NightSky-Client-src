package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class TNTTimer extends HudMod {

	public TNTTimer() {
		super("TNTTimer", "Displays time until TNT explodes", new ResourceLocation("Animeware/icons/timedisplay.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.TNTTimer = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.TNTTimer = false;
		//super.onDisable();
	}
	@Override
	public int getWidth() {
		return 0;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}

}
