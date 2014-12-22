package customenchanting.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import customenchanting.block.BlockCustomEnchantmentTable;
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
}
