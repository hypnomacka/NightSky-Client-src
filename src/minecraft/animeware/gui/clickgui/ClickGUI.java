package animeware.gui.clickgui;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import animeware.NightSky;
import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.Category;
import animeware.hud.DraggableComponent;
import animeware.hud.HUDConfigScreen;
import animeware.hud.mod.HudMod;
import animeware.ui.comp.CosmeticButton;
import animeware.ui.comp.CosmeticsCGButton;
import animeware.ui.comp.HomeCGButton;
import animeware.ui.comp.LArrowBtn;
import animeware.ui.comp.LogoButtonWhite;
import animeware.ui.comp.SettingsCGButton;
import animeware.ui.comp.PositioningCGButton;
import animeware.ui.comp.ToggleableCGButton;
import animeware.ui.comp.clickgui.ModButton;
import animeware.ui.comp.clickgui.SettingButton;
import animeware.ui.login.PasswordField;
import animeware.ui.themes.impl.ThemeButton;
import animeware.util.render.DrawUtil;
import animeware.util.render.GLUtils;
import animeware.util.render.RenderUtil;
import animeware.util.render.RoundedUtils;
import animeware.util.render.ui.ClickGUIUtil;
import animeware.util.settings.BooleanSetting;
import animeware.util.settings.ModeSetting;
import animeware.util.settings.Setting;
import animeware.util.settings.comp.BooleanButton;
import animeware.util.settings.comp.ModeButton;
import net.arikia.dev.drpc.DiscordUser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class ClickGUI extends GuiScreen {
	
	boolean guiOpen;
	
	//DiscordUser user;
	
	public boolean CGSett;
	public boolean cgon;
	public static boolean btnHovered;
	
	private int field_146445_a;
    private int field_146444_f;
    
    float anim = 0.0F;
    boolean animated;
    
    private float currentScroll;
    
    HudMod m;
    
    HudMod preM;
    
    public static boolean settings; 
    
	private static String TntTime = "TntTimer";
	
	public int x, y, w, h;
	
	ArrayList<CosmeticButton> cosButtons = new ArrayList<>();
	ArrayList<ModButton> modButtons = new ArrayList<>();
	ArrayList<ThemeButton> tButtons = new ArrayList<>();
	public static ArrayList<SettingButton> settingButtons = new ArrayList<>();
	public DraggableComponent drag;
	
	public static GUIType type = GUIType.CLICK;
	public static GUITheme theme = GUITheme.DARK;
	
	boolean hovered;
	boolean hud;
    public static DraggableComponent top;
    //public int x, y;
    public Category viewing;
    public HudMod configuring;
    public static GuiTextField searchBar;
    ArrayList<GuiTextField> textFields = new ArrayList<>();
    EntityLivingBase entity;
    static float rotate;
    GuiScreen guiScreen;
    //int Button;

    public ClickGUI() {
        //this.x = x;
        //this.y = y;

        this.top = new DraggableComponent(100, 100, 177, 20, new Color(0,140,255, 0).getRGB());
    }
    public ClickGUI(HudMod mod) {
    	this.m = mod;
    	this.preM = mod;
    	this.m = preM;
        //this.x = x;
        //this.y = y;

        //this.top = new DraggableComponent(100, 100, 177, 20, new Color(0,140,255, 0).getRGB());
    }
	
	public void checkMouseWheel(int mouseX, int mouseY) {
    	int mouseScroll = Mouse.getDWheel();
    	
    	if(mouseScroll > 0) {
    		for(ModButton b : modButtons) {
    			b.y += 15;
    		}
    	} else if(mouseScroll < 0) {
    		for(ModButton b : modButtons) {
    			b.y -= 15;
    		}
    	}
    	
    }
	public void checkMouseWheelCosmetic(int mouseX, int mouseY) {
    	int mouseScrollCos = Mouse.getDWheel();
    	
    	if(mouseScrollCos > 0) {
    		for(CosmeticButton b : cosButtons) {
    			b.y += 15;
    		}
    	} else if(mouseScrollCos < 0) {
    		for(CosmeticButton b : cosButtons) {
    			b.y -= 15;
    		}
    	}
    }
	
	@Override
	public void initGui() {
		this.guiOpen = true;
		super.initGui();
		mc.entityRenderer.loadShader(new ResourceLocation("Animeware/blur.json"));
		//mc.entityRenderer.loadShader(new ResourceLocation("Animeware/blur.json"));
		this.anim = 80.0F;
		super.initGui();
		this.field_146445_a = 0;
        this.buttonList.clear();
        int i = -16;
        int j = 98;
               
        //if (this.anim > 0.0F)
		      //this.anim -= 6.0F; 
		    //GL11.glEnable(3089);
		    //GLUtils.makeScissorBox((this.width / 2 - 190) + this.anim, (this.height / 2 - 110) + this.anim, (this.width / 2 + 190) - this.anim, (this.height / 2 + 110) - this.anim);
        if(type == GUIType.CLICK) {
        	/*this.modButtons.add(new ModButton(this.width/ 2 - 139, 165, 323, 35, NightSky.INSTANCE.hudManager.thud));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 205, 323, 35, NightSky.INSTANCE.hudManager.fps));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 245, 323, 35, NightSky.INSTANCE.hudManager.bps));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 285, 323, 35, NightSky.INSTANCE.hudManager.cps));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 325, 323, 35, NightSky.INSTANCE.hudManager.keystrokes));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 365, 323, 35, NightSky.INSTANCE.hudManager.potionStat));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 405, 323, 35, NightSky.INSTANCE.hudManager.sip));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 445, 323, 35, NightSky.INSTANCE.hudManager.xyz));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 485, 323, 35, NightSky.INSTANCE.hudManager.lilplayer));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 525, 323, 35, NightSky.INSTANCE.hudManager.ping));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 565, 323, 35, NightSky.INSTANCE.hudManager.pd));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 605, 323, 35, NightSky.INSTANCE.hudManager.biome));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 645, 323, 35, NightSky.INSTANCE.hudManager.time));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 685, 323, 35, NightSky.INSTANCE.hudManager.Armorstat));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 725, 323, 35, NightSky.INSTANCE.hudManager.hit));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 765, 323, 35, NightSky.INSTANCE.hudManager.mem));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 805, 323, 35, NightSky.INSTANCE.hudManager.timeChanger));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 845, 323, 35, NightSky.INSTANCE.hudManager.ts));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 885, 323, 35, NightSky.INSTANCE.hudManager.direction));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 925, 323, 35, NightSky.INSTANCE.hudManager.reachDisp));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 965, 323, 35, NightSky.INSTANCE.hudManager.particles));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1005, 323, 35, NightSky.INSTANCE.hudManager.mldg));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1045, 323, 35, NightSky.INSTANCE.hudManager.head));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1085, 323, 35, NightSky.INSTANCE.hudManager.bo));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1125, 323, 35, NightSky.INSTANCE.hudManager.tnt));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1165, 323, 35, NightSky.INSTANCE.hudManager.iphys));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1205, 323, 35, NightSky.INSTANCE.hudManager.smallsword));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1245, 323, 35, NightSky.INSTANCE.hudManager.swordspin));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1285, 323, 35, NightSky.INSTANCE.hudManager.mp));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1325, 323, 35, NightSky.INSTANCE.hudManager.sz));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1365, 323, 35, NightSky.INSTANCE.hudManager.watermark));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1405, 323, 35, NightSky.INSTANCE.hudManager.arrows));
    		this.modButtons.add(new ModButton(this.width/ 2 - 139, 1445, 323, 35, NightSky.INSTANCE.hudManager.horseStat));*/
        	int countModule = 40;
        	int count = 0;
        	int total = NightSky.INSTANCE.hudManager.hudMods.size() - 5;
            for(HudMod m  : NightSky.INSTANCE.hudManager.hudMods) {
            	
            	//System.out.println(NightSky.INSTANCE.hudManager.hudMods.size() - 5);
            	
            	if(m.name == "MotionBlur" || m.name == "Color Scheme" || m.name == "Astolfo Buttons" || m.name == "Light theme" || m.name == "Notifications" || m.name == "Freelook" || m.name == "WindowedFullscreen") {
            	//if(!m.name.equals("FPS")) {
            	} else {
            		if(count < total / 2) {
            		this.modButtons.add(new ModButton(this.width/ 2 - 80,this.height / 2 - 115 + countModule, 127, 40, m));
            		} else {
            			this.modButtons.add(new ModButton(this.width/ 2 + 53,this.height / 2 - 115+ countModule - (total / 2 * 45), 127, 40, m)); // - 765
            		}
            		//this.modButtons.add(new ModButton(this.width/ 2 + 53,this.height / 2 - 115 + countModule, 127, 35, m));
            		countModule = countModule + 45;
            		count = count + 1;
                    //System.out.println(count);
                    
            	}
            }
        	
    		//this.modButtons.add(new ModButton(this.width/ 2 - 139, 1445, 323, 35, NightSky.INSTANCE.hudManager.lilplayer));
    		//System.out.println("GUIType - Click");
        } else if(type == GUIType.COSMETIC) {       	
        	/*this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 165, 323, 35, NightSky.INSTANCE.cosManager.darkCape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 205, 323, 35, NightSky.INSTANCE.cosManager.deamoneyes));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 245, 323, 35, NightSky.INSTANCE.cosManager.deamoneyes2));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 285, 323, 35, NightSky.INSTANCE.cosManager.ecape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 325, 323, 35, NightSky.INSTANCE.cosManager.gblack));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 365, 323, 35, NightSky.INSTANCE.cosManager.gblue));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 405, 323, 35, NightSky.INSTANCE.cosManager.ggreen));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 445, 323, 35, NightSky.INSTANCE.cosManager.gpurple));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 485, 323, 35, NightSky.INSTANCE.cosManager.gred));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 525, 323, 35, NightSky.INSTANCE.cosManager.kcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 565, 323, 35, NightSky.INSTANCE.cosManager.kcape2));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 605, 323, 35, NightSky.INSTANCE.cosManager.lcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 645, 323, 35, NightSky.INSTANCE.cosManager.ncape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 685, 323, 35, NightSky.INSTANCE.cosManager.pcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 725, 323, 35, NightSky.INSTANCE.cosManager.quavcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 765, 323, 35, NightSky.INSTANCE.cosManager.quickcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 805, 323, 35, NightSky.INSTANCE.cosManager.rcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 845, 323, 35, NightSky.INSTANCE.cosManager.scape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 885, 323, 35, NightSky.INSTANCE.cosManager.tcape));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 925, 323, 35, NightSky.INSTANCE.cosManager.sofyt));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 965, 323, 35, NightSky.INSTANCE.cosManager.sofyt2));
    		
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1005, 323, 35, NightSky.INSTANCE.cosManager.dwings));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1045, 323, 35, NightSky.INSTANCE.cosManager.gwings));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1085, 323, 35, NightSky.INSTANCE.cosManager.cwings));
    		
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1125, 323, 35, NightSky.INSTANCE.cosManager.eggs));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1165, 323, 35, NightSky.INSTANCE.cosManager.witchhat));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1205, 323, 35, NightSky.INSTANCE.cosManager.glasses));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1245, 323, 35, NightSky.INSTANCE.cosManager.halo));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1285, 323, 35, NightSky.INSTANCE.cosManager.retardeyes));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1325, 323, 35, NightSky.INSTANCE.cosManager.blaze));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1365, 323, 35, NightSky.INSTANCE.cosManager.ban));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1405, 323, 35, NightSky.INSTANCE.cosManager.wpet));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1445, 323, 35, NightSky.INSTANCE.cosManager.ch));
    		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139, 1485, 323, 35, NightSky.INSTANCE.cosManager.rinn));*/
        	int countCape = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.CAPE)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 145 + countCape, 323, 35, m));
            		countCape = countCape + 40;
                    //System.out.println(countModule);
            	}
            }
            int countAnim = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.ANIM)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 185 + countCape + countAnim, 323, 35, m));
            		countAnim = countAnim + 40;
                    //System.out.println(countModule);
            	}
            }
            int countWings = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.WINGS)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 225 + countCape + countAnim + countWings, 323, 35, m));
            		countWings = countWings + 40;
                    //System.out.println(countModule);
            	}
            }
            int countHat = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.HAT)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 265 + countCape + countAnim + countWings + countHat, 323, 35, m));
            		countHat = countHat + 40;
                    //System.out.println(countModule);
            	}
            }
            int countPet = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.PET)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 305 + countCape + countAnim + countWings + countHat + countPet, 323, 35, m));
            		countPet = countPet + 40;
                    //System.out.println(countModule);
            	}
            }
            int countBandana = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.BANDANA)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 345 + countCape + countAnim + countWings + countHat + countPet + countBandana, 323, 35, m));
            		countBandana = countBandana + 40;
                    //System.out.println(countModule);
            	}
            }
            int countOther = 40;
            for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
            	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape" || !(m.type == CosmeticType.OTHER)) {
                
            	} else {
            		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 385 + countCape + countAnim + countWings + countHat + countPet + countBandana + countOther, 323, 35, m));
            		countOther = countOther + 40;
                    //System.out.println(countModule);
            	}
            }
    		//System.out.println("GUIType - Cosmetic");
        } else if(type == GUIType.PROFILE) {
        	try {
        		int countCosmetic = 40;
                for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
                	if((m.name.equals("Owner Cape") || m.name.equals("Staff Cape") || m.name.equals("YT Cape")) && mc.thePlayer.getName().equals("hypnomacka")) {
                		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 145 + countCosmetic, 323, 35, m));
                		countCosmetic = countCosmetic + 40;
                        
                	} else if(m.name.equals("YT Cape") && mc.thePlayer.getName().equals("")) {
                		//if()
                		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 145 + countCosmetic, 323, 35, m));
                		countCosmetic = countCosmetic + 40;
                        //System.out.println(countModule);
                	} 
                }
        	} catch(NullPointerException e) {
        		e.printStackTrace();
        		
        	}
        	
        	//System.out.println("GUIType - Profile");
        } else if(type == GUIType.THEME) {
        	int countModule = 40;
            for(HudMod m  : NightSky.INSTANCE.hudManager.hudMods) {
            	if(m.name == "Light theme" || m.name == "Color Scheme" || m.name == "Astolfo Buttons") {
            		this.modButtons.add(new ModButton(this.width/ 2 - 139,this.height / 2 - 145 + countModule, 323, 35, m));
                    countModule = countModule + 40;
                    
            	} 
            }
        	
        } else if(type == GUIType.SETTINGS) {
        	this.buttonList.add(new LArrowBtn(4, this.width / 2 - 186, this.height / 2 - 109, ""));
        }
        	
        if(!(type == GUIType.SETTINGS)) {
        this.buttonList.add(new LogoButtonWhite(69, this.width / 2 - 183, this.height / 2 - 105, "NightSky"));
		this.buttonList.add(new HomeCGButton(1, this.width / 2 - 183, this.height / 2 - 61, "Modules"));
		this.buttonList.add(new CosmeticsCGButton(3, this.width / 2 - 183, this.height / 2 - 38, "Cosmetics"));
		this.buttonList.add(new ToggleableCGButton(2, this.width / 2 - 183, this.height / 2 - 15, "Personal"));
		this.buttonList.add(new SettingsCGButton(4, this.width / 2 - 183, this.height / 2 + 12, "Settings"));
		this.buttonList.add(new PositioningCGButton(5, this.width / 2 - 183, this.height / 2 + 40, "Positioning"));
        }
        this.searchBar = new GuiTextField(24, this.mc.fontRendererObj, 100, 10, 200, 20); 
        this.searchBar.setFocused(true);
        Keyboard.enableRepeatEvents(true);
		//this.buttonList.add(new HudButton(6, this.width / 2 - 188, this.height / 2 + 88, ""));
		
		//GL11.glDisable(3089);
		
}	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		//Gui.drawRect(drag.getxPosition() - 3, drag.getyPosition() - 3, drag.getxPosition() + 423, drag.getyPosition() + 328, -1);
		
		//System.out.println(NightSky.DisName + NightSky.DisTag + "= Hypnomacka#4765");
		
		//this.btnHovered = mouseX >= ModButton.x && mouseX <= ModButton.x + ModButton.w && mouseY >= ModButton.y && mouseY <= ModButton.y + ModButton.h;
		
		//FontUtilCedo.normal.drawString("l", 340, 135, new Color(50, 50, 50, 255).getRGB());
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		ScaledResolution sr = new ScaledResolution(mc);
		
		ClickGUIUtil.renderClickGUI();
		
		//this.searchBar.drawTextBox();
		
		
		
		
		
	    	
		if(type == GUIType.SETTINGS) {
		//for(HudMod m : NightSky.INSTANCE.hudManager.hudMods) {
			if(!m.settings.isEmpty()) {	
				for(Setting setting : m.settings) {
					int countb = 1;
					if(setting instanceof BooleanSetting) {
						new BooleanButton(mouseX, mouseY, 75, 75 * countb + 10, (BooleanSetting) setting, m, 1);
						countb += 1;
					}
				}
				for(Setting setting : m.settings) {
					int countm = 1;
					if(setting instanceof ModeSetting) {
						new ModeButton(mouseX, mouseY,  this.width / 2 - 140, this.height / 2 - 80 * countm + 10, (ModeSetting) setting, m, 2);
						countm += 1;
					}
				}
			}
		//}
		
		}
		/*if(MinecraftServer.getServer().isSinglePlayer()) {
			NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
			if(playerInfo != null) {
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
			} else if(Minecraft.getMinecraft().getCurrentServerData() != null) {
				NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
				if(playerInfo != null) {
					GL11.glColor4f(1F, 1F, 1F, 1F);
				}
			} else {
				
			}*/
		
		if(type == GUIType.CLICK || type == GUIType.THEME) {
		GL11.glDisable(GL11.GL_SCISSOR_TEST);
		checkMouseWheel(mouseX, mouseY);
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
		{
			RenderUtil.scissor(this.width / 2 - 190, this.height / 2 - 0, this.width / 2 + 190, this.height / 2 + 110);
			GL11.glEnable(GL11.GL_SCISSOR_TEST);
		}		
		
  	GLUtils.makeScissorBox(this.width / 2 - 190, this.height / 2 - 79, this.width / 2 + 190, this.height / 2 + 110);
  
		    
		    
		super.drawScreen(mouseX, mouseY, partialTicks);
		for(ModButton m : modButtons) {
			m.draw();		
		}
		GL11.glDisable(GL11.GL_SCISSOR_TEST);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
		//GL11.glDisable(3089);
        } else if(type == GUIType.COSMETIC || type == GUIType.PROFILE) {
        	GL11.glDisable(GL11.GL_SCISSOR_TEST);
			checkMouseWheelCosmetic(mouseX, mouseY);
			GL11.glPushMatrix();
			GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
			{
				RenderUtil.scissor(this.width / 2 - 190, this.height / 2 - 0, this.width / 2 + 190, this.height / 2 + 110);
				//RenderUtil.scissor2(this.width / 2 - 190, this.height / 2 - 110, 1920, 1080);
				//RenderUtil.scissor(this.width / 2 - 100, -300, 1920, 1080);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
			}		
			if (this.anim > 0.0F)
			      this.anim -= 8.5F; 
			if(this.guiOpen == true) {
		    	GLUtils.makeScissorBox(this.width / 2 - 190, this.height / 2 - 110, this.width / 2 + 190, this.height / 2 + 110);
		    } else {
		    	GLUtils.makeScissorBox((this.width / 2 - 190) + this.anim, (this.height / 2 - 107) + this.anim, (this.width / 2 + 190) - this.anim, (this.height / 2 + 107) - this.anim);
		    }
			super.drawScreen(mouseX, mouseY, partialTicks);
			for(CosmeticButton cos : cosButtons) {
				try {
				cos.draw();	
				} catch(NullPointerException e) {
					e.printStackTrace();
					System.out.println("Line-512");
					
				}
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopAttrib();
			GL11.glPopMatrix();
			GL11.glDisable(3089);
        } else if(type == GUIType.THEME) {
        	GL11.glDisable(GL11.GL_SCISSOR_TEST);
			checkMouseWheelCosmetic(mouseX, mouseY);
			GL11.glPushMatrix();
			GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
			{
				RenderUtil.scissor(this.width / 2 - 190, this.height / 2 - 110, this.width / 2 + 190, this.height / 2 + 110);
				//RenderUtil.scissor2(this.width / 2 - 190, this.height / 2 - 110, 1920, 1080);
				//RenderUtil.scissor(this.width / 2 - 100, -300, 1920, 1080);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
			}		
			
			super.drawScreen(mouseX, mouseY, partialTicks);
			for(ThemeButton t : tButtons) {
				t.draw();		
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopAttrib();
			GL11.glPopMatrix();
        } 
		try {
			if(hud) {
	    	this.hovered = (mouseX >= top.getxPosition() + 180 && mouseY >= top.getyPosition() + 2 && mouseX < top.getxPosition() + 180 + 17 && mouseY < top.getyPosition() + 2 + 15);
	    	
	    	//Playerdraw(top.getxPosition(), top.getyPosition() + 100, 10000, 50.0F, 0.0F, (EntityLivingBase)Minecraft.thePlayer);
	    	Playerdraw(top.getxPosition() + 42, top.getyPosition() + 100, 25, 0, 0, mc.thePlayer);
	    	RoundedUtils.drawSmoothRoundedRect(top.getxPosition(), top.getyPosition(), top.getxPosition() + 200, top.getyPosition() + 110, 18.0f, new Color(25, 25, 30, 255).getRGB());
	    	mc.fontRendererObj.drawString(NightSky.mcname, top.getxPosition() + 70, top.getyPosition() + 82, new Color(255, 255, 254, 255).getRGB());
	    	mc.fontRendererObj.drawString(NightSky.rank(), top.getxPosition() + 70, top.getyPosition() + 92, new Color(255, 255, 254, 255).getRGB());
	    	//mc.fontRendererObj.drawString(NightSky.DisName, top.getxPosition() + 70, top.getyPosition() + 45, new Color(255, 255, 254, 255).getRGB());
	    	//mc.fontRendererObj.drawString(NightSky.DisTag, top.getxPosition() + 70, top.getyPosition() + 55, new Color(255, 255, 254, 255).getRGB());
	    	if(hovered) {
	    		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/quit.png"), top.getxPosition() + 180, top.getyPosition() + 2, 15, 15, new Color(255, 0, 0));
	    		  //if(Button == 1) {
	    			  
	    		  //}
	    		//mc.displayGuiScreen(new ClickGUI());
	    	} else {
	    	    DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/quit.png"), top.getxPosition() + 180, top.getyPosition() + 2, 15, 15, Color.white);
	    	}
	    	
	        //Gui.drawRect(top.getxPosition() - 3, top.getyPosition() - 3, top.getxPosition() + 423, top.getyPosition() + 328, -1);
	        //Gui.drawRect(top.getxPosition(), top.getyPosition() + 5, top.getxPosition() + 420, top.getyPosition() + 325, new Color(33,33,33).getRGB());
	        top.draw(mouseX, mouseY);
			}
	        } catch (NullPointerException e) {
	    		System.out.println("GUI ERROR");
	    	}
	        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	/*@Override
    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t') {
            
        }
        if (character == '\r') {
            //this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        //this.searchBar.textboxKeyTyped(character, key);
        
    }*/
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			//NightSky.sendMessage("Opened ClickGUI");
			type = GUIType.CLICK;
			//hud = true;
			mc.displayGuiScreen(new ClickGUI());
			
			//mc.displayGuiScreen(new ClickGUI());
			
		}
		if(button.id == 5) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(button.id == 3) {
			setType(GUIType.COSMETIC);
			mc.displayGuiScreen(new ClickGUI());
			//type = GUIType.COSMETIC;
			//mc.displayGuiScreen(new CosmeticGUINew());
		}
		if(button.id == 2) {
			setType(GUIType.PROFILE);
			mc.displayGuiScreen(new ClickGUI());
			//type = GUIType.PROFILE;
			//mc.displayGuiScreen(new ClickGUI2());
		}
		if(button.id == 4) {
			setType(GUIType.THEME);
			mc.displayGuiScreen(new ClickGUI());
			//mc.displayGuiScreen(new GuiMultiplayerIngame());
		}
		if(button.id == 99) {
			try {
	 			  Desktop desktop = java.awt.Desktop.getDesktop();
	 			  URI oURL = new URI("http://hynomacka.ddns.net");
	 			  desktop.browse(oURL);
	 			} catch (Exception e) {
	 			  e.printStackTrace();
	 			}
		}
		if(button.id == 6) {
			//mc.displayGuiScreen(new Changelog());
			hud = true;
		}
		if(button.id == 8) {
			type = GUIType.COSMETIC;
			mc.displayGuiScreen(new ClickGUI());
			//mc.displayGuiScreen(new CosmeticGUINew());
		}
		if(button.id == 9) {
			mc.displayGuiScreen(new ClickGUI());
		}
		if(button.id == 0) {
			type = GUIType.PROFILE;
			mc.displayGuiScreen(new ClickGUI());
			//mc.displayGuiScreen(new ProfileCGui(null));
		}
	}
	
