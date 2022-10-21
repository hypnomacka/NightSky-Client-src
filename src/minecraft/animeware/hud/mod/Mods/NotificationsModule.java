package animeware.hud.mod.Mods;

import org.lwjgl.input.Keyboard;

import animeware.hud.Category;
import animeware.hud.mod.HudMod;
import animeware.util.misc.Timer;
import animeware.util.settings.BooleanSetting;
import animeware.util.settings.ModeSetting;
import animeware.util.settings.NumberSetting;
import net.minecraft.util.ResourceLocation;

public class NotificationsModule extends HudMod {

	public NumberSetting time = new NumberSetting("Time", 2.5, 1, 10, 0.5);
	//public BooleanSetting modToggle = new BooleanSetting("Module Toggle", true);
	public ModeSetting font = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;

	public NotificationsModule() {
		super("Notifications", "Customize your Notifications", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
		addSettings(time,font);
	}
	
	Timer timer = new Timer();
	
	
}