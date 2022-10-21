package animeware.hud.mod.Mods;

import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Motionblurmodule extends HudMod {
    public Motionblurmodule() {
        super("MotionBlur", "", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
    }

    @Override
    public void onEnable() {
    	MotionBlur.createAccumulation();
        //Minecraft.getMinecraft().displayGuiScreen(new Cosmetics());
    }

    public void OnUpdate(){
        MotionBlur.createAccumulation();
        //Lwhite.toggletracert();
    }
    public void OnDisable() {

    }


}
