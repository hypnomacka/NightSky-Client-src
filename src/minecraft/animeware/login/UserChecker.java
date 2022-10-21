package animeware.login;

import animeware.NightSky;
import animeware.util.backend.AntiCheat;

public class UserChecker {
	
	
	public boolean isUser() {
		String hwid =  AntiCheat.getHWID();
		
		for(User u : NightSky.getInstance().getUsers().getUsers()) {
			if(u.getHwid() == hwid) {
				return true;
			}
			else return false;
		}
		return false;

	}
	

}
