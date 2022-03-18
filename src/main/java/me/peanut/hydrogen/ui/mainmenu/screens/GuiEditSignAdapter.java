package me.peanut.hydrogen.ui.mainmenu.screens;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.objectweb.asm.ClassVisitor;

import java.util.List;

public class GuiEditSignAdapter
{
    @SideOnly(Side.CLIENT)
    public static void editButtonList(GuiScreen var_1, List<GuiButton> var_2)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        var_2.add(new GuiButton(1, var_1.width / 2 - 100, var_1.height / 4 + 120, "Send close packet"));
    }
}
