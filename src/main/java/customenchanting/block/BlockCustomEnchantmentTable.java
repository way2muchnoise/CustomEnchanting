package customenchanting.block;

import customenchanting.CustomEnchanting;
import customenchanting.reference.Textures;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int int1, float float1, float float2, float float3)
    {
        if (!world.isRemote)
            player.openGui(CustomEnchanting.INSTANCE, 0, world, x, y ,z);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCustomEnchantmentTable();
    }
}
