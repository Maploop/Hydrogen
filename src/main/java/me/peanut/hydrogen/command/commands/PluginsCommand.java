package me.peanut.hydrogen.command.commands;

import me.peanut.hydrogen.command.Command;
import net.minecraft.client.Minecraft;

import java.io.File;

public class PluginsCommand extends Command
{
    @Override
    public void execute(String[] args) {
        Minecraft minecraft = Minecraft.getMinecraft();
        File file = new File(minecraft.getIntegratedServer().getDataDirectory() + "/plugins");
        msg("§7Finding plugins of this server...");
        if (file.exists()) {
            for (File f : file.listFiles()) {
                msg("§a" + f.getName());
            }
        } else {
            msg("§cNo plugins found!");
        }
    }

    @Override
    public String getName() {
        return "pl";
    }

    @Override
    public String getSyntax() {
        return ".pl";
    }

    @Override
    public String getDesc() {
        return "PLUGINS OF SERVER";
    }
}
