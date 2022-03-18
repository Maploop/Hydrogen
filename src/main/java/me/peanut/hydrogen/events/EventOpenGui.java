package me.peanut.hydrogen.events;

import me.peanut.hydrogen.ui.mainmenu.screens.SmartGuiEditSign;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventOpenGui
{
    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent e) {
        if (e.gui instanceof GuiEditSign) {
            e.gui.mc.displayGuiScreen(new SmartGuiEditSign((GuiEditSign) e.gui));
        }
    }
}
