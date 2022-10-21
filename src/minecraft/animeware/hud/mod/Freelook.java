package animeware.hud.mod;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import animeware.cosmetic.Booleans;
import animeware.event.impl.KeyEvent;
import animeware.hud.Category;
import animeware.hud.ScreenPosition;
import net.minecraft.util.ResourceLocation;

public class Freelook extends HudMod {
	
	public Freelook() {
		super("Freelook", "Toggles perspective", new ResourceLocation("Animeware/icons/direction.png"), 0, 0);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onEnable() {
       Booleans.freelook = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.freelook = false;
		//super.onDisable();
	}
	private boolean returnOnRelease = true;
	public static boolean freelooking = false;
	
	public float cameraYaw = 0f;
	public float cameraPitch = 0f;
	public int previousF5 = 0;
	
	/*//@EventTarget
	public void onKey(KeyEvent e) {
		
		if(e.getKey() == mc.gameSettings.FREELOOK.getKeyCode() && this.isEnabled) {
				if (Keyboard.getEventKeyState())
				{
					System.out.println("frelloked");
					freelooking = !freelooking;
					cameraYaw = mc.thePlayer.rotationYaw;
					cameraPitch = mc.thePlayer.rotationPitch;

					if (freelooking)
					{
						previousF5 = mc.gameSettings.thirdPersonView;
						mc.gameSettings.thirdPersonView = 1;
					}
					else
					{
						mc.gameSettings.thirdPersonView = previousF5;
					}
				}
				else if (returnOnRelease)
				{
					freelooking = false;
					mc.gameSettings.thirdPersonView = previousF5;
				}
			}

			if (Keyboard.getEventKey() == mc.gameSettings.keyBindTogglePerspective.getKeyCode())
			{
				freelooking = false;
			}
		
	}

	*/

	public boolean overrideMouse()
	{
		if (mc.inGameHasFocus && Display.isActive())
		{
			if (!freelooking)
			{
				return true;
			}

			// CODE
			mc.mouseHelper.mouseXYChange();
			float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
			float f2 = f1 * f1 * f1 * 8.0F;
			float f3 = (float) mc.mouseHelper.deltaX * f2;
			float f4 = (float) mc.mouseHelper.deltaY * f2;

			cameraYaw += f3 * 0.15F;
			cameraPitch += f4 * 0.15F;

			if (cameraPitch > 90) cameraPitch = 90;
			if (cameraPitch < -90) cameraPitch = -90;
		}

		return false;
	}
	public float getCameraYaw()
	{
		return freelooking ? cameraYaw : mc.thePlayer.rotationYaw;
	}

	public float getCameraPitch()
	{
		return freelooking ? cameraPitch : mc.thePlayer.rotationPitch;
	}
	
	/*
	@Override
	public int getWidth() {
		return fr.getStringWidth("[Freelooking]");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderDummy(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		super.renderDummy(mouseX, mouseY);
	}*/

}
