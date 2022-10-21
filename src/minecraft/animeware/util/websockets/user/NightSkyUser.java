package animeware.util.websockets.user;

public class NightSkyUser {

    public String mcName;
    public boolean isUser;

    public NightSkyUser(String mcName, boolean isUser) {;
        this.mcName = mcName;
        this.isUser = isUser;
    }

    public String getProperties() {
        return mcName + ":" + (isUser ? "true" : "false");
    }

    public String getMcName() {
        return mcName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }


    public void setUser(boolean user) {
        isUser = user;
    }
}
