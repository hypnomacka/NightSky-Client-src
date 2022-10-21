/*     */ package animeware.util.font.JCFont;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;

/*     */ import org.lwjgl.opengl.GL11;

/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class cFontRenderer extends FontRenderer {
/*     */   public final Random fontRandom;
/*     */   private final Color[] customColorCodes;
/*     */   private final int[] colorCode;
/*     */   private FontAtacher font;
/*     */   private FontAtacher boldFont;
/*     */   private FontAtacher italicFont;
/*     */   private FontAtacher boldItalicFont;
/*     */   private String colorcodeIdentifiers;
/*  27 */   public static Minecraft mc = Minecraft.getMinecraft();
/*     */   private boolean bidi;
/*     */   
/*     */   public cFontRenderer(Font font, boolean antiAlias, int charOffset) {
/*  31 */     super(mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().getTextureManager(), false);
/*  32 */     this.fontRandom = new Random();
/*  33 */     this.customColorCodes = new Color[256];
/*  34 */     this.colorCode = new int[32];
/*  35 */     this.colorcodeIdentifiers = "0123456789abcdefklmnor";
/*  36 */     setFont(font, antiAlias, charOffset);
/*  37 */     this.customColorCodes[113] = new Color(0, 90, 163);
/*  38 */     this.colorcodeIdentifiers = setupColorcodeIdentifier();
/*  39 */     setupMinecraftColorcodes();
/*  40 */     this.FONT_HEIGHT = (int)getHeight();
/*     */   }
/*     */   
/*     */   public int drawString(String s, float x, float y, int color) {
/*  44 */     drawString(s, x, y, color, false);
/*  45 */     return drawString(s, x, y, color, false) + 1;
/*     */   }
/*     */   
/*     */   public void drawCenteredStringXY(String s, float x, float y, int color, boolean shadow) {
/*  49 */     drawCenteredString(s, x, y - getHeight() / 2.0F, color, shadow);
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String s, float x, float y, int color) {
/*  53 */     drawString(s, x + 1.0F, y + 1.0F, color, true);
/*  54 */     return drawString(s, x, y, color, false) + 1;
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, float x, float y, int color, boolean shadow) {
/*  58 */     if (shadow) {
/*  59 */       drawStringWithShadow(s, x - (getStringWidth(s) / 2), y, color);
/*     */     } else {
/*  61 */       drawString(s, x - (getStringWidth(s) / 2), y, color);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, double d, double e, int color) {
/*  66 */     drawStringWithShadow(s, (float)(d - (getStringWidth(s) / 2)), (float)e, color);
/*     */   }
/*     */   
/*     */   public int func_175063_a(String message, float posX, float posY, int textColor) {
/*  70 */     return drawStringWithShadow(message, posX, posY, textColor);
/*     */   }
/*     */   
/*     */   public int drawString(String text, float x, float y, int color, boolean shadow) {
/*  74 */     int result = 0;
/*  75 */     String[] lines = text.split("\n");
/*     */     
/*  77 */     for (int i = 0; i < lines.length; i++) {
/*  78 */       result = drawLine(lines[i], x, y + i * getHeight(), color, shadow);
/*     */     }
/*     */     
/*  81 */     return result;
/*     */   }
/*     */   
/*     */   private int drawLine(String text, float x, float y, int color, boolean shadow) {
/*  85 */     if (text == null) {
/*  86 */       return 0;
/*     */     }
/*  88 */     GL11.glPushMatrix();
/*  89 */     GL11.glTranslated(x - 1.5D, y + 0.5D, 0.0D);
/*  90 */     boolean wasBlend = GL11.glGetBoolean(3042);
/*  91 */     GlStateManager.enableAlpha();
/*  92 */     GL11.glEnable(3042);
/*  93 */     GL11.glBlendFunc(770, 771);
/*  94 */     GL11.glEnable(3553);
/*  95 */     if ((color & 0xFC000000) == 0) {
/*  96 */       color |= 0xFF000000;
/*     */     }
/*     */     
/*  99 */     if (shadow) {
/* 100 */       color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
/*     */     }
/*     */     
/* 103 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 104 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 105 */     float blue = (color & 0xFF) / 255.0F;
/* 106 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 107 */     Color c = new Color(red, green, blue, alpha);
/* 108 */     if (text.contains("§")) {
/* 109 */       String[] parts = text.split("§");
/* 110 */       Color currentColor = c;
/* 111 */       FontAtacher currentFont = this.font;
/* 112 */       int width = 0;
/* 113 */       boolean randomCase = false;
/* 114 */       boolean bold = false;
/* 115 */       boolean italic = false;
/* 116 */       boolean strikethrough = false;
/* 117 */       boolean underline = false;
/*     */       
/* 119 */       for (int index = 0; index < parts.length; index++) {
/* 120 */         if (parts[index].length() > 0) {
/* 121 */           if (index == 0) {
/* 122 */             currentFont.drawString(parts[index], width, 0.0D, currentColor, shadow);
/* 123 */             width += currentFont.getStringWidth(parts[index]);
/*     */           } else {
/* 125 */             String words = parts[index].substring(1);
/* 126 */             char type = parts[index].charAt(0);
/* 127 */             int colorIndex = this.colorcodeIdentifiers.indexOf(type);
/* 128 */             if (colorIndex != -1) {
/* 129 */               if (colorIndex < 16) {
/* 130 */                 int colorcode = this.colorCode[colorIndex];
/* 131 */                 currentColor = getColor(colorcode, alpha);
/* 132 */                 bold = false;
/* 133 */                 italic = false;
/* 134 */                 randomCase = false;
/* 135 */                 underline = false;
/* 136 */                 strikethrough = false;
/* 137 */               } else if (colorIndex == 16) {
/* 138 */                 randomCase = true;
/* 139 */               } else if (colorIndex == 17) {
/* 140 */                 bold = true;
/* 141 */               } else if (colorIndex == 18) {
/* 142 */                 strikethrough = true;
/* 143 */               } else if (colorIndex == 19) {
/* 144 */                 underline = true;
/* 145 */               } else if (colorIndex == 20) {
/* 146 */                 italic = true;
/* 147 */               } else if (colorIndex == 21) {
/* 148 */                 bold = false;
/* 149 */                 italic = false;
/* 150 */                 randomCase = false;
/* 151 */                 underline = false;
/* 152 */                 strikethrough = false;
/* 153 */                 currentColor = c;
/* 154 */               } else if (colorIndex > 21) {
/* 155 */                 Color customColor = this.customColorCodes[type];
/* 156 */                 currentColor = new Color(customColor.getRed() / 255.0F, customColor.getGreen() / 255.0F, customColor.getBlue() / 255.0F, alpha);
/*     */               } 
/*     */             }
/*     */             
/* 160 */             if (bold && italic) {
/* 161 */               this.boldItalicFont.drawString(randomCase ? toRandom(currentFont, words) : words, width, 0.0D, currentColor, shadow);
/* 162 */               currentFont = this.boldItalicFont;
/* 163 */             } else if (bold) {
/* 164 */               this.boldFont.drawString(randomCase ? toRandom(currentFont, words) : words, width, 0.0D, currentColor, shadow);
/* 165 */               currentFont = this.boldFont;
/* 166 */             } else if (italic) {
/* 167 */               this.italicFont.drawString(randomCase ? toRandom(currentFont, words) : words, width, 0.0D, currentColor, shadow);
/* 168 */               currentFont = this.italicFont;
/*     */             } else {
/* 170 */               this.font.drawString(randomCase ? toRandom(currentFont, words) : words, width, 0.0D, currentColor, shadow);
/* 171 */               currentFont = this.font;
/*     */             } 
/*     */             
/* 174 */             float u = this.font.getHeight() / 16.0F;
/* 175 */             int h = currentFont.getStringHeight(words);
/* 176 */             if (strikethrough) {
/* 177 */               drawLine(width / 2.0D + 1.0D, (h / 3), (width + currentFont.getStringWidth(words)) / 2.0D + 1.0D, (h / 3), u);
/*     */             }
/*     */             
/* 180 */             if (underline) {
/* 181 */               drawLine(width / 2.0D + 1.0D, (h / 2), (width + currentFont.getStringWidth(words)) / 2.0D + 1.0D, (h / 2), u);
/*     */             }
/*     */             
/* 184 */             width += currentFont.getStringWidth(words);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } else {
/* 189 */       this.font.drawString(text, 0.0D, 0.0D, c, shadow);
/*     */     } 
/*     */     
/* 192 */     if (!wasBlend) {
/* 193 */       GL11.glDisable(3042);
/*     */     }
/*     */     
/* 196 */     GL11.glPopMatrix();
/* 197 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 198 */     return (int)(x + getStringWidth(text));
/*     */   }
/*     */ 
/*     */   
/*     */   private String toRandom(FontAtacher font, String text) {
/* 203 */     String newText = "";
/* 204 */     String allowedCharacters = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000";
/*     */     char[] var8;
/* 206 */     int var7 = (var8 = text.toCharArray()).length;
/*     */     
/* 208 */     for (int var6 = 0; var6 < var7; var6++) {
/* 209 */       char c = var8[var6];
/* 210 */       if (ChatAllowedCharacters.isAllowedCharacter(c)) {
/* 211 */         int index = this.fontRandom.nextInt("ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000".length());
/* 212 */         newText = String.valueOf(String.valueOf(newText)) + "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000".toCharArray()[index];
/*     */       } 
/*     */     } 
/* 215 */     return newText;
/*     */   }
/*     */   
/*     */   public float getStringHeight(String text) {
/* 219 */     if (text == null) {
/* 220 */       return 0.0F;
/*     */     }
/* 222 */     return this.font.getStringHeight(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 227 */     return this.font.getHeight();
/*     */   }
/*     */   
/*     */   public static String getFormatFromString(String p_78282_0_) {
/* 231 */     String var1 = "";
/* 232 */     int var2 = -1;
/* 233 */     int var3 = p_78282_0_.length();
/*     */     
/* 235 */     while ((var2 = p_78282_0_.indexOf('§', var2 + 1)) != -1) {
/* 236 */       if (var2 < var3 - 1) {
/* 237 */         char var4 = p_78282_0_.charAt(var2 + 1);
/* 238 */         if (isFormatColor(var4)) {
/* 239 */           var1 = "§" + var4; continue;
/* 240 */         }  if (isFormatSpecial(var4)) {
/* 241 */           var1 = String.valueOf(var1) + "§" + var4;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 246 */     return var1;
/*     */   }
/*     */   
/*     */   private static boolean isFormatSpecial(char formatChar) {
/* 250 */     return !((formatChar < 'k' || formatChar > 'o') && (formatChar < 'K' || formatChar > 'O') && formatChar != 'r' && formatChar != 'R');
/*     */   }
/*     */   
/*     */   public int getColorCode(char p_175064_1_) {
/* 254 */     return this.colorCode["0123456789abcdef".indexOf(p_175064_1_)];
/*     */   }
/*     */   
/*     */   public void setBidiFlag(boolean state) {
/* 258 */     this.bidi = state;
/*     */   }
/*     */   
/*     */   public boolean getBidiFlag() {
/* 262 */     return this.bidi;
/*     */   }
/*     */   
/*     */   private int sizeStringToWidth(String str, int wrapWidth) {
/* 266 */     int var3 = str.length();
/* 267 */     int var4 = 0;
/* 268 */     int var5 = 0;
/* 269 */     int var6 = -1;
/*     */     
/* 271 */     for (boolean var7 = false; var5 < var3; var5++) {
/* 272 */       char var8 = str.charAt(var5);
/* 273 */       switch (var8) {
/*     */         case '\n':
/* 275 */           var5--;
/*     */           break;
/*     */         case ' ':
/* 278 */           var6 = var5;
/*     */         default:
/* 280 */           var4 += getStringWidth(Character.toString(var8));
/* 281 */           if (var7) {
/* 282 */             var4++;
/*     */           }
/*     */           break;
/*     */         case '§':
/* 286 */           if (var5 < var3 - 1) {
/* 287 */             var5++;
/* 288 */             char var9 = str.charAt(var5);
/* 289 */             if (var9 != 'l' && var9 != 'L') {
/* 290 */               if (var9 == 'r' || var9 == 'R' || isFormatColor(var9))
/* 291 */                 var7 = false; 
/*     */               break;
/*     */             } 
/* 294 */             var7 = true;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       
/* 299 */       if (var8 == '\n') {
/*     */         
/* 301 */         var6 = ++var5;
/*     */         
/*     */         break;
/*     */       } 
/* 305 */       if (var4 > wrapWidth) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 310 */     return (var5 != var3 && var6 != -1 && var6 < var5) ? var6 : var5;
/*     */   }
/*     */   
/*     */   private static boolean isFormatColor(char colorChar) {
/* 314 */     return !((colorChar < '0' || colorChar > '9') && (colorChar < 'a' || colorChar > 'f') && (colorChar < 'A' || colorChar > 'F'));
/*     */   }
/*     */   
/*     */   public int getCharWidth(char c) {
/* 318 */     return getStringWidth(Character.toString(c));
/*     */   }
/*     */   
/*     */   public int getStringWidth(String text) {
/* 322 */     if (text == null)
/* 323 */       return 0; 
/* 324 */     if (!text.contains("§")) {
/* 325 */       return this.font.getStringWidth(text);
/*     */     }
/* 327 */     String[] parts = text.split("§");
/* 328 */     FontAtacher currentFont = this.font;
/* 329 */     int width = 0;
/* 330 */     boolean bold = false;
/* 331 */     boolean italic = false;
/*     */     
/* 333 */     for (int index = 0; index < parts.length; index++) {
/* 334 */       if (parts[index].length() > 0) {
/* 335 */         if (index == 0) {
/* 336 */           width += currentFont.getStringWidth(parts[index]);
/*     */         } else {
/* 338 */           String words = parts[index].substring(1);
/* 339 */           char type = parts[index].charAt(0);
/* 340 */           int colorIndex = this.colorcodeIdentifiers.indexOf(type);
/* 341 */           if (colorIndex != -1) {
/* 342 */             if (colorIndex < 16) {
/* 343 */               bold = false;
/* 344 */               italic = false;
/* 345 */             } else if (colorIndex != 16) {
/* 346 */               if (colorIndex == 17) {
/* 347 */                 bold = true;
/* 348 */               } else if (colorIndex != 18 && colorIndex != 19) {
/* 349 */                 if (colorIndex == 20) {
/* 350 */                   italic = true;
/* 351 */                 } else if (colorIndex == 21) {
/* 352 */                   bold = false;
/* 353 */                   italic = false;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */           
/* 359 */           if (bold && italic) {
/* 360 */             currentFont = this.boldItalicFont;
/* 361 */           } else if (bold) {
/* 362 */             currentFont = this.boldFont;
/* 363 */           } else if (italic) {
/* 364 */             currentFont = this.italicFont;
/*     */           } else {
/* 366 */             currentFont = this.font;
/*     */           } 
/*     */           
/* 369 */           width += currentFont.getStringWidth(words);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 374 */     return width;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font, boolean antiAlias, int charOffset) {
/* 379 */     synchronized (this) {
/* 380 */       this.font = new FontAtacher(font, antiAlias, charOffset);
/* 381 */       this.boldFont = new FontAtacher(font.deriveFont(1), antiAlias, charOffset);
/* 382 */       this.italicFont = new FontAtacher(font.deriveFont(2), antiAlias, charOffset);
/* 383 */       this.boldItalicFont = new FontAtacher(font.deriveFont(3), antiAlias, charOffset);
/* 384 */       this.FONT_HEIGHT = (int)getHeight();
/*     */     } 
/*     */   }
/*     */   
/*     */   public FontAtacher getFont() {
/* 389 */     return this.font;
/*     */   }
/*     */   
/*     */   public String getFontName() {
/* 393 */     return this.font.getFont().getFontName();
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 397 */     return this.font.getFont().getSize();
/*     */   }
/*     */   
/*     */   public List wrapWords(String text, double width) {
/* 401 */     List<String> finalWords = new ArrayList();
/* 402 */     if (getStringWidth(text) > width) {
/* 403 */       String[] words = text.split(" ");
/* 404 */       String currentWord = "";
/* 405 */       char lastColorCode = Character.MAX_VALUE;
/* 406 */       String[] var11 = words;
/* 407 */       int var10 = words.length;
/*     */ 
/*     */       
/* 410 */       for (int var9 = 0; var9 < var10; var9++) {
/* 411 */         String s = var11[var9];
/*     */         
/* 413 */         for (int i = 0; i < (s.toCharArray()).length; i++) {
/* 414 */           char c = s.toCharArray()[i];
/* 415 */           if (c == '§' && i < (s.toCharArray()).length - 1) {
/* 416 */             lastColorCode = s.toCharArray()[i + 1];
/*     */           }
/*     */         } 
/*     */         
/* 420 */         if (getStringWidth(String.valueOf(currentWord) + s + " ") < width) {
/* 421 */           currentWord = String.valueOf(currentWord) + s + " ";
/*     */         } else {
/* 423 */           finalWords.add(currentWord);
/* 424 */           currentWord = (lastColorCode == -1) ? (String.valueOf(s) + " ") : ("§" + lastColorCode + s + " ");
/*     */         } 
/*     */       } 
/*     */       
/* 428 */       if (!currentWord.equals("")) {
/* 429 */         if (getStringWidth(currentWord) < width) {
/* 430 */           finalWords.add((lastColorCode == -1) ? (String.valueOf(currentWord) + " ") : ("§" + lastColorCode + currentWord + " "));
/* 431 */           currentWord = "";
/*     */         } else {
/* 433 */           Iterator<String> var14 = formatString(currentWord, width).iterator();
/*     */           
/* 435 */           while (var14.hasNext()) {
/* 436 */             String s = var14.next();
/* 437 */             finalWords.add(s);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/* 442 */       finalWords.add(text);
/*     */     } 
/*     */     
/* 445 */     return finalWords;
/*     */   }
/*     */   
/*     */   public List formatString(String s, double width) {
/* 449 */     List<String> finalWords = new ArrayList();
/* 450 */     String currentWord = "";
/* 451 */     char lastColorCode = Character.MAX_VALUE;
/*     */     
/* 453 */     for (int i = 0; i < (s.toCharArray()).length; i++) {
/* 454 */       char c = s.toCharArray()[i];
/* 455 */       if (c == '§' && i < (s.toCharArray()).length - 1) {
/* 456 */         lastColorCode = s.toCharArray()[i + 1];
/*     */       }
/*     */       
/* 459 */       if (getStringWidth(String.valueOf(currentWord) + c) < width) {
/* 460 */         currentWord = String.valueOf(currentWord) + c;
/*     */       } else {
/* 462 */         finalWords.add(currentWord);
/* 463 */         currentWord = (lastColorCode == -1) ? String.valueOf(c) : ("§" + lastColorCode + c);
/*     */       } 
/*     */     } 
/*     */     
/* 467 */     if (!currentWord.equals("")) {
/* 468 */       finalWords.add(currentWord);
/*     */     }
/*     */     
/* 471 */     return finalWords;
/*     */   }
/*     */   
/*     */   private void drawLine(double x, double y, double x1, double y1, float width) {
/* 475 */     GL11.glDisable(3553);
/* 476 */     GL11.glLineWidth(width);
/* 477 */     GL11.glBegin(1);
/* 478 */     GL11.glVertex2d(x, y);
/* 479 */     GL11.glVertex2d(x1, y1);
/* 480 */     GL11.glEnd();
/* 481 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public boolean isAntiAliasing() {
/* 485 */     return (this.font.isAntiAlias() && this.boldFont.isAntiAlias() && this.italicFont.isAntiAlias() && this.boldItalicFont.isAntiAlias());
/*     */   }
/*     */   
/*     */   public void setAntiAliasing(boolean antiAlias) {
/* 489 */     this.font.setAntiAlias(antiAlias);
/* 490 */     this.boldFont.setAntiAlias(antiAlias);
/* 491 */     this.italicFont.setAntiAlias(antiAlias);
/* 492 */     this.boldItalicFont.setAntiAlias(antiAlias);
/*     */   }
/*     */   
/*     */   private void setupMinecraftColorcodes() {
/* 496 */     for (int index = 0; index < 32; index++) {
/* 497 */       int var6 = (index >> 3 & 0x1) * 85;
/* 498 */       int var7 = (index >> 2 & 0x1) * 170 + var6;
/* 499 */       int var8 = (index >> 1 & 0x1) * 170 + var6;
/* 500 */       int var9 = (index >> 0 & 0x1) * 170 + var6;
/* 501 */       if (index == 6) {
/* 502 */         var7 += 85;
/*     */       }
/*     */       
/* 505 */       if (index >= 16) {
/* 506 */         var7 /= 4;
/* 507 */         var8 /= 4;
/* 508 */         var9 /= 4;
/*     */       } 
/*     */       
/* 511 */       this.colorCode[index] = (var7 & 0xFF) << 16 | (var8 & 0xFF) << 8 | var9 & 0xFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String trimStringToWidth(String p_78269_1_, int p_78269_2_) {
/* 517 */     return trimStringToWidth(p_78269_1_, p_78269_2_, false);
/*     */   }
/*     */   
/*     */   public String trimStringToWidth(String p_78262_1_, int p_78262_2_, boolean p_78262_3_) {
/* 521 */     StringBuilder var4 = new StringBuilder();
/* 522 */     int var5 = 0;
/* 523 */     int var6 = p_78262_3_ ? (p_78262_1_.length() - 1) : 0;
/* 524 */     int var7 = p_78262_3_ ? -1 : 1;
/* 525 */     boolean var8 = false;
/* 526 */     boolean var9 = false;
/*     */     
/* 528 */     for (int var10 = var6; var10 >= 0 && var10 < p_78262_1_.length() && var5 < p_78262_2_; var10 += var7) {
/* 529 */       char var11 = p_78262_1_.charAt(var10);
/* 530 */       int var12 = getStringWidth(Character.toString(var11));
/* 531 */       if (var8) {
/* 532 */         var8 = false;
/* 533 */         if (var11 != 'l' && var11 != 'L') {
/* 534 */           if (var11 == 'r' || var11 == 'R') {
/* 535 */             var9 = false;
/*     */           }
/*     */         } else {
/* 538 */           var9 = true;
/*     */         } 
/* 540 */       } else if (var12 < 0) {
/* 541 */         var8 = true;
/*     */       } else {
/* 543 */         var5 += var12;
/* 544 */         if (var9) {
/* 545 */           var5++;
/*     */         }
/*     */       } 
/*     */       
/* 549 */       if (var5 > p_78262_2_) {
/*     */         break;
/*     */       }
/*     */       
/* 553 */       if (p_78262_3_) {
/* 554 */         var4.insert(0, var11);
/*     */       } else {
/* 556 */         var4.append(var11);
/*     */       } 
/*     */     } 
/*     */     
/* 560 */     return var4.toString();
/*     */   }
/*     */   
/*     */   public List listFormattedStringToWidth(String str, int wrapWidth) {
/* 564 */     return Arrays.asList(wrapFormattedStringToWidth(str, wrapWidth).split("\n"));
/*     */   }
/*     */   
/*     */   public String wrapFormattedStringToWidth(String str, int wrapWidth) {
/* 568 */     int var3 = sizeStringToWidth(str, wrapWidth);
/* 569 */     if (str.length() <= var3) {
/* 570 */       return str;
/*     */     }
/* 572 */     String var4 = str.substring(0, var3);
/* 573 */     char var5 = str.charAt(var3);
/* 574 */     boolean var6 = !(var5 != ' ' && var5 != '\n');
/* 575 */     String var7 = String.valueOf(getFormatFromString(var4)) + str.substring(var3 + (var6 ? 1 : 0));
/* 576 */     return String.valueOf(var4) + "\n" + wrapFormattedStringToWidth(var7, wrapWidth);
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColor(int colorCode, float alpha) {
/* 581 */     return new Color((colorCode >> 16) / 255.0F, (colorCode >> 8 & 0xFF) / 255.0F, (colorCode & 0xFF) / 255.0F, alpha);
/*     */   }
/*     */   
/*     */   private String setupColorcodeIdentifier() {
/* 585 */     String minecraftColorCodes = "0123456789abcdefklmnor";
/*     */     
/* 587 */     for (int i = 0; i < this.customColorCodes.length; i++) {
/* 588 */       if (this.customColorCodes[i] != null) {
/* 589 */         minecraftColorCodes = String.valueOf(minecraftColorCodes) + (char)i;
/*     */       }
/*     */     } 
/*     */     
/* 593 */     return minecraftColorCodes;
/*     */   }
/*     */   
/*     */   public void onResourceManagerReload(IResourceManager p_110549_1_) {}
/*     */ }


/* Location:              D:\Client\jelly-recode-beta-1.6\Jelly-Recoded\Jelly-Recoded.jar!\wtf\jelly\fonts\cFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */