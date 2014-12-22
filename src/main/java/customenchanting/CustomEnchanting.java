package customenchanting;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import customenchanting.config.ConfigHandler;
import customenchanting.proxy.CommonProxy;
import customenchanting.reference.MetaData;
import customenchanting.reference.Reference;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION_FULL, guiFactory = Reference.GUI_FACTORY, dependencies = "required-after:NotEnoughItems;required-after:Waila")
public class CustomEnchanting
{
    @Mod.Instance(value = Reference.ID)
    public static CustomEnchanting INSTANCE;

    @Mod.Metadata(Reference.ID)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        INSTANCE = this;
        metadata = MetaData.init(metadata);
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        PROXY.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

}
