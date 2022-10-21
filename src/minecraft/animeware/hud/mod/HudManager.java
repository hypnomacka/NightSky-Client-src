package animeware.hud.mod;

import java.util.ArrayList;

import animeware.hud.mod.Mods.ArmorStatus;
import animeware.hud.mod.Mods.BPSMod;
import animeware.hud.mod.Mods.Biome;
import animeware.hud.mod.Mods.BlockOverlay;
import animeware.hud.mod.Mods.CPSMod;
import animeware.hud.mod.Mods.FPSMod;
import animeware.hud.mod.Mods.HitColor;
import animeware.hud.mod.Mods.ItemPhysics;
import animeware.hud.mod.Mods.Keystrokes;
import animeware.hud.mod.Mods.MemUsage;
import animeware.hud.mod.Mods.MinimalBobbing;
import animeware.hud.mod.Mods.Miniplayer;
import animeware.hud.mod.Mods.ModArrows;
import animeware.hud.mod.Mods.ModDirection;
import animeware.hud.mod.Mods.ModHorseStats;
import animeware.hud.mod.Mods.ModMLDGHelper;
import animeware.hud.mod.Mods.ModParticles;
import animeware.hud.mod.Mods.MoreParticles;
import animeware.hud.mod.Mods.Motionblurmodule;
import animeware.hud.mod.Mods.NotificationsModule;
import animeware.hud.mod.Mods.PackDisplay;
import animeware.hud.mod.Mods.Ping;
import animeware.hud.mod.Mods.PlayerHead;
import animeware.hud.mod.Mods.PotionStatus;
import animeware.hud.mod.Mods.ReachDisplayMod;
import animeware.hud.mod.Mods.ScrollZoom;
import animeware.hud.mod.Mods.ServerIP;
import animeware.hud.mod.Mods.SmallSword;
import animeware.hud.mod.Mods.SwordSpin;
import animeware.hud.mod.Mods.TNTTimer;
import animeware.hud.mod.Mods.TargetHUD;
import animeware.hud.mod.Mods.TimeChanger;
import animeware.hud.mod.Mods.TimeMod;
import animeware.hud.mod.Mods.ToggleSprint3;
import animeware.hud.mod.Mods.Watermark;
import animeware.hud.mod.Mods.WindowedFullscreenMod;
import animeware.hud.mod.Mods.XYZMod;
import animeware.ui.themes.AstolfoButtons;
import animeware.ui.themes.GUILight;
import animeware.ui.themes.color.ColorScheme;
import net.minecraft.client.Minecraft;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	//public ArrayList<HudMod> hudMods;
	
	//public ToggleSprint togglesprint;
	public NotificationsModule notifs;
	
	public FPSMod fps;
	
	
	public TargetHUD thud;
	
	
	public Keystrokes keystrokes;
	
	
	//public MotionBlur motionblur;
	
	//public Watermark watermark;
	
	//public ToggleSprint togglesprint;
	
	public CPSMod cps;
	
	
	
	public static Freelook freelook;
	
	//public static Animeware animeware;
	
	public boolean TNTTimer;
	
	public PotionStatus potionStat;
	
	
	public Miniplayer lilplayer;
	
	public XYZMod xyz; 
	
	
	public BPSMod bps;
	
	
	public Ping ping;
	
	
	//public Fullbright fb;
	
	public Biome biome;
	
	
	public PackDisplay pd;
	
	
	public ServerIP sip;
	
	
	//public AnimewareText text;
	
	public TimeMod time;
	
	
	public ModArrows arrows;
	
	public ArmorStatus Armorstat;
	
	
	//public DynamicFOV fov;
	//public DirectionMod direction;
	
	public ToggleSprint3 ts;
	
	
	public ReachDisplayMod reachDisp;
	
	
	public ModDirection direction;
	
	
	
	public ModParticles particles;
	
	public ModMLDGHelper mldg;
	
	public PlayerHead head;
	
	public MemUsage mem;
	
	public ItemPhysics iphys;
	
	public BlockOverlay bo;
	
	
	public TNTTimer tnt;
	
	public ScrollZoom sz;
	
	public MoreParticles mp;
	
	public SmallSword smallsword;
	
	public SwordSpin swordspin;
	
	public Watermark watermark;
	
	public TimeChanger timeChanger;
	
		
	public HitColor hit;
	
	public ModHorseStats horseStat;
	
	public GUILight guiLight;
	
	public AstolfoButtons astolfobtn;
	
	public ColorScheme colorscheme;
	
	public Motionblurmodule mbm;
	
	public MinimalBobbing mBobbing;
	
	public WindowedFullscreenMod WindowedFullscreen;
	
	//public ModPusula dir2;
	
	//public Freelook freelook;
	
	//public static boolean OldAnimations;
	//public DirectionMod dirMod;
	
	public HudManager() {
		hudMods = new ArrayList<>();
		
		//hudMods.add(togglesprint = new ToggleSprint());
		hudMods.add(notifs = new NotificationsModule());
		
		hudMods.add(fps = new FPSMod());
		
		
		hudMods.add(thud = new TargetHUD());
		
		
		hudMods.add(keystrokes = new Keystrokes());
		
		
		//hudMods.add(motionblur = new MotionBlur());
		//hudMods.add(watermark = new Watermark());
		//hudMods.add(togglesprint = new ToggleSprint());
		
		hudMods.add(cps = new CPSMod());
		
		
		//hudMods.add(tnt = new TNTTimer());
		
		hudMods.add(potionStat = new PotionStatus());
		
		
		hudMods.add(lilplayer = new Miniplayer());
		
		hudMods.add(xyz = new XYZMod());
		
		
		hudMods.add(bps = new BPSMod());
		
		
		hudMods.add(ping = new Ping());
		
		
		//hudMods.add(fb = new Fullbright());
		
		hudMods.add(biome = new Biome());
		
		
		hudMods.add(pd = new PackDisplay());
		
		
		hudMods.add(sip = new ServerIP());
		
		
		hudMods.add(time = new TimeMod());
		
		
		hudMods.add(arrows = new ModArrows());
		
		hudMods.add(Armorstat = new ArmorStatus());
		
		
		//hudMods.add(bfs = new BorderlessFullscreen());
		
		//hudMods.add(fov = new DynamicFOV());
		
		//hudMods.add(text = new AnimewareText(null, 0, 0));
		
		hudMods.add(reachDisp = new ReachDisplayMod());
		
		
		hudMods.add(ts = new ToggleSprint3());
		
		//hudMods.add(clock = new Clock());
		//hudMods.add(dirMod = new DirectionMod());
		
		hudMods.add(freelook = new Freelook());
		
		hudMods.add(direction = new ModDirection());
		
		
		hudMods.add(particles = new ModParticles());
		
		hudMods.add(mldg = new ModMLDGHelper());
		
		hudMods.add(head = new PlayerHead());
		
		hudMods.add(mem = new MemUsage());
		
		hudMods.add(iphys = new ItemPhysics());
		
		hudMods.add(bo = new BlockOverlay());
		
		
		hudMods.add(tnt = new TNTTimer());
		
		hudMods.add(sz = new ScrollZoom());
		
		hudMods.add(mp = new MoreParticles());
		
		hudMods.add(smallsword = new SmallSword());
		
		hudMods.add(swordspin = new SwordSpin());
		
		hudMods.add(watermark = new Watermark());
		
		hudMods.add(timeChanger = new TimeChanger());
		
		hudMods.add(mBobbing = new MinimalBobbing());
		
		
		hudMods.add(hit = new HitColor());
		
		hudMods.add(horseStat = new ModHorseStats());
		
		hudMods.add(guiLight = new GUILight());
		
		hudMods.add(astolfobtn = new AstolfoButtons());
		
		hudMods.add(colorscheme = new ColorScheme());
		
		hudMods.add(WindowedFullscreen = new WindowedFullscreenMod());
		
		
		
		freelook = new Freelook();
		//api.register(freelook);

	}
	/*public void register(HUDManager api) {
		freelook = new Freelook();
		api.register(freelook);
		hudMods.add(freelook);
	}*/
	public static Freelook getFreelook() {
		return freelook;
	}
	
	
	
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled() && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			m.draw();
		   }
	   }
			
   }

	public HudMod getModule(String name) {
		for (HudMod m : hudMods) {
			if (m.name.equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}

}
