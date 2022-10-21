package animeware.hud.mod.Mods;

import java.awt.Color;
import java.text.DecimalFormat;

import animeware.hud.ScreenPosition;
import animeware.hud.mod.HudMod;
import animeware.util.render.RoundedUtils;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.ResourceLocation;

public class ModHorseStats extends HudMod {
    
    public ModHorseStats() {
		super("Horse Status", "Displays horse stats", new ResourceLocation("Animeware/icons/placeholder.png"), 450, 320);
		// TODO Auto-generated constructor stub
	}

	private final DecimalFormat df = new DecimalFormat("0.0");

	public int getWidth() {
		return 62;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}

    @Override
    public void draw() {
    	//RoundedUtils.drawSmoothRoundedRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), 7,new Color(0, 0, 0, 170).getRGB());
        if(mc.objectMouseOver.entityHit instanceof EntityHorse) {
            EntityHorse horse = (EntityHorse) mc.objectMouseOver.entityHit;
            
            if(mc.thePlayer.isRidingHorse()) return; //Recommended: If you're riding the horse it doesn't work well: it renders only very occasionally and then only for a few frames.
            
            fr.drawString("Speed: " + getHorseSpeedRounded(horse.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()) + " BPS" , getX(), getY(), -1);
            fr.drawString("Jump: " + df.format(horse.getHorseJumpStrength() * 5.5) + " Blocks" , getX(), getY() + 10, -1);
        }
        

    }
    
    private String getHorseSpeedRounded(double baseSpeed) {
        //Read https://minecraft.fandom.com/wiki/Horse#Movement_speed for more information.
        final float factor = 43.1703703704f;
        
        float speed = (float) (baseSpeed * factor);
        
        return df.format(speed);
    }

    @Override
	public void renderDummy(int mouseX, int mouseY) {
    	//RoundedUtils.drawSmoothRoundedRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), 7,new Color(0, 0, 0, 170).getRGB());
        fr.drawString("Jump: 2.3 Blocks" , getX(), getY(), -1);
        fr.drawString("Speed: 5.3 BPS" , getX(), getY() + 10, -1);
    }
    
}