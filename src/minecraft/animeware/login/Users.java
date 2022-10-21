package animeware.login;

import java.util.ArrayList;

public class Users {
	
	public ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void addUsers() {
		users.add(new User("hypnomacka", "isVeryCool69", true, false, "none", "hypnomacka#4765"));
	}

}
