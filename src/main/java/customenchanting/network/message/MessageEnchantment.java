package customenchanting.network.message;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import customenchanting.container.ContainerCustomEnchantmentTable;
import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.client.C11PacketEnchantItem;

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

        server.playerEntity.func_143004_u();

        Container container = server.playerEntity.openContainer;
        if (container.windowId == message.windowId && container.isPlayerNotUsingContainer(server.playerEntity))
        {
            container.enchantItem(server.playerEntity, message.buttonId);
            container.detectAndSendChanges();
        }
        return null;
    }
}
