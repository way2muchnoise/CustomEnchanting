package customenchanting.proxy;

import customenchanting.CustomEnchanting;
import customenchanting.reference.Blocks;
import customenchanting.registry.EnchantmentIO;
import customenchanting.registry.EnchantmentRegistry;
import customenchanting.gui.GuiHandler;
import customenchanting.network.MessageHandler;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit()
    {
        MessageHandler.init();
        Blocks.init();
        GameRegistry.registerTileEntity(TileEntityCustomEnchantmentTable.class, "customEnchantmentTable");
    }

    public void init()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(CustomEnchanting.INSTANCE, new GuiHandler());
    }

    public void postInit()
    {
        EnchantmentRegistry.init();
        EnchantmentIO.writeToFile("test.json");
    }
}
