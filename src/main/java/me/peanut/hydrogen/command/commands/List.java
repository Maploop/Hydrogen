package me.peanut.hydrogen.command.commands;

import me.peanut.hydrogen.command.Command;
import net.minecraft.client.Minecraft;

public class List extends Command
{
    @Override
    public void execute(String[] args) {
        Minecraft minecraft = Minecraft.getMinecraft();
        msg(minecraft.getCurrentServerData().playerList);
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getSyntax() {
        return ".list";
    }

    @Override
    public String getDesc() {
        return "list players";
    }
}
