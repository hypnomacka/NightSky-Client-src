package animeware.cosmetic;

import java.lang.reflect.Array;
import java.util.ArrayList;

import animeware.cosmetic.impl.TopHat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	
	
	public static boolean shouldRenderOwnerCape(AbstractClientPlayer player) {
		//if(CosmeticManager.ownerCape.isWearing() && CosmeticManager.ownerCape.ownsCosmetic()) {
		if(player.getName().equals("hypnomacka")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean shouldRenderQuickCape(AbstractClientPlayer player) {
		//if(CosmeticManager.quickCape.isWearing() && CosmeticManager.quickCape.ownsCosmetic()) {
		if(player.getName().equals("quickDaffy")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean shouldRenderYTCape(AbstractClientPlayer player) {
		//if(CosmeticManager.ytCape.isWearing() && CosmeticManager.ytCape.ownsCosmetic()) {
		if(player.getName().equals("_Marto__")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean shouldRenderDevCape(AbstractClientPlayer player) {
		//if(CosmeticManager.devCape.isWearing() && CosmeticManager.devCape.ownsCosmetic()) {
		if(player.getName().equals("KnownAsR3named")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean shouldZeroTwoCape(AbstractClientPlayer player) {
		//if(CosmeticManager.cape.isWearing() && CosmeticManager.cape.ownsCosmetic()) {
		if(player.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
			return true;
		} else {
			return false;
		}
	}
	/*public static boolean shouldRenderWings(AbstractClientPlayer entitylivingbaseIn) {
		return false;
	}*/
	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
		//if(CosmeticManager.topHat.isWearing() && CosmeticManager.topHat.ownsCosmeticHat()) {
		if(player.getName().equals("hypnomacka")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean shouldRenderHalo(AbstractClientPlayer player){
		if(player.getName().equals("hypnomacka")) {
			return true;
		} else {
			return false;
		}
		
	}
	/*public static float[] getTopHatColor(AbstractClientPlayer player) {
		return new float[] {1, 0, 0};
	}*/
}
