package animeware.ui.login;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import animeware.NightSky;
import animeware.gui.alt.Alt;
import animeware.gui.alt.AltLoginThread;
import animeware.gui.mainmenu.AltButton;
import animeware.gui.mainmenu.ClassicButton;
import animeware.gui.mainmenu.MainMenu;
import animeware.gui.mainmenu.MicrosoftButton;
import animeware.gui.mainmenu.QuitButton;
import animeware.ui.comp.MainMenuBtn;
import animeware.util.account.SessionChanger;
import animeware.util.font.FontUtil;
import animeware.util.render.DrawUtil;
import animeware.util.render.RoundedUtils;
import animeware.util.websockets.SocketClient;
import animeware.util.websockets.user.CheckName;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumChatFormatting;

public final class LoginScreen extends GuiScreen {
    private PasswordField password;
    private GuiScreen previousScreen;
    //private UserLoginThread thread;
    public static GuiTextField username;
    public AltLoginThread loginThread;
    public Alt selectedAlt = null;
	private AltLoginThread thread;

    public LoginScreen() {
        this.previousScreen = previousScreen;
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0: {
            	if(this.username.getText() == "" && this.password.getText() == "" || this.username.getText() == " " && this.password.getText() == " " || this.username.getText() == " " && this.password.getText() == "" || this.username.getText() == "" && this.password.getText() == " ") {
                } else {
            		
            		this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
                    this.thread.start();
            		NightSky.mcname = this.username.getText();
                    }
            	
                break;
            }            
            case 1: {
            	if(this.username.getText() == "" && this.password.getText() == "" || this.username.getText() == " " && this.password.getText() == " " || this.username.getText() == " " && this.password.getText() == "" || this.username.getText() == "" && this.password.getText() == " ") {
                } else {
            		
                	SessionChanger.getInstance().setUserMicrosoft(this.username.getText(), this.password.getText());
                	NightSky.mcname = this.username.getText();
            		
                    }
            	
                break;
            }   
            case 2: {
            	mc.displayGuiScreen(new MainMenu());          
            	break;
            }
    		}
    		
        }
    @Override
    public void initGui() {
        this.username = new GuiTextField(height / 4 + 24, this.mc.fontRendererObj, this.width / 2 - 100, this.height / 2 - 20, 200, 20);
        this.password = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 100, this.height / 2 + 5, 200, 20);
        this.buttonList.add(new MainMenuBtn(0, this.width / 2 - 100, this.height / 2 + 34, "Login"));
        //this.buttonList.add(new MainMenuBtn(1, this.width / 2 - 100, this.height / 2 + 60, "Login with Microsoft"));
        
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
        
    

    @Override
    public void drawScreen(int x2, int y2, float z2) {
        //this.drawDefaultBackground();
    	ScaledResolution sr = new ScaledResolution(mc);
    	GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
    	//DrawUtil.drawRoundedRect(325, 90, sr.getScaledWidth() -310, sr.getScaledHeight() - 220, 10, new Color(30, 30, 30, 150).getRGB());
		RoundedUtils.drawSmoothRoundedRect((this.width / 2 - 140), (this.height / 2 - 50), (this.width / 2 + 140), (this.height / 2 + 80), 18.0F, new Color(25, 25, 27, 255).getRGB());
        this.username.drawTextBox();
        this.password.drawTextBox();
        //FontUtil.normal.drawCenteredString("Animeware Client Login", width / 2, 130, -1);
        FontUtil.normal.drawCenteredString(this.thread == null ? (Object)((Object)EnumChatFormatting.GRAY) + "Idle..." : this.thread.getStatus(), width / 2, this.height / 2 - 39, -1);
        if (this.username.getText().isEmpty()) {
        	FontUtil.normal.drawString("Mail", this.width / 2 - 98, this.height / 2 - 12, -7829368);
        }
        if (this.password.getText().isEmpty()) {
        	FontUtil.normal.drawString("Password", this.width / 2 - 98, this.height / 2 + 13, -1);
        }
        
        super.drawScreen(x2, y2, z2);
    }

    

    @Override
    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            } else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (character == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
        this.password.textboxKeyTyped(character, key);
    }

    @Override
    protected void mouseClicked(int x2, int y2, int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
        this.password.mouseClicked(x2, y2, button);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    
}

