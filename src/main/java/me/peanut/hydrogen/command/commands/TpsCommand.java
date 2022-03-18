package me.peanut.hydrogen.command.commands;

import me.peanut.hydrogen.command.Command;
import net.minecraft.client.Minecraft;

public class TpsCommand extends Command
{
    @Override
    public void execute(String[] args) {
        long m5 = Minecraft.getMinecraft().getIntegratedServer().tickTimeArray[0];
        long m10 = Minecraft.getMinecraft().getIntegratedServer().tickTimeArray[1];
        long m20 = Minecraft.getMinecraft().getIntegratedServer().tickTimeArray[2];

        msg("§7Sv tps from 5m, 10m, 20m: §a" + m5 + ", " + m10 + ", " + m20);
    }

    @Override
    public String getName() {
        return "tps";
    }

    @Override
    public String getSyntax() {
        return ".tps";
    }

    @Override
    public String getDesc() {
        return "TPS OF SERVER";
    }
}
