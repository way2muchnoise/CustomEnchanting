package customenchanting.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import customenchanting.container.ContainerCustomEnchantmentTable;
import customenchanting.enchant.EnchantmentRegistry;
import customenchanting.reference.Resources;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import customenchanting.util.TranslationHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

import java.util.List;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class GuiCustomEnchantmentTable extends GuiContainer
{
    private static final ModelBook modelBook = new ModelBook();

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
        container = (ContainerCustomEnchantmentTable)this.inventorySlots;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        this.fontRendererObj.drawString(TranslationHelper.translateToLocal("customenchanting.container.CustomEnchantmentTable"), 12, 5, 4210752);
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
    protected void mouseClicked(int x, int y, int button)
    {
        super.mouseClicked(x, y, button);
        int xMiddle = (this.width - this.xSize) / 2;
        int yMiddle = (this.height - this.ySize) / 2;

        for (int j1 = 0; j1 < 3; ++j1)
        {
            int k1 = x - (xMiddle + 60);
            int l1 = y - (yMiddle + 14 + 19 * j1);

            if (k1 >= 0 && l1 >= 0 && k1 < 108 && l1 < 19 && this.container.enchantItem(this.mc.thePlayer, j1))
            {
                //TODO: packets this.mc.playerController.sendEnchantPacket(this.container.windowId, j1);
            }
        }
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Resources.Gui.GUI_CUSTOM_ENCHANT);
        int xMiddle = (this.width - this.xSize) / 2;
        int yMiddle = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(xMiddle, yMiddle, 0, 0, this.xSize, this.ySize);
        GL11.glPushMatrix();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glViewport((scaledresolution.getScaledWidth() - 320) / 2 * scaledresolution.getScaleFactor(), (scaledresolution.getScaledHeight() - 240) / 2 * scaledresolution.getScaleFactor(), 320 * scaledresolution.getScaleFactor(), 240 * scaledresolution.getScaleFactor());
        GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
        Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
        float f1 = 1.0F;
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        RenderHelper.enableStandardItemLighting();
        GL11.glTranslatef(0.0F, 3.3F, -16.0F);
        GL11.glScalef(f1, f1, f1);
        float f2 = 5.0F;
        GL11.glScalef(f2, f2, f2);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Resources.Minecraft.ENCHANTED_BOOK);
        GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
        float f3 = this.field_147076_A + (this.field_147080_z - this.field_147076_A) * p_146976_1_;
        GL11.glTranslatef((1.0F - f3) * 0.2F, (1.0F - f3) * 0.1F, (1.0F - f3) * 0.25F);
        GL11.glRotatef(-(1.0F - f3) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        float f4 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * p_146976_1_ + 0.25F;
        float f5 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * p_146976_1_ + 0.75F;
        f4 = (f4 - (float) MathHelper.truncateDoubleToInt((double) f4)) * 1.6F - 0.3F;
        f5 = (f5 - (float)MathHelper.truncateDoubleToInt((double)f5)) * 1.6F - 0.3F;

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

        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        modelBook.render(null, 0.0F, f4, f5, f3, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (this.currentModifier != null && this.currentStack != null)
        {
            List<EnchantmentData> enchantments = EnchantmentRegistry.getPossibleEnchants(this.currentModifier);
            for (int i1 = 0; i1 < 3; ++i1)
            {
                this.zLevel = 0.0F;
                this.mc.getTextureManager().bindTexture(Resources.Gui.GUI_CUSTOM_ENCHANT);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                if (enchantments.size()-1-i1 >= 0)
                {
                    EnchantmentData enchantment = enchantments.get(enchantments.size() -1 - i1);
                    String s = enchantment.enchantmentobj.getTranslatedName(enchantment.enchantmentLevel);
                    String s1 = "";
                    int k1 = 6839882;

                    if (this.mc.thePlayer.experienceLevel < i1 && !this.mc.thePlayer.capabilities.isCreativeMode)
                    {
                        this.drawTexturedModalRect(xMiddle + 60, yMiddle + 14 + 19 * i1, 0, 185, 108, 19);
                        fontRendererObj.drawSplitString(s, xMiddle + 62, yMiddle + 16 + 19 * i1, 104, (k1 & 16711422) >> 1);
                        k1 = 4226832;
                        fontRendererObj.drawStringWithShadow(s1, xMiddle + 62 + 104 - fontRendererObj.getStringWidth(s1), yMiddle + 16 + 19 * i1 + 7, k1);
                    } else
                    {
                        int l1 = p_146976_2_ - (xMiddle + 60);
                        int i2 = p_146976_3_ - (yMiddle + 14 + 19 * i1);

                        if (l1 >= 0 && i2 >= 0 && l1 < 108 && i2 < 19)
                        {
                            this.drawTexturedModalRect(xMiddle + 60, yMiddle + 14 + 19 * i1, 0, 204, 108, 19);
                            k1 = 16777088;
                        } else
                        {
                            this.drawTexturedModalRect(xMiddle + 60, yMiddle + 14 + 19 * i1, 0, 166, 108, 19);
                        }

                        fontRendererObj.drawSplitString(s, xMiddle + 62, yMiddle + 16 + 19 * i1, 104, k1);
                        fontRendererObj = this.mc.fontRenderer;
                        k1 = 8453920;
                        fontRendererObj.drawStringWithShadow(s1, xMiddle + 62 + 104 - fontRendererObj.getStringWidth(s1), yMiddle + 16 + 19 * i1 + 7, k1);
                    }
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
        }
        else
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