//}
	public static void setType(GUIType killme) {
        if(killme == GUIType.CLICK) {
            type = GUIType.CLICK;
            //this.m = null;
        } else if(killme == GUIType.COSMETIC) {
            type = GUIType.COSMETIC;
            //this.m = null;
        } else if(killme == GUIType.PROFILE) {
            type = GUIType.PROFILE ;
            //this.m = null;
        }else if(killme == GUIType.THEME) {
            type = GUIType.THEME ;
        }
    }
	public static void setTheme(GUITheme killme) {
        if(killme == GUITheme.DARK) {
            theme = GUITheme.DARK;
            //this.m = null;
        } else if(killme == GUITheme.LIGHT) {
            theme = GUITheme.LIGHT;
            //this.m = null;
        }
    }
	
	//public ParticleEngine engine = new ParticleEngine();
	
	
	
	public static void ownerCheck() {
		if(NightSky.DisName + NightSky.DisTag == "Hypnomacka#4765") {
			Booleans.isOwner = true;
		} else {
			Booleans.isOwner = false;
		}
	}
		
	
	
	 
	@Override
	public void draw() {

		GL11.glColor4f(1F, 1F, 1F, 1F);

			Playerdraw(15 + 15, 15 + 50, 25, 50, 0, null);
			
		super.draw();
	}    
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {								
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
		for(CosmeticButton cos : cosButtons) {
			cos.onClick(mouseX, mouseY, mouseButton);
		}
		for(SettingButton s : settingButtons) {
            s.onClick(mouseX, mouseY, mouseButton);
        }
		if(hovered) {
    		if(mouseButton == 0) {
    			//mc.displayGuiScreen(new ClickGUI());
    			hud = false;
    		}
    	}
	    if(type == GUIType.SETTINGS) {
	    	for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
				if(!mod.settings.isEmpty()) {	
					for(Setting setting : mod.settings) {
						if(setting instanceof BooleanSetting) {
							if(BooleanButton.isHovered(mouseX, mouseY)) {
								((BooleanSetting) setting).toggle();
							}
						}
					}
				}
			}
			for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
				if(!mod.settings.isEmpty()) {	
					for(Setting setting : mod.settings) {
						if(setting instanceof ModeSetting) {
							if(ModeButton.isHovered(mouseX, mouseY)) {
								((ModeSetting) setting).cycle();
							}
						}
					}
				}
			}
	    }
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	private void drawRoundedRect(final int x, final int y, final int width, final int height, final int cornerRadius, final Color color) {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }
    
    private void drawArc(final int x, final int y, final int radius, final int startAngle, final int endAngle, final Color color) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0.0).endVertex();
        for (int i = (int)(startAngle / 360.0 * 100.0); i <= (int)(endAngle / 360.0 * 100.0); ++i) {
            final double angle = 6.283185307179586 * i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private void drawCircle(final int x, final int y, final int width, final int height, final Color color) {
        this.drawArc(x + width, y + height / 2, width / 2, 0, 360, color);
    }
    public static void Playerdraw(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
		try {
			GlStateManager.enableColorMaterial();
	        GlStateManager.pushMatrix();
	        GlStateManager.translate((float)posX, (float)posY, 50.0F);
	        GlStateManager.scale((float)(-40), (float)42, (float)42);
	        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        float f = ent.renderYawOffset;
	        float f1 = ent.rotationYaw;
	        float f2 = ent.rotationPitch;
	        float f3 = ent.prevRotationYawHead;
	        float f4 = ent.rotationYawHead;
	        GlStateManager.rotate(180f, 0.0F, 1.0F, 0.0F);
	        RenderHelper.enableStandardItemLighting();
	        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
	        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
	        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
	        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
	        ent.rotationYawHead = ent.rotationYaw;
	        ent.prevRotationYawHead = ent.rotationYaw;
	        GlStateManager.translate(0.0F, 0.0F, 0.0F);
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
	        rendermanager.setRenderShadow(true);
	        ent.renderYawOffset = f;
	        ent.rotationYaw = f1;
	        ent.rotationPitch = f2;
	        ent.prevRotationYawHead = f3;
	        ent.rotationYawHead = f4;
	        GlStateManager.popMatrix();
	        RenderHelper.disableStandardItemLighting();
	        GlStateManager.disableRescaleNormal();
	        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	        GlStateManager.disableTexture2D();
	        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
		} catch (NullPointerException e) {
    		System.out.println("Playerdraw ERROR");
    	}
    	
    }
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void onGuiClosed() {
    	if(type == GUIType.SETTINGS && ModButton.settings) {
    		//type = GUIType.CLICK;
    		ModButton.settings = false;
    	}
    	
    	this.guiOpen = false;
        super.onGuiClosed();
        mc.entityRenderer.stopUseShader();
    }
    
    
}
