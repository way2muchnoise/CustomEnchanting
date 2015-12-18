package customenchanting.proxy;

import customenchanting.reference.Blocks;
import customenchanting.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        super.preInit();
    }

    @Override
    public void init()
    {
        super.init();
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                Item.getItemFromBlock(Blocks.enchantmentTable), 0,
                new ModelResourceLocation(Reference.ID, Blocks.enchantmentTable + "_base")
        );
    }

    @Override
    public void postInit()
    {
        super.postInit();
    }
}
