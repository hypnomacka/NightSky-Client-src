package animeware.util.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.UserAuthentication;
import com.mojang.util.UUIDTypeAdapter;

import animeware.NightSky;
import animeware.util.account.Account;
import animeware.util.account.SessionChanger;
import net.minecraft.util.Session;

public class AccountConfig {
  public final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
  
  public final File file = new File("NightSky/Account.ns");
  
  public void save() {
    JsonArray accounts = new JsonArray();
    for (Account a : NightSky.accountManager) {
      a.setActive(Boolean.valueOf(false));
      JsonObject jsonAccount = new JsonObject();
      jsonAccount.addProperty("accessToken", a.getAccessToken());
      jsonAccount.addProperty("username", a.getUsername());
      jsonAccount.addProperty("uuid", a.getUuid());
      jsonAccount.addProperty("email", a.getEmail());
      jsonAccount.addProperty("microsoft", a.getCracked());
      if (a.equals(NightSky.accountManager.get(NightSky.accountManager.size() - 1)))
        a.setActive(Boolean.valueOf(true)); 
      jsonAccount.addProperty("active", a.getActive());
      accounts.add((JsonElement)jsonAccount);
    } 
    if (!this.file.getParentFile().exists())
      this.file.getParentFile().mkdirs(); 
    String s = this.gson.toJson((JsonElement)accounts);
    try {
      this.file.createNewFile();
      FileWriter fw = new FileWriter(this.file.getPath());
      fw.write(s);
      fw.flush();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void load() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(this.file.getPath()));
      JsonArray accounts = (JsonArray)this.gson.fromJson(br, JsonArray.class);
      if (!accounts.isJsonNull() && 
        accounts.size() > 0) {
        JsonObject account = accounts.get(accounts.size() - 1).getAsJsonObject();
        for (JsonElement je : accounts) {
          if (je.getAsJsonObject().get("active").getAsBoolean()) {
            account = je.getAsJsonObject();
            String str5 = account.get("accessToken").getAsString();
            String str6 = account.get("username").getAsString();
            String str7 = account.get("uuid").getAsString();
            String str8 = account.get("email").getAsString();
            boolean bool1 = account.get("microsoft").getAsBoolean();
            NightSky.accountManager.add(new Account(str6, str8, str5, str7, bool1));
            continue;
          } 
          String str1 = je.getAsJsonObject().get("accessToken").getAsString();
          String str2 = je.getAsJsonObject().get("username").getAsString();
          String str3 = je.getAsJsonObject().get("uuid").getAsString();
          String str4 = je.getAsJsonObject().get("email").getAsString();
          boolean bool = je.getAsJsonObject().get("microsoft").getAsBoolean();
          NightSky.accountManager.add(new Account(str2, str4, str1, str3, bool));
        } 
        String accessToken = account.get("accessToken").getAsString();
        String username = account.get("username").getAsString();
        String uuid = account.get("uuid").getAsString();
        String email = account.get("email").getAsString();
        boolean microsoft = account.get("microsoft").getAsBoolean();
        if (microsoft) {
          SessionChanger.getInstance().setUserMicrosoft(accessToken);
        } else {
          SessionChanger.getInstance().setSession(new Session(username, uuid, accessToken, "mojang"));
          UserAuthentication auth = (SessionChanger.getInstance()).auth;
          auth.setUsername(email);
          auth.logIn();
          Session session = new Session(auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(auth.getSelectedProfile().getId()), auth.getAuthenticatedToken(), auth.getSelectedProfile().getName());
          SessionChanger.getInstance().setSession(session);
        } 
      } 
    } catch (FileNotFoundException|com.mojang.authlib.exceptions.AuthenticationException e) {
      e.printStackTrace();
    } 
  }
}
