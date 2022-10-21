package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.ScreenPosition;
import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class XYZMod extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public XYZMod() {
		super("XYZMod", "Displays coordinates", new ResourceLocation("Animeware/icons/coordinates.png"), 0, 111);
		this.addSettings(color);
	}
	
	private ScreenPosition position;
    private Color background = new Color(45, 45, 45, 180);
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§1X:§f" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			fr.drawStringWithShadow("§1Y:§f" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			fr.drawStringWithShadow("§1Z:§f" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§bX:§f" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			fr.drawStringWithShadow("§bY:§f" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			fr.drawStringWithShadow("§bZ:§f" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4X:§f" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			fr.drawStringWithShadow("§4Y:§f" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			fr.drawStringWithShadow("§4Z:§f" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§5X:§f" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			fr.drawStringWithShadow("§5Y:§f" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			fr.drawStringWithShadow("§5Z:§f" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("X:" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			ChromaString.drawChromaString("Y:" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			ChromaString.drawChromaString("Z:" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("X:" + (int) this.mc.getRenderViewEntity().posX, getX(), getY(), -1);
			fr.drawStringWithShadow("Y:" + (int) this.mc.getRenderViewEntity().posY, getX(), getY() + 10, -1);
			fr.drawStringWithShadow("Z:" + (int) this.mc.getRenderViewEntity().posZ, getX(), getY() + 20, -1);
		}
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("X:000", getX(), getY(), -1);
		fr.drawStringWithShadow("Y:000", getX(), getY() + 10, -1);
		fr.drawStringWithShadow("Z:000", getX(), getY() + 20, -1);
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]");
	}
	
	@Override
	public int getHeight() {
		return 30;
	}
}
