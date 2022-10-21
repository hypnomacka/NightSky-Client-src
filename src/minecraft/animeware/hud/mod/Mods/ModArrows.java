package animeware.hud.mod.Mods;

import java.awt.Color;

import animeware.hud.mod.HudMod;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModArrows extends HudMod {
	
	//ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");

	public ModArrows() {
		super("ArrowMod", "Number of arrows in your inventory", new ResourceLocation("Animeware/icons/placeholder.png"), 5, 5);
		//this.addSettings(color);
	}

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 23;
	}

	@Override
	public void draw() {
		if(this.getRemainingArrows() < 1) {
			fr.drawString(this.getRemainingArrows() + "", getX() + 8, getY() + 15, Color.RED.getRGB());
		} else {
			fr.drawString(this.getRemainingArrows() + "", getX() + 8, getY() + 15, Color.WHITE.getRGB());
		}
        this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), getX() + 3, getY() - 1);

	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if(this.getRemainingArrows() < 1) {
			fr.drawString(this.getRemainingArrows() + "", getX() + 8, getY() + 15, Color.RED.getRGB());
		} else {
			fr.drawString(this.getRemainingArrows() + "", getX() + 8, getY() + 15, Color.WHITE.getRGB());
		}
        this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), getX() + 3, getY() - 1);
        super.renderDummy(mouseX, mouseY);
	}
	
	
	   private int getRemainingArrows() {
		      int i = 0;

		      for(ItemStack itemstack : this.mc.thePlayer.inventory.mainInventory) {
		         if(itemstack != null && itemstack.getItem().equals(Items.arrow)) {
		            i += itemstack.stackSize;
		         }
		      }

		      return i;
		   }
	   
	
}
