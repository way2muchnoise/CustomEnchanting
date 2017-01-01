package customenchanting.block;

import customenchanting.CustomEnchanting;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockCustomEnchantmentTable extends BlockEnchantmentTable
{

    public BlockCustomEnchantmentTable()
    {
        super();
        this.setUnlocalizedName("custom_enchantment_table");
        this.setRegistryName("custom_enchantment_table");
        this.setCreativeTab(CreativeTabs.BREWING);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean onBlockActivated(World world, @Nullable BlockPos pos, IBlockState state, @Nullable EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote && pos != null && player != null)
            player.openGui(CustomEnchanting.INSTANCE, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCustomEnchantmentTable();
    }
}
