package customenchanting.block;

import customenchanting.CustomEnchanting;
import customenchanting.reference.Textures;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCustomEnchantmentTable extends BlockEnchantmentTable
{

    public BlockCustomEnchantmentTable()
    {
        super();
        this.setUnlocalizedName("customEnchantmentTable");
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
            player.openGui(CustomEnchanting.INSTANCE, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCustomEnchantmentTable();
    }
}
