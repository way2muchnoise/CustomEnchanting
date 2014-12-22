package customenchanting.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
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

    public static void init()
    {
        addEnchant(new ItemStack(Items.diamond_chestplate, 1), new EnchantmentData(Enchantment.protection, 4));
    }
}
