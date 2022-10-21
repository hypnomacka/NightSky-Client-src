package animeware.hud.mod.Mods;

import java.awt.Color;
import java.text.DecimalFormat;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class BPSMod extends HudMod{
	
	static Minecraft mc = Minecraft.getMinecraft();
	private int decimals;
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public BPSMod() {
		super("BPSMod", "Movement speed", new ResourceLocation("Animeware/icons/bps.png"), 0, 31);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		float rat = Minecraft.getMinecraft().timer.getTicksPerSecond() * Minecraft.getMinecraft().timer.timerSpeed;
		//double bps = mc.thePlayer.getDistance(mc.thePlayer.lastTickPosX, mc.thePlayer.posY, mc.thePlayer.lastTickPosZ) * rat;	
		double speed = Math.sqrt(mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ)*rat;
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§1BPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Cyan")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§bBPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§4BPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§5BPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[BPS:" + this.getFormatter().format(speed) + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			//fr.drawStringWithShadow("[BPS:" + this.getFormatter().format(speed) + "]", getX(), getY(), -1);
			fr.drawStringWithShadow("§8[§fBPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		}
		//mc.fontRendererObj.drawStringWithShadow("§8[§fBPS:§f" + this.getFormatter().format(speed) + "§8]", getX(), getY(), -1);
		//mc.fontRendererObj.drawStringWithShadow("§8[§fBPS:§f" + mc.thePlayer.capabilities.getWalkSpeed() + "§8]", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§1BPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Cyan")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§bBPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§4BPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			mc.fontRendererObj.drawStringWithShadow("§8[§5BPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString("[BPS:" + "0.00" + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fBPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		}
		//fr.drawStringWithShadow("§8[§fBPS:§f" + "0.00" + "§8]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("§8[§fBPS:§f0.00§8]") + 1;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	private DecimalFormat getFormatter()
	{
		StringBuilder format = new StringBuilder("0.00");
		for (int i = 100; this.decimals > i; i++)
		{
			format.append('0');
		}
		return new DecimalFormat(format.toString());
	}

}
