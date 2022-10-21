package animeware.util.account;

import java.awt.Color;
import java.util.ArrayList;

import animeware.hud.mod.HudMod;
import animeware.util.render.GuiUtils;
import animeware.util.render.ResourceUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class Account {
	
  public ArrayList<Account> accounts = new ArrayList<>();
	
  String username;
  
  String email;
  
  String accessToken;
  
  String uuid;
  
  float x;
  
  float y;
  
  Boolean cracked;
  
  Boolean active;
  
  public String getUsername() {
    return this.username;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public String getAccessToken() {
    return this.accessToken;
  }
  
  public String getUuid() {
    return this.uuid;
  }
  
  public float getX() {
    return this.x;
  }
  
  public float getY() {
    return this.y;
  }
  
  public void setX(float x) {
    this.x = x;
  }
  
  public void setY(float y) {
    this.y = y;
  }
  
  public Boolean getCracked() {
    return this.cracked;
  }
  
  public Boolean getActive() {
    return this.active;
  }
  
  public Account(String username, String email, String accessToken, String uuid, boolean cracked) {
    this.username = username;
    this.email = email;
    this.accessToken = accessToken;
    this.uuid = uuid;
    this.cracked = Boolean.valueOf(cracked);
  }
  
  public void render(float x, float y, float mx, float my) {
    this.x = x;
    this.y = y;
    Color background = isHovering(mx, my) ? new Color(200, 200, 200, 120) : new Color(200, 200, 200, 75);
    GuiUtils.drawRoundedRect(x, y, x + 10 + 45.0F, y + 24.0F, 5.0F, background.getRGB());
    GuiUtils.drawRoundedOutline(x, y, x + 10 + 45.0F, y + 24.0F, 5.0F, 2.0F, -1);
    //UrbanMainMenu.fontRenderer.drawString(getUsername(), x + 25.0F, y + 5.0F, (new Color(200, 200, 200, 200)).getRGB());
    Minecraft.getMinecraft().getTextureManager().bindTexture(ResourceUtils.getHeadLocation(getUsername()));
    Gui.drawModalRectWithCustomSizedTexture((int)x + 2, (int)y + 2, 0.0F, 0.0F, 20, 20, 20.0F, 20.0F);
  }
  
  public boolean isHovering(float mouseX, float mouseY) {
    return (mouseX >= this.x && mouseX <= 20 + 45.0F && mouseY >= this.y && mouseY <= this.y + 24.0F);
    //return (mouseX >= this.x && mouseX <= this.x + UrbanMainMenu.fontRenderer.getStringWidth(getUsername()) + 45.0F && mouseY >= this.y && mouseY <= this.y + 24.0F);
  }
  
  public void setActive(Boolean active) {
    this.active = active;
  }
}
