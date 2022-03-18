package me.peanut.hydrogen.ui.mainmenu.screens;

import me.peanut.hydrogen.utils.Ref;
import me.peanut.hydrogen.utils.ReflectionUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.io.IOException;
import java.lang.reflect.Field;

public class SmartGuiEditSign extends GuiEditSign
{
    public SmartGuiEditSign(GuiEditSign p_i1097_1_) {
        // DOES NOT WORK RN!!!!
        super(null);

        this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 120, "Send close packet"));
    }

    @Override
    protected void actionPerformed(GuiButton p_actionPerformed_1_) throws IOException {
        super.actionPerformed(p_actionPerformed_1_);
        if (p_actionPerformed_1_.id == 1) {
            this.sendChatMessage("Cannot send packet! Internal error");
        }
    }
}
