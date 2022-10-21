package animeware.util.account;

import java.io.IOException;
import java.util.UUID;

import com.mojang.authlib.Agent;
import com.mojang.authlib.AuthenticationService;
import com.mojang.authlib.UserAuthentication;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.util.UUIDTypeAdapter;

import animeware.NightSky;
import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;



public class SessionChanger {

	private static SessionChanger instance;
	public final UserAuthentication auth;

	public static SessionChanger getInstance() {
		if (instance == null) {
			instance = new SessionChanger();
		}

		return instance;
	}
	
	//Creates a new Authentication Service. 
	private SessionChanger() {
		UUID notSureWhyINeedThis = UUID.randomUUID(); //Idk, needs a UUID. Seems to be fine making it random
		AuthenticationService authService = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), notSureWhyINeedThis.toString());
		auth = authService.createUserAuthentication(Agent.MINECRAFT);
		authService.createMinecraftSessionService();
	}

	
	//Online mode
	//Checks if your already loggin in to the account.
	/*public void setUser(String email, String password) {
		if(!Minecraft.getMinecraft().getSession().getUsername().equals(email) || Minecraft.getMinecraft().getSession().getToken().equals("0")){

			this.auth.logOut();
			this.auth.setUsername(email);
			this.auth.setPassword(password);
			try {
				this.auth.logIn();
				Session session = new Session(this.auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(auth.getSelectedProfile().getId()), this.auth.getAuthenticatedToken(), this.auth.getUserType().getName());
				setSession(session);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}*/
	public void setUser(String email, String password) {
		if(!Minecraft.getMinecraft().getSession().getUsername().equals(email) || Minecraft.getMinecraft().getSession().getToken().equals("0")){

			this.auth.logOut();
			this.auth.setUsername(email);
			this.auth.setPassword(password);
			try {
				this.auth.logIn();
				Session session = new Session(this.auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(auth.getSelectedProfile().getId()), this.auth.getAuthenticatedToken(), this.auth.getUserType().getName());
				setSession(session);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void setUserMicrosoft(String email, String password) {

		MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
		try {
			MicrosoftAuthResult acc = authenticator.loginWithCredentials(email, password);
			Minecraft.getMinecraft().session = new Session(acc.getProfile().getName(), acc.getProfile().getId(), acc.getAccessToken(), "legacy");

		} catch (MicrosoftAuthenticationException e) {

		}
	}
	

	  public void setUserMicrosoft(String accessToken) {
	    MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
	    try {
	      MicrosoftAuthResult acc = authenticator.loginWithRefreshToken(accessToken);
	      Session session = new Session(acc.getProfile().getName(), acc.getProfile().getId(), acc.getAccessToken(), "legacy");
	      setSession(session);
	      NightSky.getInstance().addAccount(new Account(acc.getProfile().getName(), "N/A", accessToken, acc.getProfile().getId(), true));
	    } catch (MicrosoftAuthenticationException microsoftAuthenticationException) {}
	  }
	  
	
	                 	
	public void microsoftLogin() {
		
		      MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
		        try {
		        MicrosoftAuthResult acc = authenticator.loginWithWebview();
		     Session session = new Session(acc.getProfile().getName(), acc.getProfile().getId(), acc.getAccessToken(), "legacy");
		        setSession(session);
		        //UrbanClient.getInstance().addAccount(new Account(acc.getProfile().getName(), "N/A", acc.getRefreshToken(), acc.getProfile().getId(), true));
		      } catch (MicrosoftAuthenticationException microsoftAuthenticationException) {
		    	  microsoftAuthenticationException.printStackTrace();
		      }
		     
	  
	  
    	}/*
	public void microsoftLogin(String mail, String pass) {
		MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
        MicrosoftAuthResult result = null;
        try {
            result = authenticator.loginWithCredentials(mail,pass);
            System.out.printf("Logged in with '%s'%n", result.getProfile().getName());
            Minecraft.getMinecraft().session = new Session(result.getProfile().getName(),result.getProfile().getId(), result.getAccessToken(),"legacy");


        } catch (MicrosoftAuthenticationException e) {
            e.printStackTrace();
        }

	}*/
	

	//Sets the session.
		//You need to make this public, and remove the final modifier on the session Object.
		public void setSession(Session session) {
			Minecraft.getMinecraft().session = session;
		}

		//Login offline mode
		//Just like MCP does
		public void setUserOffline(String username) {
			this.auth.logOut();
			Session session = new Session(username, username, "0", "legacy");
			setSession(session);
		}

}