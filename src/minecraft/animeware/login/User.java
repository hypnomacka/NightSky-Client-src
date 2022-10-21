package animeware.login;

public class User {
	
	public String name, password, hwid, discord;
	public boolean staff, banned;
	
	public User(String name, String password, boolean staff, boolean banned, String hwid, String discord) {
		this.name = name;
		this.password = password;
		this.staff = staff;
		this.banned = banned;
		this.hwid = hwid;
		this.discord = discord;
	}

	public String getDiscord() {
		return discord;
	}

	public String getHwid() {
		return hwid;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isStaff() {
		return staff;
	}

	public boolean isBanned() {
		return banned;
	}

}
