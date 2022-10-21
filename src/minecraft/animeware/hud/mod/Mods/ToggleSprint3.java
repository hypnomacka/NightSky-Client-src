package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.event.EventTarget;
import animeware.event.impl.EventUpdate;
import animeware.hud.Category;
import animeware.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class ToggleSprint3 extends HudMod {
  float prevGamma = mc.gameSettings.gammaSetting;
  
  boolean sprintingToggle = false;
  boolean startup = true;
  
  public ToggleSprint3() {
    super("ToggleSprint", "Toggles sprinting", new ResourceLocation("Animeware/icons/togglesprint.png"), 0, 81);
  }
  
  public void onDisable() {
	//if(startup == false)
    //mc.thePlayer.setSprinting(false);
    super.onDisable();
  }
  
  @EventTarget
  public void update(EventUpdate e) {
    if (mc.gameSettings.keyBindSprint.isPressed())
      this.sprintingToggle = !this.sprintingToggle; 
    if (this.sprintingToggle && 
      !this.mc.thePlayer.isOnLadder() && mc.gameSettings.keyBindForward.isKeyDown() && !this.mc.thePlayer.isCollidedHorizontally && !this.mc.thePlayer.isBlocking() && !this.mc.thePlayer.isSneaking())
      this.mc.thePlayer.setSprinting(true); 
  }
  
  @Override
	public void draw() {
	startup = true;
	Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
	String state = "(Standing)";
	    //Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, -2147483648);
	    if (this.mc.thePlayer.isSprinting() && !this.sprintingToggle && this.mc.gameSettings.keyBindForward.isKeyDown()) {
	      state = "(Vanilla)"; 
	    }
	    else if(this.sprintingToggle && this.mc.gameSettings.keyBindForward.isKeyDown()) {
	      state = "(Toggled)"; 
	    }
	    else if(!this.mc.thePlayer.isSprinting() && !this.mc.gameSettings.keyBindForward.isKeyDown()) {
		      state = "(Standing)";
	    }
	    else if(!this.sprintingToggle && this.mc.gameSettings.keyBindForward.isKeyDown()) {
	    	state = "(Walking)";
	    }
	  
	  fr.drawStringWithShadow("[Sprinting " + state + "]", getX(), getY(), -1);
		//super.draw();
	}
  @Override
	public void renderDummy(int mouseX, int mouseY) {
	    Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("[Sprinting (Toggled)]", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
    @Override
	public int getWidth() {
	    return fr.getStringWidth("[Sprinting (Toggled)]");
	    
	    
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
}
