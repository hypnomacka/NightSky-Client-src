package animeware.ui.themes;

import animeware.gui.clickgui.ClickGUI;
import animeware.gui.clickgui.GUITheme;
import animeware.ui.themes.impl.ThemeManager;
import animeware.ui.themes.impl.ThemeMod;
import net.minecraft.util.ResourceLocation;

public class GUIDark extends ThemeMod {

	public GUIDark() {
		super("TNTTimer", "", new ResourceLocation("Animeware/icons/blank.png"), 0, 0);
	}
	@Override
	public void onEnable() {
		ThemeManager.guidark = true;
       ClickGUI.setTheme(GUITheme.DARK);
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		ThemeManager.guidark = false;
		ClickGUI.setTheme(GUITheme.LIGHT);
		//super.onDisable();
	}

}
