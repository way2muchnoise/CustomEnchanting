package customenchanting.network;

import customenchanting.network.message.MessageEnchantment;
import customenchanting.reference.Reference;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class MessageHandler implements IMessageHandler
{
    public static SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(Reference.ID);
    public static int id = 0;

    public static void init()
    {
        INSTANCE.registerMessage(MessageEnchantment.class, MessageEnchantment.class, id++, Side.SERVER);
    }

    @Override
    public IMessage onMessage(IMessage message, MessageContext ctx)
    {
        return null;
    }
}
