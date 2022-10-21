package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.event.EventTarget;
import animeware.event.impl.EventUpdate;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class TimeChanger extends HudMod {

	public TimeChanger() {
		super("TimeChanger", "Changes world time", new ResourceLocation("Animeware/icons/glacier/timechanger.png"), 0, 0);
	}
	
	@Override
	public void onEnable() {
		
		
		
		
       Booleans.timechanger = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		//mc.thePlayer.setSprinting(false);
		
	  Booleans.timechanger = false;
		//super.onDisable();
	}

}
