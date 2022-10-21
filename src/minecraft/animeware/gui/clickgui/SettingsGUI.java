package animeware.gui.clickgui;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import animeware.NightSky;
import animeware.gui.mainmenu.MainMenu;
import animeware.hud.HUDConfigScreen;
import animeware.hud.mod.HudMod;
import animeware.ui.comp.HomeCGButton;
import animeware.ui.comp.LArrowBtn;
import animeware.ui.comp.LogoButtonWhite;
import animeware.ui.comp.clickgui.ModButton;
import animeware.ui.comp.clickgui.SettingFrame;
import animeware.util.render.RoundedUtils;
import animeware.util.render.ui.ClickGUIUtil;
import animeware.util.settings.BooleanSetting;
import animeware.util.settings.ModeSetting;
import animeware.util.settings.Setting;
import animeware.util.settings.comp.BooleanButton;
import animeware.util.settings.comp.ModeButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class SettingsGUI extends GuiScreen {
	
	HudMod mod;
	
	private Minecraft mc = Minecraft.getMinecraft();
	FontRenderer font = mc.fontRendererObj;
	ModButton modButton = new ModButton();
	ArrayList<ModButton> modbuttons = new ArrayList<ModButton>();
	ScaledResolution sr = new ScaledResolution(mc);
	
	ArrayList<SettingFrame> frames;
	ArrayList<BooleanSetting> bools;
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public SettingsGUI(HudMod mod) {
		this.mod = mod;
		
		/*frames = new ArrayList<>();
		int offset = 0;
		 for(Category category : Category.values()) {
			 frames.add(new SettingFrame(mod, 285, 100));
			 offset += 150;
		 }*/
	}
	@Override
	public void initGui() {
		//mc.entityRenderer.loadShader(new ResourceLocation("Animeware/blur.json"));
		//this.buttonList.add(new LogoButtonWhite(69, this.width / 2 - 186, this.height / 2 - 109, ""));
		this.buttonList.add(new LArrowBtn(1, this.width / 2 - 186, this.height / 2 - 109, ""));
		//this.buttonList.add(new LogoButtonWhite(0, this.width / 2 - 186, this.height / 2 - 109, ""));
		//super.initGui();
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new MainMenu());
			
		}
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ClickGUIUtil.renderClickGUI();
		super.drawScreen(mouseX,  mouseY, partialTicks);
		
    	if(!mod.settings.isEmpty()) {	
			for(Setting setting : mod.settings) {
				int countb = 1;
				if(setting instanceof BooleanSetting) {
					new BooleanButton(mouseX, mouseY, 75, 75 * countb + 10, (BooleanSetting) setting, mod, 1);
					countb += 1;
				}
			}
			for(Setting setting : mod.settings) {
				int countm = 1;
				if(setting instanceof ModeSetting) {
					new ModeButton(mouseX, mouseY,  this.width / 2 - 140, this.height / 2 - 80 * countm + 10, (ModeSetting) setting, mod, 2);
					countm += 1;
				}
			}
		}
    	//this.buttonList.add(new LogoButtonWhite(0, this.width / 2 - 186, this.height / 2 - 109, ""));
    	
    	//if(mod.settings.isEmpty()) {	
    		//font.drawString("This mod has no settings!", 420, 250, -1);
    	//}
	}
	
	
	@Override
	public void mouseClicked(int x, int y, int button) {
		for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
			if(!mod.settings.isEmpty()) {	
				for(Setting setting : mod.settings) {
					if(setting instanceof BooleanSetting) {
						if(BooleanButton.isHovered(x, y)) {
							((BooleanSetting) setting).toggle();
						}
					}
				}
			}
		}
		for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
			if(!mod.settings.isEmpty()) {	
				for(Setting setting : mod.settings) {
					if(setting instanceof ModeSetting) {
						if(ModeButton.isHovered(x, y)) {
							((ModeSetting) setting).cycle();
						}
					}
				}
			}
		}
	}
	@Override
    public void onGuiClosed() {
    	//this.guiOpen = false;
        super.onGuiClosed();
        mc.entityRenderer.stopUseShader();
    }
}
