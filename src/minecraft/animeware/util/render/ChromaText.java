/*    */ package animeware.util.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ public class ChromaText
/*    */ {
/*    */   public static void drawChromaString(String string, int x, int y, boolean shadow) {
/* 10 */     Minecraft mc = Minecraft.getMinecraft();
/*    */     
/* 12 */     int xTmp = x; byte b; int i; char[] arrayOfChar;
/* 13 */     for (i = (arrayOfChar = string.toCharArray()).length, b = 0; b < i; ) { char textChar = arrayOfChar[b];
/* 14 */       long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
/* 15 */       int j = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
/* 16 */       String tmp = String.valueOf(textChar);
/* 17 */       mc.fontRendererObj.drawString(tmp, xTmp, y, j, shadow);
/* 18 */       xTmp += mc.fontRendererObj.getCharWidth(textChar);
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }
