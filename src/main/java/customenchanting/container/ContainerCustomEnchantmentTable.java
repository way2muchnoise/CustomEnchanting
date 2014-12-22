package customenchanting.container;

import customenchanting.enchant.EnchantmentRegistry;
import customenchanting.tileentity.TileEntityCustomEnchantmentTable;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

public class ContainerCustomEnchantmentTable extends Container
{
    public IInventory enchantInv = new InventoryBasic("Enchant", true, 1)
    {
        @Override
        public int getInventoryStackLimit()
        {
            return 1;
        }
    };

    public IInventory paymentInv = new InventoryBasic("Payment", true, 1)
    {
        @Override
        public boolean isItemValidForSlot(int i, ItemStack stack)
        {
            return true;
        }
    };

    private TileEntityCustomEnchantmentTable table;

    public ContainerCustomEnchantmentTable(InventoryPlayer inv, TileEntityCustomEnchantmentTable table)
    {
        this.table = table;
        this.addSlotToContainer(new Slot(this.enchantInv, 0, 11, 47)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack.getItem().getItemEnchantability() > 0;
            }
        });
        this.addSlotToContainer(new Slot(this.paymentInv, 0, 34, 47)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return true;
            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    /**
     * enchants the item on the table using the specified slot; also deducts XP from player
     */
    public boolean enchantItem(EntityPlayer player, int enchantID)
    {
        ItemStack itemstack = this.enchantInv.getStackInSlot(0);

        if (itemstack != null)
        {
            if (!table.getWorldObj().isRemote)
            {
                List<Map.Entry<Integer, EnchantmentData>> enchantments = EnchantmentRegistry.getPossibleEnchants(this.paymentInv.getStackInSlot(0));
                if (enchantments.size() - 1 - enchantID < 0) return false;
                EnchantmentData enchantment = enchantments.get(enchantments.size() - 1 - enchantID).getValue();
                boolean flag = itemstack.getItem() == Items.book;

                if (enchantment != null)
                {
                    if (flag)
                    {
                        itemstack.func_150996_a(Items.enchanted_book);
                        Items.enchanted_book.addEnchantment(itemstack, enchantment);
                    } else
                    {
                        itemstack.addEnchantment(enchantment.enchantmentobj, enchantment.enchantmentLevel);
                    }

                    this.paymentInv.getStackInSlot(0).stackSize -= enchantments.get(enchantments.size() - 1 - enchantID).getKey();
                    if (this.paymentInv.getStackInSlot(0).stackSize <= 0)
                        this.paymentInv.setInventorySlotContents(0, null);

                    this.onCraftMatrixChanged(enchantInv);
                    this.onCraftMatrixChanged(paymentInv);
                }
            }

            return true;
        } else
        {
            return false;
        }
    }
}
