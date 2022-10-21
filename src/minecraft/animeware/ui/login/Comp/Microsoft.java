package animeware.ui.login.Comp;

import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;

public class Microsoft {
	
	private void initGui() throws MicrosoftAuthenticationException {
		MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
		MicrosoftAuthResult result = authenticator.loginWithWebview();
		      // Or using a webview: authenticator.loginWithWebView();
		  // Or using refresh token: authenticator.loginWithRefreshToken("refresh token");
		   // Or using your own way: authenticator.loginWithTokens("access token", "refresh token");
		        
		System.out.printf("Logged in with '%s'%n", result.getProfile().getName());

	}
	
    
}