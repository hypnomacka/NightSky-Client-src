package animeware.hud.mod.Mods;

import java.awt.Color;
import java.text.DecimalFormat;

import animeware.event.EventTarget;
import animeware.event.impl.AttackEntityEvent;
import animeware.event.impl.ClientTick;
import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class ReachDisplayMod extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public ReachDisplayMod() {
		super("ReachDisplay", "Displays distance from enemy", new ResourceLocation("Animeware/icons/glacier/reach.png"), 0, 101);
		this.addSettings(color);
	}

	String ReachDisplay = "";
	private long lastAttack;
	private boolean enabled = true;
	private int decimals;

	@Override
	public int getWidth()
	{
		return fr.getStringWidth("[0 blocks]");
		
	}

	@Override
	public int getHeight()
	{
		return this.fr.FONT_HEIGHT;
	}

	@Override
	public void draw()
	{
		//if(mc.gameSettings.keyBindAttack.isKeyDown()) {
			
		final Vec3 vec3 = this.mc.getRenderViewEntity().getPositionEyes(1.0F);
		double hitRange = this.mc.objectMouseOver.hitVec.distanceTo(vec3);
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		
		if(color.getMode().equals("Blue")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				this.fr.drawString("§8[§f" + this.getFormatter().format(hitRange) + " §1blocks§8]", getX(),getY(), -1, false);
				
				//this.lastAttack = System.nanoTime() + 100;
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					this.fr.drawString("§8[§f0 §1blocks§8]", getX(),getY(), -1, false);
				
			}
		} else if(color.getMode().equals("Cyan")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				this.fr.drawString("§8[§f" + this.getFormatter().format(hitRange) + " §bblocks§8]", getX(),getY(), -1, false);
				
				//this.lastAttack = System.nanoTime() + 100;
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					this.fr.drawString("§8[§f0 §bblocks§8]", getX(),getY(), -1, false);
				
			}
		} else if(color.getMode().equals("Red")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				this.fr.drawString("§8[§f" + this.getFormatter().format(hitRange) + " §4blocks§8]", getX(),getY(), -1, false);
				
				//this.lastAttack = System.nanoTime() + 100;
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					this.fr.drawString("§8[§f0 §4blocks§8]", getX(),getY(), -1, false);
				
			}
		} else if(color.getMode().equals("Purple")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				this.fr.drawString("§8[§f" + this.getFormatter().format(hitRange) + " §5blocks§8]", getX(),getY(), -1, false);
				
				//this.lastAttack = System.nanoTime() + 100;
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					this.fr.drawString("§8[§f0 §5blocks§8]", getX(),getY(), -1, false);
				
			}
		} else if(color.getMode().equals("Chroma")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				ChromaString.drawChromaString("[" + this.getFormatter().format(hitRange) + " blocks]", getX(),getY(), -1);
				
				//this.lastAttack = System.nanoTime() + 100;
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					ChromaString.drawChromaString("[0 blocks]", getX(),getY(), -1);
				
			}
		} else if(color.getMode().equals("White")) {
			if(mc.gameSettings.keyBindAttack.isKeyDown()) {
				this.fr.drawStringWithShadow("[" + this.getFormatter().format(hitRange) + " blocks]", getX(),getY(), -1);
				this.lastAttack = System.currentTimeMillis() + 10;
				} else {
					Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
					this.fr.drawStringWithShadow("[0 blocks]", getX(),getY(), -1);
				}
		}
		//this.lastAttack = System.nanoTime() + 100;
		
		
		//}
	}
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("[2 blocks]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}

	@EventTarget
	public void onHit(AttackEntityEvent event)
	{
		final Vec3 vec3 = this.mc.getRenderViewEntity().getPositionEyes(1.0F);
		double hitRange = this.mc.objectMouseOver.hitVec.distanceTo(vec3);

		ReachDisplay = this.getFormatter().format(hitRange) + " blocks";

		this.lastAttack = System.nanoTime();
	}

	private DecimalFormat getFormatter()
	{
		StringBuilder format = new StringBuilder("0");
		for (int i = 0; this.decimals > i; i++)
		{
			format.append('0');
		}
		return new DecimalFormat(format.toString());
	}

	@EventTarget
	public void onTick(ClientTick event)
	{
		if (System.nanoTime() - this.lastAttack >= 2.0E9 && this.enabled)
		{
			ReachDisplay = "Hasn't attacked";
		}
	}

}
