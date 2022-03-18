package me.peanut.hydrogen.ui.mainmenu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.peanut.hydrogen.font.FontHelper;
import me.peanut.hydrogen.font.FontUtil;
import me.peanut.hydrogen.utils.ParticleGenerator;
import me.peanut.hydrogen.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Loader;
import me.peanut.hydrogen.Hydrogen;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.*;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by peanut on 26/02/2021
 */
public class MainMenu extends GuiScreen {

    static String splashText;
    static String latest;
    static boolean isLatest;

    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final ParticleGenerator particleGenerator = new ParticleGenerator(100, mc.displayWidth, mc.displayHeight);

    public MainMenu() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/Maploop/Maploop/main/hyd.json");
            URLConnection connection = url.openConnection();
            JsonObject object = (JsonObject) new JsonParser().parse(new Scanner(connection.getInputStream()).useDelimiter("\\A").next());
            splashText = object.get("splash").getAsString();
            latest = object.get("latest").getAsString();

            if (splashText == null) {
                splashText = "Failed to load";
            }
            if (latest == null) {
                latest = "Failed to load";
            }
            isLatest = latest.equals(Hydrogen.version);
            Hydrogen.latest = isLatest;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void drawMenu(int mouseX, int mouseY) {
        if(Hydrogen.getClient().panic) {
            return;
        }

        // side menu rects (buttons)

        drawRect(40, 0, 140, Utils.getScaledRes().getScaledHeight(), 0x60000000);
        drawRect(40, 0, 41, Utils.getScaledRes().getScaledHeight(), 0x60000000);
        drawRect(139, 0, 140, Utils.getScaledRes().getScaledHeight(), 0x60000000);

        // right hand strings

        String mcp = "Client Version " + Hydrogen.version;
        String mname = String.format("Logged in as §7%s", Minecraft.getMinecraft().getSession().getUsername());

        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mcp, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mcp) - 4, Utils.getScaledRes().getScaledHeight() - 14, Color.WHITE);
        FontHelper.comfortaa_r.drawStringWithShadowMainMenu(mname, Utils.getScaledRes().getScaledWidth() - FontHelper.comfortaa_r.getStringWidth(mname) - 4, Utils.getScaledRes().getScaledHeight() - 26, Color.WHITE);
        // outdated check

        if(!isLatest) {
            FontHelper.comfortaa_r.drawStringWithShadow("§cOutdated!", 144, Utils.getScaledRes().getScaledHeight() - 26, Color.WHITE);
            FontHelper.comfortaa_r.drawStringWithShadow("Newest Version: §a" + Hydrogen.getClient().newversion, 144, Utils.getScaledRes().getScaledHeight() - 14, Color.WHITE);
        } else {
            FontHelper.comfortaa_r.drawStringWithShadowMainMenu("§aYou are using the latest version!", 144, Utils.getScaledRes().getScaledHeight() - 14, Color.white);
        }

        // first start

        if(Hydrogen.getClient().firstStart) {
            FontUtil.drawTotalCenteredStringWithShadowSFL2("Welcome to", Utils.getScaledRes().getScaledWidth() / 2 - 22, Utils.getScaledRes().getScaledHeight() / 2 - (FontHelper.sf_l2.getHeight() / 2) - 35, new Color(207, 238, 255));
        }
        // logo

        FontHelper.sf_l_mm.drawString("hydrogen", Utils.getScaledRes().getScaledWidth() / 2 - 43, Utils.getScaledRes().getScaledHeight() / 2 - 36, new Color(51, 50, 50));
        FontHelper.sf_l_mm.drawString("hydrogen", Utils.getScaledRes().getScaledWidth() / 2 - 45, Utils.getScaledRes().getScaledHeight() / 2 - 37, new Color(207, 238, 255));

        FontHelper.sf_l2.drawStringWithShadow("§7" + Hydrogen.version, Utils.getScaledRes().getScaledWidth() / 2 + FontHelper.sf_l_mm.getStringWidth("hydrogen") - 46, Utils.getScaledRes().getScaledHeight() / 2 - 38, Color.white);

        // splash

        FontUtil.drawTotalCenteredStringWithShadowComfortaa(splashText, Utils.getScaledRes().getScaledWidth() / 2 + (FontHelper.sf_l_mm.getStringWidth("hydrogen") / 2) - 46, Utils.getScaledRes().getScaledHeight() / 2 + 33, Color.WHITE);

        particleGenerator.drawParticles(mouseX, mouseY, true);
    }

}