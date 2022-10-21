package animeware.hud.mod.Mods;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ArmorStatus extends HudMod {
    
	public String damagef;
	private int decimals;
	
	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");

    public ArmorStatus() {
        super("ArmorStatus", "Status of your armor", new ResourceLocation("Animeware/icons/armorstatus.png"), 900, 140);
        this.addSettings(color);
        
    }
    
    @Override
    public void draw() {
        
        for (int i = 0; i < mc.thePlayer.inventory.armorInventory.length; i++) {
            ItemStack itemStack = mc.thePlayer.inventory.armorInventory[i];
            renderItemStack(i, itemStack);
            renderItemStack(-1,  mc.thePlayer.getCurrentEquippedItem());
        }
        super.draw();
    }
    
    @Override
    public void renderDummy(int mouseX, int mouseY) {
            	
        renderItemStack(3, new ItemStack(Items.diamond_helmet));
        renderItemStack(2, new ItemStack(Items.diamond_chestplate));
        renderItemStack(1, new ItemStack(Items.diamond_leggings));
        renderItemStack(0, new ItemStack(Items.diamond_boots));
        renderItemStack(-1, new ItemStack(Items.golden_sword));
               
        super.renderDummy(mouseX, mouseY);
    }
    
    private void renderItemStack( int i, ItemStack is) {
    	
        if (is == null) {
            return;
        }
        
        GL11.glPushMatrix();
        int yAdd = (-16 * i) + 48;
        
        if (is.getItem().isDamageable()) {
            double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage()) * 100;
            damagef = this.getFormatter().format(damage);
            //fr.drawString(String.format("%.2f%%", damage), getX() + 20, getY() + yAdd + 5);
            if(color.getMode().equals("Blue")) {
            	fr.drawStringWithShadow("§1" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
            } else if(color.getMode().equals("Cyan")) {
            	fr.drawStringWithShadow("§b" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
            } else if(color.getMode().equals("Red")) {
    			fr.drawStringWithShadow("§4" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
    	    } else if(color.getMode().equals("Purple")) {
    	    	fr.drawStringWithShadow("§5" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
    	    } else if(color.getMode().equals("Chroma")) {
    			ChromaString.drawChromaString("" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
    	    } else if(color.getMode().equals("White")) {
    			fr.drawStringWithShadow("" + damagef + "%", getX() + 20, getY() + yAdd + 5, -1);
    		}
            
        }
        
        RenderHelper.enableGUIStandardItemLighting();
        mc.getRenderItem().renderItemAndEffectIntoGUI(is, getX(), getY() + yAdd);
        
        GL11.glPopMatrix();
    }

    @Override
    public int getWidth() {
        return fr.getStringWidth(name);
    }
    
    @Override
    public int getHeight() {
        return fr.FONT_HEIGHT + 70;
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

}
