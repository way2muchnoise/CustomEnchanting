package customenchanting.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

public class EnchantmentRegistry
{
    private static Map<Item, Map<Integer, EnchantmentData>> registry = new HashMap<Item, Map<Integer, EnchantmentData>>();

    public static void addEnchant(ItemStack itemStack, EnchantmentData data)
    {
        if (itemStack != null && data != null && itemStack.getItem() != null)
        {
            Map<Integer, EnchantmentData> map = registry.get(itemStack.getItem());
            if (map == null)
                map = new TreeMap<Integer, EnchantmentData>();
            map.put(itemStack.stackSize, data);
            registry.put(itemStack.getItem(), map);
        }
    }

    public static List<Map.Entry<Integer, EnchantmentData>> getPossibleEnchants(ItemStack itemStack)
    {
        List<Map.Entry<Integer, EnchantmentData>> data = new LinkedList<Map.Entry<Integer, EnchantmentData>>();
        if (itemStack != null && itemStack.getItem() != null)
        {
            Map<Integer, EnchantmentData> map = registry.get(itemStack.getItem());
            for (Map.Entry<Integer, EnchantmentData> entry : map.entrySet())
                if (entry.getKey() <= itemStack.stackSize)
                    data.add(entry);
        }
        return data;
    }

    protected static Map<Item, Map<Integer, EnchantmentData>> getRegistry()
    {
        return registry;
    }

    public static void init()
    {
        addEnchant(new ItemStack(Items.leather_chestplate, 1), new EnchantmentData(Enchantment.protection, 1));
        addEnchant(new ItemStack(Items.iron_chestplate, 1), new EnchantmentData(Enchantment.protection, 2));
        addEnchant(new ItemStack(Items.golden_chestplate, 1), new EnchantmentData(Enchantment.protection, 3));
        addEnchant(new ItemStack(Items.diamond_chestplate, 1), new EnchantmentData(Enchantment.protection, 4));
        addEnchant(new ItemStack(Items.feather, 8), new EnchantmentData(Enchantment.featherFalling, 1));
        addEnchant(new ItemStack(Items.feather, 16), new EnchantmentData(Enchantment.featherFalling, 2));
        addEnchant(new ItemStack(Items.feather, 32), new EnchantmentData(Enchantment.featherFalling, 3));
        addEnchant(new ItemStack(Items.feather, 64), new EnchantmentData(Enchantment.featherFalling, 4));
        addEnchant(new ItemStack(Blocks.tnt, 1), new EnchantmentData(Enchantment.blastProtection, 1));
        addEnchant(new ItemStack(Blocks.tnt, 4), new EnchantmentData(Enchantment.blastProtection, 2));
        addEnchant(new ItemStack(Blocks.tnt, 8), new EnchantmentData(Enchantment.blastProtection, 3));
        addEnchant(new ItemStack(Blocks.tnt, 12), new EnchantmentData(Enchantment.blastProtection, 4));
        addEnchant(new ItemStack(Blocks.cactus, 16), new EnchantmentData(Enchantment.thorns, 1));
        addEnchant(new ItemStack(Blocks.cactus, 32), new EnchantmentData(Enchantment.thorns, 2));
        addEnchant(new ItemStack(Blocks.cactus, 64), new EnchantmentData(Enchantment.thorns, 3));
    }
}
