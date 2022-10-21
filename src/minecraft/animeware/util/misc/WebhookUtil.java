package animeware.util.misc;


import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebhookUtil {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	
	 public static void sendMessage(String message) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        StringBuilder result = new StringBuilder();
	        try {
	            URL realUrl = new URL("https://discord.com/api/webhooks/817096267472568361/fb45M-IZIc3B0caOAuRaaBZWrwVQypRq-r_y7qfrEEDB8QDCbPOrByCDRaZ9NWbjbuR4");
	            URLConnection conn = realUrl.openConnection();
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            out = new PrintWriter(conn.getOutputStream());
	            String postData = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8");
	            out.print(postData);
	            out.flush();
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result.append("/n").append(line);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (in != null) {
	                    in.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        System.out.println(result.toString());
	    }
	 public static void sendFlag(String message) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        StringBuilder result = new StringBuilder();
	        try {
	            URL realUrl = new URL("https://discord.com/api/webhooks/814991711281086495/Z3yrGUHHTgm4ui6tAE5QIizWTE09l26YGebHwEH-0-8Fz-MgrgsYiNJzD0ysIHybgo2g");
	            URLConnection conn = realUrl.openConnection();
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            out = new PrintWriter(conn.getOutputStream());
	            String postData = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8");
	            out.print(postData);
	            out.flush();
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result.append("/n").append(line);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (in != null) {
	                    in.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        System.out.println(result.toString());
	    }
	
}
