package animeware.cosmetic;

import java.util.ArrayList;

import animeware.cosmetic.impl.ChinaHat;
import animeware.cosmetic.impl.CosmeticCreeperLightning;
import animeware.cosmetic.impl.CosmeticEnchantingGlint;
import animeware.cosmetic.impl.CosmeticWitherpet;
import animeware.cosmetic.impl.CosmeticMods.Bandana;
import animeware.cosmetic.impl.CosmeticMods.Blaze;
import animeware.cosmetic.impl.CosmeticMods.Cape;
import animeware.cosmetic.impl.CosmeticMods.ChinaHatModule;
import animeware.cosmetic.impl.CosmeticMods.CosmeticEasterEggs;
import animeware.cosmetic.impl.CosmeticMods.CosmeticWitchHat;
import animeware.cosmetic.impl.CosmeticMods.CreeperLight;
import animeware.cosmetic.impl.CosmeticMods.CrystalWings;
import animeware.cosmetic.impl.CosmeticMods.DarkCape;
import animeware.cosmetic.impl.CosmeticMods.DevCape;
import animeware.cosmetic.impl.CosmeticMods.DragonWings;
import animeware.cosmetic.impl.CosmeticMods.EmeraldCape;
import animeware.cosmetic.impl.CosmeticMods.EnchGlint;
import animeware.cosmetic.impl.CosmeticMods.GalaxyWings;
import animeware.cosmetic.impl.CosmeticMods.Glasses;
import animeware.cosmetic.impl.CosmeticMods.GradientBlack;
import animeware.cosmetic.impl.CosmeticMods.GradientBlue;
import animeware.cosmetic.impl.CosmeticMods.GradientGreen;
import animeware.cosmetic.impl.CosmeticMods.GradientPurple;
import animeware.cosmetic.impl.CosmeticMods.GradientRed;
import animeware.cosmetic.impl.CosmeticMods.Halo;
import animeware.cosmetic.impl.CosmeticMods.LCape;
import animeware.cosmetic.impl.CosmeticMods.NitroCape;
import animeware.cosmetic.impl.CosmeticMods.OwnerCape;
import animeware.cosmetic.impl.CosmeticMods.PlanetsCape;
import animeware.cosmetic.impl.CosmeticMods.QuavCape;
import animeware.cosmetic.impl.CosmeticMods.QuickCape;
import animeware.cosmetic.impl.CosmeticMods.ReptyllCape;
import animeware.cosmetic.impl.CosmeticMods.RetardEyes;
import animeware.cosmetic.impl.CosmeticMods.RinneCape;
import animeware.cosmetic.impl.CosmeticMods.Sparkofyt;
import animeware.cosmetic.impl.CosmeticMods.Sparkofyt2;
import animeware.cosmetic.impl.CosmeticMods.SwordCape;
import animeware.cosmetic.impl.CosmeticMods.WitherPet;
import animeware.cosmetic.impl.CosmeticMods.YTCape;
import animeware.cosmetic.impl.CosmeticMods.dseyes2cape;
import animeware.cosmetic.impl.CosmeticMods.dseyescape;
import animeware.cosmetic.impl.CosmeticMods.kocho2cape;
import animeware.cosmetic.impl.CosmeticMods.kocho3cape;
import animeware.cosmetic.impl.CosmeticMods.tanjirocape;


public class CosmeticManager {
	
	public static ArrayList<CosmeticModule> cosmetics = new ArrayList<>();
	
	public Cape zerotwo;
	public DarkCape darkCape;
	public dseyes2cape deamoneyes;
	public dseyescape deamoneyes2;
	public EmeraldCape ecape;
	public GradientBlack gblack;
	public GradientBlue gblue;
	public GradientGreen ggreen;
	public GradientPurple gpurple;
	public GradientRed gred;
	public kocho2cape kcape;
	public kocho3cape kcape2;
	public LCape lcape;
	public NitroCape ncape;
	public PlanetsCape pcape;
	public QuavCape quavcape;
	public QuickCape quickcape;
	public ReptyllCape rcape;
	public SwordCape scape;
	public tanjirocape tcape;
	public Sparkofyt sofyt;
	public Sparkofyt2 sofyt2;
	
	public CrystalWings cwings;
	public DragonWings dwings;
	public GalaxyWings gwings;
	
	public CosmeticEasterEggs eggs;
	public CosmeticWitchHat witchhat;
	public Glasses glasses;
	public Halo halo;
	public RetardEyes retardeyes;
	
	public OwnerCape ownerCape;
	public DevCape devCape;
	public YTCape ytCape;
	
	public Blaze blaze;
	
	public Bandana ban;
	public CreeperLight creeper;
	//public ChinaHat ch;
	public WitherPet wpet;
	
	public ChinaHatModule ch;
	public RinneCape rinn;
	
	public CosmeticManager() {
		cosmetics = new ArrayList<>();
		cosmetics.add(zerotwo = new Cape());
		cosmetics.add(darkCape = new DarkCape());
		cosmetics.add(deamoneyes = new dseyes2cape());
		cosmetics.add(deamoneyes2 = new dseyescape());
		cosmetics.add(ecape = new EmeraldCape());
		cosmetics.add(gblack = new GradientBlack());
		cosmetics.add(gblue = new GradientBlue());
		cosmetics.add(ggreen = new GradientGreen());
		cosmetics.add(gpurple = new GradientPurple());
		cosmetics.add(gred = new GradientRed());
		cosmetics.add(kcape = new kocho2cape());
		cosmetics.add(kcape2 = new kocho3cape());
		cosmetics.add(lcape = new LCape());
		cosmetics.add(ncape = new NitroCape());
		cosmetics.add(pcape = new PlanetsCape());
		cosmetics.add(quavcape = new QuavCape());
		cosmetics.add(quickcape = new QuickCape());
		cosmetics.add(rcape = new ReptyllCape());
		cosmetics.add(scape = new SwordCape());
		cosmetics.add(tcape = new tanjirocape());
		cosmetics.add(sofyt = new Sparkofyt());
		cosmetics.add(sofyt2 = new Sparkofyt2());
		
		cosmetics.add(cwings = new CrystalWings());
		cosmetics.add(dwings = new DragonWings());
		cosmetics.add(gwings = new GalaxyWings());
		
		cosmetics.add(eggs = new CosmeticEasterEggs());
		cosmetics.add(witchhat = new CosmeticWitchHat());
		cosmetics.add(glasses = new Glasses());
		cosmetics.add(halo = new Halo());
		cosmetics.add(retardeyes = new RetardEyes());
		
		cosmetics.add(ownerCape = new OwnerCape());
		cosmetics.add(devCape = new DevCape());

		cosmetics.add(blaze = new Blaze());
		
		cosmetics.add(ban = new Bandana());
		cosmetics.add(creeper = new CreeperLight());
		//cosmetics.add(ch = new ChinaHat());
		cosmetics.add(wpet = new WitherPet());
		
		cosmetics.add(ch = new ChinaHatModule());
		cosmetics.add(rinn = new RinneCape());
		
	}	
	public static ArrayList<CosmeticModule> getCosmetics() {
		return cosmetics;
	}
		
			
}


