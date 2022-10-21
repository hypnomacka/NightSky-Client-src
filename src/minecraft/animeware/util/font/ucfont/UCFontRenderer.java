package animeware.util.font.ucfont;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public final class UCFontRenderer
extends UCFont {
    protected final UCFont.CharData[] boldItalicChars = new UCFont.CharData[256];
    protected final UCFont.CharData[] italicChars = new UCFont.CharData[256];
    protected final UCFont.CharData[] boldChars = new UCFont.CharData[256];
    private final int[] colorCode = new int[32];
    private char COLOR_CODE_START = (char)167;
    protected DynamicTexture texBold;
    protected DynamicTexture texItalic;
    protected DynamicTexture texItalicBold;

    public UCFontRenderer(ResourceLocation resourceLocation, float size) {
        super(resourceLocation, size);
        this.setupMinecraftColorCodes();
        this.setupBoldItalicIDs();
    }

    public float drawStringWithShadow(String text, double x, double y, int color, int shadowColor) {
        float shadowWidth = this.drawString(text, x + 1.0, y + 1.0, shadowColor, false);
        return Math.max(shadowWidth, this.drawString(text, x, y, color, false));
    }

    public float drawStringWithShadow(String text, double x, double y, int color) {
        float shadowWidth = this.drawString(text, x + 1.0, y + 1.0, color, true);
        return Math.max(shadowWidth, this.drawString(text, x, y, color, false));
    }

    public float drawString(String text, float x, float y, int color) {
        return this.drawString(text, x, y, color, false);
    }

    public float drawCenteredString(String text, float x, float y, int color) {
        return this.drawString(text, x - (float)this.getStringWidth(text) / 2.0f, y, color);
    }

    public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
        this.drawString(text, (double)(x - (float)this.getStringWidth(text) / 2.0f) + 1.0, (double)y + 1.0, color, true);
        return this.drawString(text, x - (float)this.getStringWidth(text) / 2.0f, y, color);
    }

    public float drawString(String text, double x, double y, int color, boolean shadow) {
        x -= 1.0;
        if (text == null) {
            return 0.0f;
        }
        if (color == 0x20FFFFFF) {
            color = 0xFFFFFF;
        }
        if ((color & 0xFC000000) == 0) {
            color |= 0xFF000000;
        }
        if (shadow) {
            color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
        }
        UCFont.CharData[] currentData = this.charData;
        float alpha = (float)(color >> 24 & 0xFF) / 255.0f;
        boolean bold = false;
        boolean italic = false;
        boolean strike = false;
        boolean underline = false;
        boolean render = true;
        x *= 2.0;
        y = (y - 3.0) * 2.0;
        if (render) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f((float)(color >> 16 & 0xFF) / 255.0f, (float)(color >> 8 & 0xFF) / 255.0f, (float)(color & 0xFF) / 255.0f, alpha);
            int size = text.length();
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, this.tex.getGlTextureId());
            for (int i = 0; i < size; ++i) {
                char character = text.charAt(i);
                if (character == this.COLOR_CODE_START && i < size) {
                    int colorIndex = 21;
                    try {
                        colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (colorIndex < 16) {
                        bold = false;
                        italic = false;
                        underline = false;
                        strike = false;
                        GL11.glBindTexture(3553, this.tex.getGlTextureId());
                        currentData = this.charData;
                        if (colorIndex < 0 || colorIndex > 15) {
                            colorIndex = 15;
                        }
                        if (shadow) {
                            colorIndex += 16;
                        }
                        int cc = this.colorCode[colorIndex];
                        GL11.glColor4f((float)(cc >> 16 & 0xFF) / 255.0f, (float)(cc >> 8 & 0xFF) / 255.0f, (float)(cc & 0xFF) / 255.0f, alpha);
                    } else if (colorIndex != 16) {
                        if (colorIndex == 17) {
                            bold = true;
                            if (italic) {
                                GL11.glBindTexture(3553, this.texItalicBold.getGlTextureId());
                                currentData = this.boldItalicChars;
                            } else {
                                GL11.glBindTexture(3553, this.texBold.getGlTextureId());
                                currentData = this.boldChars;
                            }
                        } else if (colorIndex == 18) {
                            strike = true;
                        } else if (colorIndex == 19) {
                            underline = true;
                        } else if (colorIndex == 20) {
                            italic = true;
                            if (bold) {
                                GL11.glBindTexture(3553, this.texItalicBold.getGlTextureId());
                                currentData = this.boldItalicChars;
                            } else {
                                GL11.glBindTexture(3553, this.texItalic.getGlTextureId());
                                currentData = this.italicChars;
                            }
                        } else if (colorIndex == 21) {
                            bold = false;
                            italic = false;
                            underline = false;
                            strike = false;
                            GL11.glColor4f((float)(color >> 16 & 0xFF) / 255.0f, (float)(color >> 8 & 0xFF) / 255.0f, (float)(color & 0xFF) / 255.0f, alpha);
                            GL11.glBindTexture(3553, this.tex.getGlTextureId());
                            currentData = this.charData;
                        }
                    }
                    ++i;
                    continue;
                }
                if (character >= currentData.length || character < '\u0000') continue;
                GL11.glBegin(4);
                this.drawChar(currentData, character, (float)x, (float)y + 6.0f);
                GL11.glEnd();
                if (strike) {
                    this.drawLine(x, y + (double)(currentData[character].height / 2), x + (double)currentData[character].width - 8.0, y + (double)(currentData[character].height / 2));
                }
                if (underline) {
                    this.drawLine(x, y + (double)currentData[character].height - 2.0, x + (double)currentData[character].width - 8.0, y + (double)currentData[character].height - 2.0);
                }
                x += (double)(currentData[character].width - 8 + this.charOffset);
            }
            GL11.glHint(3155, 4352);
            GL11.glPopMatrix();
        }
        return (float)x / 2.0f;
    }

    @Override
    public int getStringWidth(String text) {
        if (text == null) {
            return 0;
        }
        int width = 0;
        UCFont.CharData[] currentData = this.charData;
        boolean bold = false;
        boolean italic = false;
        int size = text.length();
        for (int i = 0; i < size; ++i) {
            char character = text.charAt(i);
            if (character == this.COLOR_CODE_START) {
                int colorIndex = "0123456789abcdefklmnor".indexOf(character);
                if (colorIndex < 16) {
                    bold = false;
                    italic = false;
                } else if (colorIndex == 17) {
                    bold = true;
                    currentData = italic ? this.boldItalicChars : this.boldChars;
                } else if (colorIndex == 20) {
                    italic = true;
                    currentData = bold ? this.boldItalicChars : this.italicChars;
                } else if (colorIndex == 21) {
                    bold = false;
                    italic = false;
                    currentData = this.charData;
                }
                ++i;
                continue;
            }
            if (character >= currentData.length) continue;
            width += currentData[character].width - 8 + this.charOffset;
        }
        return width / 2;
    }

    public String trimStringToWidth(String string, double d) {
        return this.trimStringToWidth(string, d, false);
    }

    public String trimStringToWidth(String string, double d, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        float f = 0.0f;
        int n = bl ? string.length() - 1 : 0;
        int n2 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n; i >= 0 && i < string.length() && f < (float)d; i += n2) {
            char c = string.charAt(i);
            double d2 = this.getStringWidth(String.valueOf(c));
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (d2 < 0.0) {
                bl2 = true;
            } else {
                f = (float)((double)f + d2);
                if (bl3) {
                    f += 1.0f;
                }
            }
            if (f > (float)d) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Override
    public void setAntiAlias(boolean antiAlias) {
        super.setAntiAlias(antiAlias);
        this.setupBoldItalicIDs();
    }

    @Override
    public void setFractionalMetrics(boolean fractionalMetrics) {
        super.setFractionalMetrics(fractionalMetrics);
        this.setupBoldItalicIDs();
    }

    private void setupBoldItalicIDs() {
        this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
        this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
        this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
    }

    private void drawLine(double x, double y, double x1, double y1) {
        GL11.glDisable(3553);
        GL11.glLineWidth(1.0f);
        GL11.glBegin(1);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x1, y1);
        GL11.glEnd();
        GL11.glEnable(3553);
    }

    public String lIIIIIIIIIlIllIIllIlIIlIl(String string, double width) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean wasLastCharColorCode = false;
        for (char c : string.toCharArray()) {
            String string2;
            String string3;
            if (wasLastCharColorCode) {
                stringBuilder.append(c);
                wasLastCharColorCode = false;
                continue;
            }
            if (c == '§') {
                stringBuilder.append(c);
                wasLastCharColorCode = true;
                continue;
            }
            stringBuilder.append(c);
            int stringWidth = this.getStringWidth(stringBuilder.toString());
            if (!((double)stringWidth >= width)) continue;
            String string4 = stringBuilder.toString();
            if (string4.contains(" ")) {
                string3 = string4.substring(0, string4.lastIndexOf(" "));
                string2 = string4.substring(string4.lastIndexOf(" "));
                if (string2.startsWith(" ")) {
                    string2 = string2.replaceFirst(" ", "");
                }
            } else {
                string3 = string4.substring(0, string4.length() - 1);
                string2 = string4.substring(string4.length() - 1);
            }
            stringBuilder2.append(string3).append("\n");
            String string5 = EnumChatFormatting.getTextWithoutFormattingCodes(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(string2).append(string5);
        }
        stringBuilder2.append((CharSequence)stringBuilder);
        return stringBuilder2.length() == 0 ? string : stringBuilder2.toString();
    }

    public List<String> wrapWords(String text, double width) {
        ArrayList<String> finalWords = new ArrayList<String>();
        if ((double)this.getStringWidth(text) > width) {
            String[] words = text.split(" ");
            StringBuilder currentWord = new StringBuilder();
            int lastColorCode = 65535;
            for (String word : words) {
                for (int i = 0; i < word.toCharArray().length; ++i) {
                    char c = word.toCharArray()[i];
                    if (c != this.COLOR_CODE_START || i >= word.toCharArray().length - 1) continue;
                    lastColorCode = word.toCharArray()[i + 1];
                }
                if ((double)this.getStringWidth(currentWord + word + " ") < width) {
                    currentWord.append(word).append(" ");
                    continue;
                }
                finalWords.add(currentWord.toString());
                currentWord = new StringBuilder(this.COLOR_CODE_START + lastColorCode + word + " ");
            }
            if (currentWord.length() > 0) {
                if ((double)this.getStringWidth(currentWord.toString()) < width) {
                    finalWords.add(this.COLOR_CODE_START + lastColorCode + currentWord.toString() + " ");
                } else {
                    finalWords.addAll(this.formatString(currentWord.toString(), width));
                }
            }
        } else {
            finalWords.add(text);
        }
        return finalWords;
    }

    public List<String> formatString(String string, double width) {
        ArrayList<String> finalWords = new ArrayList<String>();
        StringBuilder currentWord = new StringBuilder();
        int lastColorCode = 65535;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == this.COLOR_CODE_START && i < chars.length - 1) {
                lastColorCode = chars[i + 1];
            }
            if ((double)this.getStringWidth(currentWord.toString() + c) < width) {
                currentWord.append(c);
                continue;
            }
            finalWords.add(currentWord.toString());
            currentWord = new StringBuilder(this.COLOR_CODE_START + lastColorCode + String.valueOf(c));
        }
        if (currentWord.length() > 0) {
            finalWords.add(currentWord.toString());
        }
        return finalWords;
    }

    private void setupMinecraftColorCodes() {
        for (int index = 0; index < 32; ++index) {
            int alpha = (index >> 3 & 1) * 85;
            int red = (index >> 2 & 1) * 170 + alpha;
            int green = (index >> 1 & 1) * 170 + alpha;
            int blue = (index & 1) * 170 + alpha;
            if (index == 6) {
                red += 85;
            }
            if (index >= 16) {
                red /= 4;
                green /= 4;
                blue /= 4;
            }
            this.colorCode[index] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
        }
    }
}
