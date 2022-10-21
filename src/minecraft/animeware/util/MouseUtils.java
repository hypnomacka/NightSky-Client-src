package animeware.util;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;

public class MouseUtils {
  private boolean[] pressed = new boolean[] { Mouse.isButtonDown(0), Mouse.isButtonDown(1) };
  
  private long lastLmbPressed;
  
  private long lastRmbPressed;
  
  private boolean wasLmbPressed;
  
  private boolean wasRmbPressed;
  
  private ArrayList<Long> lmb = new ArrayList<>();
  
  private ArrayList<Long> rmb = new ArrayList<>();
  
}
