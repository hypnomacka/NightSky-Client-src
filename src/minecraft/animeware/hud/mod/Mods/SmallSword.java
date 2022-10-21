package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class SmallSword extends HudMod {

	public SmallSword() {
		super("SmallSword", "Makes held items small", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.SmallSword = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.SmallSword = false;
		//super.onDisable();
	}

}
