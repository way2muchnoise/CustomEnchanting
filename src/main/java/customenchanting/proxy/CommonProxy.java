package customenchanting.proxy;

import customenchanting.CustomEnchanting;
import customenchanting.block.BlockCustomEnchantmentTable;
import customenchanting.enchant.EnchantmentRegistry;
import customenchanting.gui.GuiHandler;
import customenchanting.network.MessageHandler;
import customenchanting.reference.Blocks;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit()
    {
        MessageHandler.init();

        Blocks.enchantmentTable = new BlockCustomEnchantmentTable();
        GameRegistry.registerBlock(Blocks.enchantmentTable, Blocks.enchantmentTable.getUnlocalizedName());

        GameRegistry.registerTileEntity(TileEntityCustomEnchantmentTable.class, "customEnchantmentTable");
    }

    public void init()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(CustomEnchanting.INSTANCE, new GuiHandler());
    }

    public void postInit()
    {
        EnchantmentRegistry.init();
    }
}
