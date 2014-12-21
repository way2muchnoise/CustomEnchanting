package customenchanting.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import customenchanting.config.ConfigHandler;
import customenchanting.reference.Reference;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                ConfigHandler.getConfigElements(),
                Reference.ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}

