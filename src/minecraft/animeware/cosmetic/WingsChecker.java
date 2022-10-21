package animeware.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;

public class WingsChecker {
	
	public static boolean ownsWings(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("hypnomacka")) {
			return true;
		} 
	
	
	
	
		else return false;
	}

}
