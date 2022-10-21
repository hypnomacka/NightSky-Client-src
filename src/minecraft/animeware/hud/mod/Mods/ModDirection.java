package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class ModDirection extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public ModDirection() {
		super("Direction", "Facing direction", new ResourceLocation("Animeware/icons/direction.png"), 0, 91);
		this.addSettings(color);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("[Direction: north]");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);		
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bDirection §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[Direction " + mc.thePlayer.getHorizontalFacing() + "]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fDirection §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		}
		
			
			
}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§8[§1Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);		
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§8[§bDirection §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§8[§4Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§8[§5Direction §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[Direction " + mc.thePlayer.getHorizontalFacing() + "]", getX() + 1, getY() + 1, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fDirection §f" + mc.thePlayer.getHorizontalFacing() + "§8]", getX() + 1, getY() + 1, -1);
		}
		super.renderDummy(mouseX, mouseY);
}

}
