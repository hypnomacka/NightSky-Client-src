package animeware.hud.mod.Mods;

import java.util.Collection;
import java.util.Iterator;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class PotionStatus extends HudMod {
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public PotionStatus() {
		super("Potion Status", "Active potion effects", new ResourceLocation("Animeware/icons/potionhud.png"), 0, 151);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		
		Collection activeEffects = mc.thePlayer.getActivePotionEffects();
		
		if(!activeEffects.isEmpty()) {
			int yAdd = 0;
			PotionEffect potionEffect;
			Potion pe;
			String potionName = "";
			String effectDuration = "";
			for(Iterator toRemove = activeEffects.iterator(); toRemove.hasNext();) {
				potionEffect = (PotionEffect) toRemove.next();
				pe = Potion.potionTypes[potionEffect.getPotionID()];
				potionName = "";
				potionName = StatCollector.translateToLocal(pe.getName());
				
				if(potionEffect.getAmplifier() == 1) {
					potionName = "" + potionName + " II" + "";
				}else if(potionEffect.getAmplifier() == 2) {
					potionName ="" + potionName + " III" + "";
				}else if(potionEffect.getAmplifier() == 3) {
					potionName = "" + potionName + " IV" + "";
				}else if(potionEffect.getAmplifier() == 4) {
					potionName = "" + potionName + " V" + "";
				}else if(potionEffect.getAmplifier() == 5) {
					potionName = "" + potionName + " VI" + "";
				}else if(potionEffect.getAmplifier() == 6) {
					potionName = "" + potionName + " VIII" + "";
				}
				
				effectDuration = Potion.getDurationString(potionEffect);
				
				if(color.getMode().equals("Blue")) {
					fr.drawStringWithShadow("§8[§1" + potionName + " :§f " + effectDuration + "§8]", getX(), getY() + yAdd, -1);
				} else if(color.getMode().equals("Cyan")) {
					fr.drawStringWithShadow("§8[§b" + potionName + " :§f " + effectDuration + "§8]", getX(), getY() + yAdd, -1);			
				} else if(color.getMode().equals("Red")) {
					fr.drawStringWithShadow("§8[§4" + potionName + " :§f " + effectDuration + "§8]", getX(), getY() + yAdd, -1);
				} else if(color.getMode().equals("Purple")) {
					fr.drawStringWithShadow("§8[§5" + potionName + " :§f " + effectDuration + "§8]", getX(), getY() + yAdd, -1);
				} else if(color.getMode().equals("Chroma")) {
					ChromaString.drawChromaString("[" + potionName + " : " + effectDuration + "]", getX(), getY() + yAdd, -1);
				} else if(color.getMode().equals("White")) {
					fr.drawString("[" + potionName + " : " + effectDuration + "]", getX(), getY() + yAdd, -1);
				}
				
				yAdd = yAdd + 15;
			}
		}
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		fr.drawString("Jump Boost" + " : " + "0:45", getX(), getY(), -1);
		fr.drawString("Speed" + " : " + "0:45", getX(), getY() + 15, -1);
		fr.drawString("Invisibility" + " : " + "0:30", getX(), getY() + 30, -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 95;
	}
	
	@Override
	public int getHeight() {
		return 38;
	}
}