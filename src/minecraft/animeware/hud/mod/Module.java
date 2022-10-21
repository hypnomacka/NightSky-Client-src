package animeware.hud.mod;

import org.lwjgl.input.Mouse;

import animeware.event.EventManager;
import animeware.hud.Category;
import animeware.util.MouseUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class Module {
  public Minecraft mc = Minecraft.getMinecraft();
  
  public FontRenderer fr = this.mc.fontRendererObj;
  
  protected MouseUtils msu = new MouseUtils();
  
  public String name;
  
  public String description;
  
  public boolean state;
  
  public Category cat;
  
  public float x;
  
  public float y;
  
  public float w;
  
  public float h;
  
  public float prog = 0.0F;
  
  public float anim = 22.0F;
  
  public float dragY;
  
  public float dragX;
  
  private boolean drag;
  
  public Module(String name, String description, Category cat, float x, float y, float w, float h) {
    this.name = name;
    this.description = description;
    this.cat = cat;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
  
  public void onEnable() {
    EventManager.register(this);
  }
  
  public void onDisable() {
    EventManager.unregister(this);
  }
  
  public void toggle() {
    this.state = !this.state;
    if (this.state) {
      onEnable();
    } else {
      onDisable();
    } 
  }
  
  public boolean hovered(int mouseX, int mouseY) {
    return (mouseX >= getX() + 0.5D && mouseX <= getX() + getW() - 0.5F && mouseY >= getY() + 0.5F && mouseY <= getY() + getH() - 0.5F);
  }
  
  public void drag(int mouseX, int mouseY) {
    boolean hovered = (mouseX >= getX() && mouseX <= getX() + getW() && mouseY >= getY() && mouseY <= getY() + getH());
    if (!this.drag && Mouse.isButtonDown(0))
      this.drag = false; 
    if (this.drag) {
      setX(mouseX + this.dragX);
      setY(mouseY + this.dragY);
      if (!Mouse.isButtonDown(0))
        this.drag = false; 
    } 
    if (hovered && Mouse.isButtonDown(0)) {
      if (this.x < 0.0F)
        setX(0.0F); 
      if (this.y < 0.0F)
        setY(0.0F); 
      if (!this.drag) {
        this.dragX = this.x - mouseX;
        this.dragY = this.y - mouseY;
        this.drag = true;
      } 
    } 
  }
  
  public void draw() {
    GlStateManager.color(1.0F, 1.0F, 1.0F);
  }
  
  public float getX() {
    if (this.x < 0.0F)
      this.x = 0.0F; 
    return this.x;
  }
  
  public void setX(float x) {
    this.x = x;
  }
  
  public float getY() {
    if (this.y < 0.0F)
      this.y = 0.0F; 
    return this.y;
  }
  
  public void setY(float y) {
    this.y = y;
  }
  
  public float getW() {
    return this.w;
  }
  
  public void setW(float w) {
    this.w = w;
  }
  
  public float getH() {
    return this.h;
  }
  
  public void setH(float h) {
    this.h = h;
  }
  
  public void drawCenteredString(String text, float f, float g, int color) {
    this.fr.drawStringWithShadow(text, f - (this.fr.getStringWidth(text) / 2), g, color);
  }
}
