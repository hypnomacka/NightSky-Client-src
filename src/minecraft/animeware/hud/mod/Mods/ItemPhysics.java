package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class ItemPhysics extends HudMod {

	public ItemPhysics() {
		super("ItemPhysics", "Adds physics to your items", new ResourceLocation("Animeware/icons/itemphysics.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.itemphys = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.itemphys = false;
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
