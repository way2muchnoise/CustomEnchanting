package customenchanting.reference;

import customenchanting.block.BlockCustomEnchantmentTable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Blocks
{
    public static BlockCustomEnchantmentTable table;

    public static void init()
    {
        table = new BlockCustomEnchantmentTable();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        table.initModel();
    }
}
