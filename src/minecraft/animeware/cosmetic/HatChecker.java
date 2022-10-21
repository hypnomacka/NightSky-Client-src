package animeware.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;

public class HatChecker {
	
	public static boolean ownsHat(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("hypnomacka")) {
			return true;
		} 
	
	
	
	
		else return false;
	}
	public static float[] getTopHatColor(AbstractClientPlayer entitylivingbaseIn) {
		return new float[] {1, 0, 1};
	}

}
