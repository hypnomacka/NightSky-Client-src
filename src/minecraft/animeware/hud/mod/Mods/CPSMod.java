package animeware.hud.mod.Mods;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import animeware.DiscordRP;
import animeware.hud.DraggableComponent;
import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.misc.WebhookUtil;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class CPSMod extends HudMod {

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");;
	
    public CPSMod() {
        super("CPS", "Displays cps", new ResourceLocation("Animeware/icons/cps.png"), 0, 11);
        this.addSettings(color);
    }
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT;
    }

    @Override
    public int getWidth() {
        return 45;
    }

    private List<Long> clicks = new ArrayList<Long>();
    private boolean wasPressed;
    private long lastPress;
    
    private List<Long> clicks2 = new ArrayList<Long>();
    private boolean wasPressed2;
    private long lastPressed2;
    
    private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }
    
    private int getCPS2() {
        final long time2 = System.currentTimeMillis();
        this.clicks2.removeIf(aLong2 -> aLong2 + 1000 < time2);
        return this.clicks2.size();
    }
    
    public void render(DraggableComponent pos) {
        final boolean lpressed = Mouse.isButtonDown(0);
        final boolean rpressed = Mouse.isButtonDown(1);
        
        if(lpressed != this.wasPressed) {
            this.lastPress = System.currentTimeMillis() + 10;
            this.wasPressed = lpressed;
            if(lpressed) {
                this.clicks.add(this.lastPress);
            }
        }
        
        if(rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10;
            this.wasPressed2 = rpressed;
            if(rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
        final int cps = this.getCPS();
        final int cpsr = this.getCPS2();
        fr.drawStringWithShadow("§8CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
        
    }
        
    @Override
    public void draw() {
        final boolean lpressed = Mouse.isButtonDown(0);
        final boolean rpressed = Mouse.isButtonDown(1);
        
        if(lpressed != this.wasPressed) {
            this.lastPress = System.currentTimeMillis() + 10;
            this.wasPressed = lpressed;
            if(lpressed) {
                this.clicks.add(this.lastPress);
            }
        }
        
        if(rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10;
            this.wasPressed2 = rpressed;
            if(rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
        final int cps = this.getCPS();
        final int cpsr = this.getCPS2();
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§1CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
        } else if(color.getMode().equals("Cyan")) {
        	fr.drawStringWithShadow("§bCPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
        } else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("Purple")) {
	    	fr.drawStringWithShadow("§5CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("Chroma")) {
	    	ChromaString.drawChromaString("CPS: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fCPS:§f" + cps + ":" + cpsr + "§8]", getX(), getY(), -1);
		}
        //fr.drawStringWithShadow("§8[§fCPS:§f" + cps + ":" + cpsr + "§8]", getX(), getY(), -1); //§8[§fFPS:§f" + mc.getDebugFPS() + "§8]
        
        
        
    }

    @Override
    public void renderDummy(int mouseX, int mouseY) {
        final boolean lpressed = Mouse.isButtonDown(0);
        final boolean rpressed = Mouse.isButtonDown(1);
        
        if(lpressed != this.wasPressed) {
            this.lastPress = System.currentTimeMillis() + 10;
            this.wasPressed = lpressed;
            if(lpressed) {
                this.clicks.add(this.lastPress);
            }
        }
        
        if(rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10;
            this.wasPressed2 = rpressed;
            if(rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
        final int cps = this.getCPS();
        final int cpsr = this.getCPS2();
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
        if(color.getMode().equals("Blue")) {
        	fr.drawStringWithShadow("§1CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
        } else if(color.getMode().equals("Cyan")) {
        	fr.drawStringWithShadow("§bCPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
        } else if(color.getMode().equals("Red")) {
			fr.drawStringWithShadow("§4CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("Purple")) {
	    	fr.drawStringWithShadow("§5CPS§f: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("Chroma")) {
	    	ChromaString.drawChromaString("CPS: " + cps + " : " + cpsr, getX(), getY(), -1);
	    } else if(color.getMode().equals("White")) {
			fr.drawStringWithShadow("§8[§fCPS:§f" + cps + ":" + cpsr + "§8]", getX(), getY(), -1);
		}
        super.renderDummy(mouseX, mouseY);
    }
}