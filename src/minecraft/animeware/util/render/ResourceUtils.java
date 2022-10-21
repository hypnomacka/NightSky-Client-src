package animeware.util.render;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;

public class ResourceUtils {
  private static final Map<String, ResourceLocation> playerSkins = new HashMap<>();
  
  static final Minecraft mc = Minecraft.getMinecraft();
  
  public static void drawColoredBlockOverlay(AxisAlignedBB axisAlignedBBIn, int red, int green, int blue, int alpha) {
    Tessellator tessellator = Tessellator.getInstance();
    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
    worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    tessellator.draw();
    worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    tessellator.draw();
    worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    worldrenderer.func_181662_b(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).func_181666_a(red, green, blue, alpha).func_181675_d();
    tessellator.draw();
  }
  
  public static ResourceLocation getHeadLocation(String displayName) {
    ResourceLocation playerSkin = playerSkins.getOrDefault(displayName, new ResourceLocation("urban/ui/defaults/heads/" + displayName + ".png"));
    if (!playerSkins.containsKey(displayName)) {
      ThreadDownloadImageData skinData = new ThreadDownloadImageData(null, "https://minotar.net/helm/" + displayName + "/32.png", new ResourceLocation("urban/ui/defaults/heads/steve.png"), null);
      Minecraft.getMinecraft().getTextureManager().loadTexture(playerSkin, (ITextureObject)skinData);
      playerSkins.put(displayName, playerSkin);
    } 
    return playerSkin;
  }
  
  public static DynamicTexture getServerTexture(ServerData server) {
    DynamicTexture texture = null;
    ByteBuf bytebuf = Unpooled.copiedBuffer(server.getBase64EncodedIconData(), Charsets.UTF_8);
    ByteBuf bytebuf1 = Base64.decode(bytebuf);
    BufferedImage bufferedimage = null;
    try {
      bufferedimage = TextureUtil.readBufferedImage((InputStream)new ByteBufInputStream(bytebuf1));
    } catch (Throwable throwable) {
      //Logger.error("Failed to load server icon for " + server.serverName);
    } finally {
      bytebuf.release();
      bytebuf1.release();
    } 
    texture = new DynamicTexture(bufferedimage.getWidth(), bufferedimage.getHeight());
    bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), texture.getTextureData(), 0, bufferedimage.getWidth());
    texture.updateDynamicTexture();
    return texture;
  }
  
  public static DynamicTexture getResourcePackImg(int i) {
    DynamicTexture texture;
    try {
      texture = new DynamicTexture(((ResourcePackRepository.Entry)mc.getResourcePackRepository().getRepositoryEntries().get(i)).getResourcePack().getPackImage());
    } catch (IOException var4) {
      texture = TextureUtil.missingTexture;
    } 
    return texture;
  }
}
