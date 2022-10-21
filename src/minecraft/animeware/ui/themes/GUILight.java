package animeware.ui.themes;

import animeware.gui.clickgui.ClickGUI;
import animeware.gui.clickgui.GUITheme;
import animeware.hud.mod.HudMod;
import animeware.ui.themes.impl.ThemeManager;
import animeware.ui.themes.impl.ThemeMod;
import net.minecraft.util.ResourceLocation;

public class GUILight extends HudMod {

	public GUILight() {
		super("Light theme", "", new ResourceLocation("Animeware/icons/blank.png"), 0, 0);
	}
	@Override
	public void onEnable() {
		ThemeManager.guilight = true;
		//ClickGUI.setTheme(GUITheme.LIGHT);
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		ThemeManager.guilight = false;
		//ClickGUI.setTheme(GUITheme.DARK);
		//super.onDisable();
	}

}
