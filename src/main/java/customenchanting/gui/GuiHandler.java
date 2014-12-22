package customenchanting.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import customenchanting.container.ContainerCustomEnchantmentTable;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityCustomEnchantmentTable)
            return new ContainerCustomEnchantmentTable(player.inventory, (TileEntityCustomEnchantmentTable) entity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntityCustomEnchantmentTable)
            return new GuiCustomEnchantmentTable(player.inventory, (TileEntityCustomEnchantmentTable) entity);
        return null;
    }
}
