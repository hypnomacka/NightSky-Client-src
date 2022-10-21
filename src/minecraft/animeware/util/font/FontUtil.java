// Decompiled with: CFR 0.152
// Class Version: 8
package animeware.util.font;

import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class FontUtil {
    public static volatile int completed;
    public static MinecraftFontRenderer normal;
    private static Font normal_;

    private static Font getFont(Map<String, Font> locationMap, String location, int size) {
        Font font = null;
        try {
            if (locationMap.containsKey(location)) {
                font = locationMap.get(location).deriveFont(0, size);
            } else {
                InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("Animeware/font/" + location)).getInputStream();
                font = Font.createFont(0, is);
                locationMap.put(location, font);
                font = font.deriveFont(0, size);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading font");
            font = new Font("default", 0, 10);
        }
        return font;
    }

    public static boolean hasLoaded() {
        return completed >= 3;
    }

    public static void bootstrap() {
        new Thread(() -> {
            HashMap<String, Font> locationMap = new HashMap<String, Font>();
            normal_ = FontUtil.getFont(locationMap, "font.ttf", 19);
            ++completed;
        }).start();
        new Thread(() -> {
            HashMap locationMap = new HashMap();
            ++completed;
        }).start();
        new Thread(() -> {
            HashMap locationMap = new HashMap();
            ++completed;
        }).start();
        while (!FontUtil.hasLoaded()) {
            try {
                Thread.sleep(5L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        normal = new MinecraftFontRenderer(normal_, true, true);
    }
}

/*package animeware.util.font;


import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("NonAtomicOperationOnVolatileField")
public class FontUtil {
    public static volatile int completed;
    public static MinecraftFontRenderer normal, tenacity;
    public static Font normal_;

    private static Font getFont(Map<String, Font> locationMap, String location, int size) {
        Font font = null;

        try {
            if (locationMap.containsKey(location)) {
                font = locationMap.get(location).deriveFont(Font.PLAIN, size);
            } else {
                InputStream is = Minecraft.getMinecraft().getResourceManager()
                        .getResource(new ResourceLocation("Animeware/font/" + location)).getInputStream();
                font = Font.createFont(0, is);
                locationMap.put(location, font);
                font = font.deriveFont(Font.PLAIN, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading font");
            font = new Font("default", Font.PLAIN, +15);
        }

        return font;
    }
    public static Font getFontTena(Map<String, Font> locationMap, String location, int size) {
        Font font;
        try {
            if (locationMap.containsKey(location)) {
                font = locationMap.get(location).deriveFont(Font.PLAIN, size);
            } else {
                InputStream is = Minecraft.getMinecraft().getResourceManager()
                        .getResource(new ResourceLocation("Animeware/fonts/" + location)).getInputStream();
                locationMap.put(location, font = Font.createFont(0, is));
                font = font.deriveFont(Font.PLAIN, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading font");
            font = new Font("default", Font.PLAIN, +10);
        }
        return font;
    }

    public static boolean hasLoaded() {
        return completed >= 3;
    }

    public static void bootstrap() {
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            normal_ = getFont(locationMap, "font.ttf", 19);
            //normal_ = getFont(locationMap, "thic.ttf", 19);
            completed++;
        }).start();
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            completed++;
        }).start();
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            completed++;
        }).start();

        while (!hasLoaded()) {
            try {
                //noinspection BusyWait
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        normal = new MinecraftFontRenderer(normal_, true, true);
    }
}*/