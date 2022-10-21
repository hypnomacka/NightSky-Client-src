package animeware.ui.login;

import java.net.Proxy;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import animeware.NightSky;
import animeware.gui.mainmenu.MainMenu;
import animeware.login.User;
import animeware.util.misc.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Session;

public final class UserLoginThread extends Thread {
    private final String password;
    private String status;
    private final String username;
    private Minecraft mc = Minecraft.getMinecraft();
    private Timer timer = new Timer();

    public UserLoginThread(String username, String password) {
        super("Alt Login Thread");
        this.username = username;
        this.password = password;
        this.status = (Object)((Object)EnumChatFormatting.GRAY) + "Waiting...";
    }

    private boolean User(String username, String password) {
        for(User u : NightSky.INSTANCE.users.getUsers()) {
        	if(u.getName().equals(username) && u.getPassword().equals(password)) {
        		return true;
        	}
        }
        return false;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public void run() {
        if (User(this.username, this.password)) {
            //this.mc.session = new Session(this.username, "", "", "mojang");
            this.status = (Object)((Object)EnumChatFormatting.GREEN) + "Logged in! (" + this.username + ")";
        	mc.displayGuiScreen(new MainMenu());
            return;
        }
        this.status = (Object)((Object)EnumChatFormatting.YELLOW) + "Logging in...";
        if (!User(this.username, this.password)) {
            this.status = (Object)((Object)EnumChatFormatting.RED) + "Login failed!";
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

