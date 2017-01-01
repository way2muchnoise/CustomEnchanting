package customenchanting.gui;

import customenchanting.container.ContainerCustomEnchantmentTable;
import customenchanting.registry.EnchantmentRegistry;
import customenchanting.network.MessageHandler;
import customenchanting.network.message.MessageEnchantment;
import customenchanting.reference.Resources;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import customenchanting.util.TranslationHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class GuiCustomEnchantmentTable extends GuiContainer
{
    private static final ModelBook modelBook = new ModelBook();

    //TODO: Give these names that make sense
    private float field_147071_v;
    private float field_147069_w;
    private float field_147081_y;
    private float field_147080_z;
    private float field_147076_A;

    private float field_147082_x;
    private Random rand = new Random();
    private ItemStack currentStack;
    private ItemStack currentModifier;
    private ContainerCustomEnchantmentTable container;

    public GuiCustomEnchantmentTable(InventoryPlayer inv, TileEntityCustomEnchantmentTable table)
    {
        super(new ContainerCustomEnchantmentTable(inv, table));
        container = (ContainerCustomEnchantmentTable) this.inventorySlots;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        this.fontRendererObj.drawString(TranslationHelper.translateToLocal("customenchanting.container.customEnchantmentTable"), 7, 4, 4210752);
        this.fontRendererObj.drawString(TranslationHelper.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        this.setCurrentStack();
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int x, int y, int button) throws IOException
    {
        super.mouseClicked(x, y, button);
        int xMiddle = (this.width - this.xSize) / 2;
        int yMiddle = (this.height - this.ySize) / 2;

        for (int buttonId = 0; buttonId < 3; ++buttonId)
        {
            int posX = x - (xMiddle + 60);
            int posY = y - (yMiddle + 14 + 19 * buttonId);

            if (posX >= 0 && posY >= 0 && posX < 108 && posY < 19 && this.container.enchantItem(this.mc.player, buttonId))
            {
                MessageHandler.INSTANCE.sendToServer(new MessageEnchantment(this.container.windowId, buttonId));
            }
        }
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Resources.Gui.GUI_CUSTOM_ENCHANT);
        int xMiddle = (this.width - this.xSize) / 2;
        int yMiddle = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(xMiddle, yMiddle, 0, 0, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        GlStateManager.viewport((scaledresolution.getScaledWidth() - 320) / 2 * scaledresolution.getScaleFactor(), (scaledresolution.getScaledHeight() - 240) / 2 * scaledresolution.getScaleFactor(), 320 * scaledresolution.getScaleFactor(), 240 * scaledresolution.getScaleFactor());
        GlStateManager.translate(-0.34F, 0.23F, 0.0F);
        Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
        float f1 = 1.0F;
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.loadIdentity();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.translate(0.0F, 3.3F, -16.0F);
        GlStateManager.scale(f1, f1, f1);
        float f2 = 5.0F;
        GlStateManager.scale(f2, f2, f2);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Resources.Minecraft.ENCHANTED_BOOK);
        GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
        float f3 = this.field_147076_A + (this.field_147080_z - this.field_147076_A) * partialTicks;
        GlStateManager.translate((1.0F - f3) * 0.2F, (1.0F - f3) * 0.1F, (1.0F - f3) * 0.25F);
        GlStateManager.rotate(-(1.0F - f3) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        float f4 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * partialTicks + 0.25F;
        float f5 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * partialTicks + 0.75F;
        f4 = (f4 - (float) MathHelper.fastFloor((double) f4)) * 1.6F - 0.3F;
        f5 = (f5 - (float) MathHelper.fastFloor((double) f5)) * 1.6F - 0.3F;

        if (f4 < 0.0F)
        {
            f4 = 0.0F;
        }

        if (f5 < 0.0F)
        {
            f5 = 0.0F;
        }

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        if (f5 > 1.0F)
        {
            f5 = 1.0F;
        }

        GlStateManager.enableRescaleNormal();
        modelBook.render(null, 0.0F, f4, f5, f3, 0.0F, 0.0625F);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (this.currentModifier != null && this.currentStack != null)
        {
            List<Map.Entry<Integer, EnchantmentData>> enchantments = EnchantmentRegistry.getPossibleEnchants(this.currentModifier);
            for (int id = 0; id < 3; ++id)
            {
                this.zLevel = 0.0F;
                this.mc.getTextureManager().bindTexture(Resources.Gui.GUI_CUSTOM_ENCHANT);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                int size = enchantments.size();

                if (size - 1 - id >= 0)
                {
                    EnchantmentData enchantment = enchantments.get(size - 1 - id).getValue();
                    String s = enchantment.enchantmentobj.getTranslatedName(enchantment.enchantmentLevel);
                    int k1 = 6839882;

                    int l1 = mouseX - (xMiddle + 60);
                    int i2 = mouseY - (yMiddle + 14 + 19 * id);

                    if (l1 >= 0 && i2 >= 0 && l1 < 108 && i2 < 19)
                    {
                        this.drawTexturedModalRect(xMiddle + 60, yMiddle + 14 + 19 * id, 0, 204, 108, 19);
                        k1 = 16777088;
                    } else
                    {
                        this.drawTexturedModalRect(xMiddle + 60, yMiddle + 14 + 19 * id, 0, 166, 108, 19);
                    }

                    fontRendererObj.drawSplitString(s, xMiddle + 62, yMiddle + 16 + 19 * id, 104, k1);
                }
            }
        }
    }

    public void setCurrentStack()
    {
        ItemStack itemstack = this.inventorySlots.getSlot(0).getStack();

        if (!ItemStack.areItemStacksEqual(itemstack, this.currentStack))
        {
            this.currentStack = itemstack;

            do
            {
                this.field_147082_x += (float) (this.rand.nextInt(4) - this.rand.nextInt(4));
            }
            while (this.field_147071_v <= this.field_147082_x + 1.0F && this.field_147071_v >= this.field_147082_x - 1.0F);
        }

        itemstack = this.inventorySlots.getSlot(1).getStack();

        if (!ItemStack.areItemStacksEqual(itemstack, this.currentModifier))
        {
            this.currentModifier = itemstack;

            do
            {
                this.field_147082_x += (float) (this.rand.nextInt(4) - this.rand.nextInt(4));
            }
            while (this.field_147071_v <= this.field_147082_x + 1.0F && this.field_147071_v >= this.field_147082_x - 1.0F);
        }

        this.field_147069_w = this.field_147071_v;
        this.field_147076_A = this.field_147080_z;
        boolean flag = this.currentStack != null && this.currentModifier != null;

        if (flag)
        {
            this.field_147080_z += 0.2F;
        } else
        {
            this.field_147080_z -= 0.2F;
        }

        if (this.field_147080_z < 0.0F)
        {
            this.field_147080_z = 0.0F;
        }

        if (this.field_147080_z > 1.0F)
        {
            this.field_147080_z = 1.0F;
        }

        float f1 = (this.field_147082_x - this.field_147071_v) * 0.4F;
        float f = 0.2F;

        if (f1 < -f)
        {
            f1 = -f;
        }

        if (f1 > f)
        {
            f1 = f;
        }

        this.field_147081_y += (f1 - this.field_147081_y) * 0.9F;
        this.field_147071_v += this.field_147081_y;
    }
}
