package me.peanut.hydrogen.command.commands;

import me.peanut.hydrogen.command.Command;

public class HydrogenCommand extends Command
{
    @Override
    public void execute(String[] args) {
        msg("§7Hydrogen §8- §7Made by peanut (modified)");
    }

    @Override
    public String getName() {
        return "hydrogen";
    }

    @Override
    public String getSyntax() {
        return ".hydrogen";
    }

    @Override
    public String getDesc() {
        return "Help menu and such";
    }
}
