package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.ScreenPosition;
import animeware.hud.mod.HudMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class ModMLDGHelper extends HudMod{
	
	String prefix;
	String suffix;
	
	
	public ModMLDGHelper() {
		super("MLDGHelper", "I actually dont know", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 141);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getWidth() {
		return mc.fontRendererObj.getStringWidth(prefix + suffix);
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		Minecraft mc = Minecraft.getMinecraft();
	    EntityPlayerSP p = mc.thePlayer;
	    
	    MovingObjectPosition mp = p.rayTrace(200.0D, 1.0F);
		int height = mp.getBlockPos().getY() + 1;
		
		
		String mlgstatus;
		
		int down = mp.getBlockPos().getY() + 1;
		int up = Minecraft.getMinecraft().thePlayer.getPosition().getY();
		
		int df = up - down;
		
		if(df <= 5) {
			mlgstatus = "Save";
		} else {
			if ((df >= 6 && df <= 16) ||
				df == 18 ||
				df == 19 ||
				df == 21 ||
				df == 22 ||
				df == 24 ||
				df == 26 ||
				df == 27 ||
				df == 29 ||
				df == 33 ||
				df == 34 ||
				df == 36 ||
				df == 38 ||
				df == 40 ||
				df == 42 ||
				df == 44 ||
				df == 47 ||
				df == 49 ||
				df == 51 ||
				df == 53 ||
				df == 55 ||
				df == 58 ||
				df == 60 ||
				df == 62 ||
				df == 65 ||
				df == 67 ||
				df == 69 ||
				df == 72 ||
				df == 74 ||
				df == 77 ||
				df == 79 ||
				df == 82 ||
				df == 85 ||
				df == 87 ||
				df == 90 ||
				df == 93 ||
				df == 95 ||
				df == 98 ||
				df == 101 ||
				df == 104 ||
				df == 106 ||
				df == 109 ||
				df == 112 ||
				df == 115 ||
				df == 118 ||
				df == 121 ||
				df == 124 ||
				df == 127 ||
				df == 130 ||
				df == 135 ||
				df == 138 ||
				df == 142 ||
				df == 145 ||
				df == 148 ||
				df == 151 ||
				df == 153 ||
				df == 154
				) {
				
				mlgstatus = "Run";
				
			} else {
				if (df == 18 ||
				df == 17 ||
				df == 20 ||
				df == 23 ||
				df == 28 ||
				df == 30 ||
				df == 31 ||
				df == 35 ||
				df == 37 ||
				df == 39 ||
				df == 41 ||
				df == 43 ||
				df == 45 ||
				df == 50 ||
				df == 52 ||
				df == 54 ||
				df == 56 ||
				df == 59 ||
				df == 61 ||
				df == 63 ||
				df == 66 ||
				df == 68 ||
				df == 71 ||
				df == 73 ||
				df == 76 ||
				df == 78 || 
				df == 81 ||
				df == 83 ||
				df == 86 ||
				df == 91 ||
				df == 94 ||
				df == 97 ||
				df == 100 ||
				df == 102 ||
				df == 105 ||
				df == 108 ||
				df == 111 ||
				df == 114 ||
				df == 119 ||
				df == 122 ||
				df == 125 ||
				df == 128 ||
				df == 131 ||
				df == 134 ||
				df == 137 ||
				df == 140 ||
				df == 143 ||
				df == 146 ||
				df == 150 ||
				df == 156
				) {
					
					mlgstatus = "Jump";
					
				} else {
					mlgstatus = "Impossible";
				}
			}
		}
		
		
		if (mp != null && mp.typeOfHit == MovingObjectType.BLOCK && df >= 0) {
            prefix = "§c" + down + "§8: §f";

            if (Minecraft.getMinecraft().theWorld.getBlockState(mp.getBlockPos()) != Block.getStateById(30)) {
            	
            	if (up < down) {
            		prefix = "§cN/A§8: §f";
                	suffix = "Not specified";
            	} else {
            		prefix = "§c" + down + "§8: §f";
            		suffix = mlgstatus;
            	}
                
            } else {
            	
            	suffix = "Cobweb! Choose another block!";
            	
            }
        } else {
        	prefix = "§cN/A§8: §f";
        	suffix = "Not specified";
        }
		
		
		
		//df for run
		//18,19,21,22,24,26,27,29,33,34,36,38,40, 42,44,47, 49, 51, 53, 55, 58, 60, 62, 65, 67, 69, 72, 74, 77, 79, 82, 85, 87, 90
		//93, 95, 98, 101, 104, 106, 109, 112, 115, 118, 121, 124, 127, 130, 135, 138, 142, 145, 148, 151, 153, 154
		
		//df for jump
		//17, 20, 23, 28, 30, 31, 35, 37, 39, 41, 43, 45, 50, 52, 54, 56, 59, 61, 63, 66, 68, 71, 73, 76, 78
		//81, 83, 86, 89, 91, 94, 97, 100, 102, 105, 108, 111, 114, 119, 122, 125, 128, 131, 134, 137, 140, 143, 146, 150, 156
		
		
		
		fr.drawStringWithShadow(prefix + suffix, getX(), getY(), -1);
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("§cMLG§8: §fSave", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
}