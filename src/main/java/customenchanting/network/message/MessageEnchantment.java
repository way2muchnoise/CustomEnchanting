package customenchanting.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageEnchantment implements IMessage, IMessageHandler<MessageEnchantment, IMessage>
{
    private int windowId, buttonId;

    public MessageEnchantment()
    {

    }

    public MessageEnchantment(int windowId, int buttonId)
    {
        this.buttonId = buttonId;
        this.windowId = windowId;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.buttonId = buf.readInt();
        this.windowId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.buttonId);
        buf.writeInt(this.windowId);
    }

    @Override
    public IMessage onMessage(MessageEnchantment message, MessageContext ctx)
    {
        NetHandlerPlayServer server = ctx.getServerHandler();

        server.playerEntity.markPlayerActive();

        Container container = server.playerEntity.openContainer;
        if (container.windowId == message.windowId && container.getCanCraft(server.playerEntity))
        {
            container.enchantItem(server.playerEntity, message.buttonId);
            container.detectAndSendChanges();
        }
        return null;
    }
}
