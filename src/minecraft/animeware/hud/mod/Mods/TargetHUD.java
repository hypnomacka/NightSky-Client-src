package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.render.RoundedUtils;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class TargetHUD extends HudMod {

	EntityLivingBase target;
	
	private Color healthColor;
	private int healthRect;

	//public BooleanSetting Test = new BooleanSetting("Test", false);
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
	public TargetHUD() {
		super("TargetHUD", "Enemy health", new ResourceLocation("Animeware/icons/placeholder.png"), 450, 120);
		this.addSettings(color);
	}
	
	@Override
	public void draw() {
		tenderTargetHud();
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		RoundedUtils.drawSmoothRoundedRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), 7,new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("TargetName", getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow("10 \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);		
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return 62;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}

	
	private void tenderTargetHud() {
		target = (EntityLivingBase) mc.pointedEntity;

		if(target !=null) {
		RoundedUtils.drawSmoothRoundedRect(getX() - 20, getY(), getX() + getWidth(), getY() + getHeight() + 3, 7,new Color(0, 0, 0, 170).getRGB());
		if(color.getMode().equals("Blue")) {
			fr.drawStringWithShadow("§1" + target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		} else if(color.getMode().equals("Cyan")) {
			fr.drawStringWithShadow("§b" + target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		} else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4" + target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		} else if(color.getMode().equals("Purple")) {
			fr.drawStringWithShadow("§5" + target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		} else if(color.getMode().equals("Chroma")) {
			ChromaString.drawChromaString(target.getName(), getX() + 2, getY() + 2, -1);
			ChromaString.drawChromaString((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		} else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		}
		GuiInventory.drawEntityOnScreen(getX() - 8, getY() + 22, 10, 50, 50, target);
		drawEntityHealth();
         /*mc.getRenderItem().renderItemAndEffectIntoGUI(target.getCurrentArmor(3), getX() + 45, getY() + 30);
	     mc.getRenderItem().renderItemAndEffectIntoGUI(target.getCurrentArmor(2), getX() + 60, getY() + 30);
	     mc.getRenderItem().renderItemAndEffectIntoGUI(target.getCurrentArmor(1), getX() + 75, getY() + 30);
	     mc.getRenderItem().renderItemAndEffectIntoGUI(target.getCurrentArmor(0), getX() + 90, getY() + 30);*/
	     
		//Gui.drawScaledCustomSizeModalRect(330, 365, 8F, 8F, 8, 8, 20, 20, 64F, 64F);
		}
	}
	private void drawEntityHealth() {
		EntityLivingBase currentTarget = (EntityLivingBase) this.mc.pointedEntity;
		
		if(currentTarget.getHealth() >= currentTarget.getMaxHealth()) {
			healthColor = new Color(0, 255, 0, 255);
			healthRect = 55;
		} else if (currentTarget.getHealth() >= 17) {
			healthColor = new Color(255, 242, 0, 255);
			healthRect = 45;
		} else if (currentTarget.getHealth() >= 14) {
			healthColor = new Color(173, 117, 3, 255);
			healthRect = 35;
		} else if (currentTarget.getHealth() >= 11) {
			healthColor = new Color(173, 80, 3, 255);
			healthRect = 25;
		} else if (currentTarget.getHealth() >= 8) {
			healthColor = new Color(173, 80, 3, 255);
			healthRect = 15;
		} else if (currentTarget.getHealth() >= 5) {
			healthColor = new Color(184, 43, 0, 255);
			healthRect = 5;
		} else if (currentTarget.getHealth() <= 2) {
			healthColor = new Color(255, 0, 0, 255);
			healthRect = 0;
		}else if (currentTarget.getHealth() <= 0) {
			healthColor = new Color(255, 0, 0, 255);
			healthRect = 0;
		}		
		
		//Gui.drawRect(getX() + 77, getY(), getX() + 79, getY() + getHeight(), healthColor.getRGB());
		//154
		RoundedUtils.drawSmoothRoundedRect(getX() + 3, getY() + 21, getX() + healthRect + 3, getY() + 23, 2, healthColor.getRGB());
		
	}
	
}
