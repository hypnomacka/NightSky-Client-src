package animeware.hud.mod.Mods;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import animeware.util.ChromaString;
import animeware.util.settings.ModeSetting;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MinimalBobbing extends HudMod {
    
    public MinimalBobbing() {
        super("Minimal Bobbing", "Disables crosshair movement", new ResourceLocation("Animeware/icons/placeholder.png"), 900, 140);
    }
    
    @Override
	public void onEnable() {
       Booleans.minimalBobbing = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.minimalBobbing = false;
		//super.onDisable();
	}
           
}
