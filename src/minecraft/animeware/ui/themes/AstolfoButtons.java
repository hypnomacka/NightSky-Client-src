package animeware.ui.themes;

import animeware.hud.mod.HudMod;
import animeware.ui.themes.impl.ThemeManager;
import net.minecraft.util.ResourceLocation;

public class AstolfoButtons extends HudMod {

	public AstolfoButtons() {
		super("Astolfo Buttons", "", new ResourceLocation("Animeware/icons/blank.png"), 0, 0);
	}
	@Override
	public void onEnable() {
		ThemeManager.astolfoBtn = true;
       //ClickGUI.setTheme(GUITheme.DARK);
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		ThemeManager.astolfoBtn = false;
		//ClickGUI.setTheme(GUITheme.LIGHT);
		//super.onDisable();
	}

}
