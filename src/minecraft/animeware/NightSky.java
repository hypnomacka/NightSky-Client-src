
/*
 * This client was created by Hypnomacka using QickDaffys tutorials as base and snippets of code from his discord server
 */

package animeware;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticController;
import animeware.cosmetic.CosmeticManager;
import animeware.cosmetic.impl.Cape;
import animeware.event.Event;
import animeware.event.EventManager;
import animeware.event.EventTarget;
import animeware.event.impl.ClientTick;
import animeware.event.impl.EventUpdate;
import animeware.gui.alt.AltManager;
import animeware.gui.clickgui.ClickGUI;
import animeware.gui.clickgui.GUIType;
import animeware.hud.mod.Freelook;
import animeware.hud.mod.HudManager;
import animeware.hud.mod.HudMod;
import animeware.login.Users;
import animeware.ui.themes.impl.ThemeManager;
import animeware.util.account.Account;
import animeware.util.backend.AntiCheat;
import animeware.util.config.AccountConfig;
import animeware.util.config.Config;
import animeware.util.config.SaveLoad;
import animeware.util.cosmetic.AnimUtil;
import animeware.util.font.FontUtil;
import animeware.util.notification.Notification;
import animeware.util.notification.NotificationManager;
import animeware.util.websockets.user.CheckName;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class NightSky {
	
	//public static boolean SwordAnim = false;
	public String NAME = "NightSky", VERSION = "(b-5.0Nn-Cg/master)", AUTHOR = "hypnomacka", NAMEVER = NAME + " " + VERSION, VERSIONSIMPLE = "5.0";
	public static NightSky INSTANCE = new NightSky();
	public Minecraft mc = Minecraft.getMinecraft();
	public static String mcname = Minecraft.getMinecraft().getSession().getUsername();
	private DiscordRP discordRP = new DiscordRP();
	public static String DisName;
	public static String DisTag;
	//public Configuration config, configSaving = ConfigurationAPI.newConfiguration(new File("/test.aw"));
	private HudMod m;
	private Event e;
	
	boolean cracked = false;
	
	
	public static boolean isUser;
	
	private int previousF5 = 0;
	
	private final AccountConfig accountConfig = new AccountConfig();
	
	public EventManager eventManager;
	public Config config;
	//public AccountConfig accConfig;
	public HudManager hudManager; 
	public AltManager altManager;
	public Users users;
	public CosmeticController cosmeticController;
	public Cape cape;
	public Notification notif;
	public CosmeticManager cosManager;
	public ThemeManager themeManager;
	//public Setting setting;
	public NotificationManager manager;
	public SaveLoad saveLoad;
	//public Account acc;
	
	
	
	//public static NetworkClient networkClient;
	//public ParticleEngine particleEngine;
	public static boolean hasSent;
	
	public static boolean results;
	
	public float cameraYaw = 0f;
	public float cameraPitch = 0f;
	
	//public static String encryptionString = "austinsexyforehead9VsTDGMOvDsEOByAZn9b6XFTE1hrPRUTDqQyy0NSCgbF2UVAKBTMCboHfUIOagja5FI3r5edsS9ek9dw";
	
	public void startup() {
		
		
		eventManager = new EventManager();
		//config = new Config();
		
		//accountConfig.load();
		this.accountConfig.load();
		config = new Config();
		
		config.loadModConfig();
		
		//accConfig = new AccountConfig();
		
		
		
		hudManager = new HudManager();
		altManager = new AltManager();
		users = new Users();
		cosmeticController = new CosmeticController();
		cape = new Cape(null);
		cosManager = new CosmeticManager();
		themeManager = new ThemeManager();
		//setting = new Setting();
		manager = new NotificationManager();
		saveLoad = new SaveLoad("nightsky");
		//acc = new Account(mc.thePlayer.getName(), "", "aeef7bc935f9420eb6314dea7ad7e1e5", mc.thePlayer.getUniqueID().toString(), false);
		
		this.INSTANCE.hudManager.WindowedFullscreen.onEnable();
		
		//AltButton.name = mc.fontRendererObj.getStringWidth(mc.thePlayer.getGameProfile().getName());
		
		//System.out.println(hudManager.hudMods);
		
		if(AntiCheat.checkVape() == true) {
			Booleans.ban = true;
			
		}
		//this.DisName = DiscordRP.getDiscordName(null);
		
		ClickGUI.ownerCheck();
		
		NightSky.INSTANCE.getDiscordRP().update("Starting...", NAME + " " + VERSION);
		
		
		
		discordRP.start();
		
		System.out.println("Starting... " + NAMEVER + " by " + AUTHOR);				
		
		
		Display.setTitle(NAMEVER);
		
		FontUtil.bootstrap();
		
	    //SessionChanger.getInstance().setUserOffline("hypnomacka");
		
		eventManager.register(this);
		
		

	}
	
	public static ArrayList<Account> accountManager = new ArrayList<>();
	  
	  public void addAccount(Account account) {
	    for (Account acc : accountManager) {
	      if (acc.getUsername().equals(account.getUsername())) {
	        System.out.println("Account with username " + account.getUsername() + " already exists!");
	        return;
	      } 
	    } 
	    accountManager.add(account);
	  }
	 
	public String getNameString() {
		return mc.thePlayer.getName().toString();
	}
	
	public void shutdown() {
		this.accountConfig.save();
		config.saveModConfig();
		//accountConfig.save();
		System.out.println("Shutting down " + NAMEVER);
		
		discordRP.shutdown();
		
		//SaveLoad.save
		
		CheckName.DoShutDownCheck();
		
		
		
		eventManager.unregister(this);
	}
	
	private void init() throws LWJGLException {
		/*if(mc.isFullScreen()) {
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.setLocation(0, 0);
			Display.setFullscreen(false);
			Display.setResizable(false);
		} else {
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "false");
			Display.setDisplayMode(new DisplayMode(mc.displayWidth, mc.displayHeight));
			Display.setResizable(true);
		}*/

	}
	public final Color getClientColor() {
        return new Color(236, 133, 209);
    }

    public final Color getAlternateClientColor() {
        return new Color(28, 167, 222);
    }
    
	
	public float getCameraYaw()
	{
		return Freelook.freelooking ? cameraYaw : mc.thePlayer.rotationYaw;
	}

	public float getCameraPitch()
	{
		return Freelook.freelooking ? cameraPitch : mc.thePlayer.rotationPitch;
	}
	public boolean overrideMouse()
	{
		if (mc.inGameHasFocus && Display.isActive())
		{
			if (!Freelook.freelooking)
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
	
	@EventTarget
	public void onTick(ClientTick event) {				
		if(mc.gameSettings.CLICK_GUI.isPressed()) {
			if(!(ClickGUI.type == GUIType.SETTINGS)) {
				mc.displayGuiScreen(new ClickGUI());
				
			} else {
				ClickGUI.type = GUIType.THEME;
				mc.displayGuiScreen(new ClickGUI());
			}
			
		}		
		
	}
	public static final NightSky getInstance() {
		return INSTANCE;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	@EventTarget
	private void onUpdate(EventUpdate e) {		
	
	AnimUtil.anim(e);
	}
	public static void sendMessage(String message) {
        StringBuilder messageBuilder = new StringBuilder();

        messageBuilder.append("&r<&bNightSky&r>").append("&r ");

        messageBuilder.append(message);

        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(messageBuilder.toString().replace("&", "\247")));
    }
	public static Color getMainColor() {
        return new Color(0, 150, 200, 255);
    }
	public static String rank() {
		if(mcname.equals("hypnomacka")) {
			return "§bOwner";
		} else if(mcname.equals("_Marto__")) {
			return "§5YouTube";
		} else if(mcname.equals("KnownAsR3named")) {
			return "§4Staff";
		} else {
			return "User";
		}
			
		
	}

}
