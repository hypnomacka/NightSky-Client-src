package animeware.ui.themes.color;

import animeware.hud.mod.HudMod;
import animeware.ui.themes.impl.ThemeManager;
import animeware.util.settings.ModeSetting;
import net.minecraft.util.ResourceLocation;

public class ColorScheme extends HudMod {

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public ColorScheme() {
		super("Color Scheme", "Right-click for settings", new ResourceLocation("Animeware/icons/blank.png"), 0, 0);
		this.addSettings(color);
	}
	@Override
	public void onEnable() {
		//ThemeManager.guilight = true;
		//ClickGUI.setTheme(GUITheme.LIGHT);
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		//ThemeManager.guilight = false;
		//ClickGUI.setTheme(GUITheme.DARK);
		//super.onDisable();
	}

}
