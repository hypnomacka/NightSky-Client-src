package animeware.hud.mod.Mods;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import animeware.event.impl.GameLoopEvent;
import animeware.hud.mod.HudMod;


public class WindowedFullscreenMod extends HudMod {
    private boolean lastFullscreen;

    public WindowedFullscreenMod() {
        super("WindowedFullscreen", "Windowed Fullscreen", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
    }

    public void onTick(GameLoopEvent event) {
        boolean fullScreenNow = Minecraft.getMinecraft().isFullScreen();
        if (this.lastFullscreen != fullScreenNow) {
            this.fullScreen(fullScreenNow);
            this.lastFullscreen = fullScreenNow;
        }
    }

    public void fullScreen(boolean fullscreen) {
        try {
            if (fullscreen) {
                System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                Display.setLocation(0, 0);
                Display.setFullscreen(false);
                Display.setResizable(false);
            } else {
                System.setProperty("org.lwjgl.opengl.Window.undecorated", "false");
                Display.setDisplayMode(new DisplayMode(Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight));
                Display.setResizable(true);
            }
        } catch (LWJGLException lwjglexception) {
            lwjglexception.printStackTrace();
        }
    }
}