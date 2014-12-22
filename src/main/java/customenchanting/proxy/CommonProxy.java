package customenchanting.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import customenchanting.CustomEnchanting;
import customenchanting.block.BlockCustomEnchantmentTable;
import customenchanting.enchant.EnchantmentRegistry;
import customenchanting.gui.GuiHandler;
import customenchanting.reference.Blocks;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;

public class CommonProxy
{
    public void preInit()
    {
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
