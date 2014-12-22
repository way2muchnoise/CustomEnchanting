package customenchanting.block;

import customenchanting.reference.Textures;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCustomEnchantmentTable extends BlockEnchantmentTable
{

    public BlockCustomEnchantmentTable()
    {
        super();
        this.setBlockName("CustomEnchantmentTable");
        this.setBlockTextureName(Textures.Block.CUSTOM_ENCHANTMENT_TABLE);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCustomEnchantmentTable();
    }
}
