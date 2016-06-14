package customenchanting.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

public class EnchantmentRegistry
{
    private static Map<Item, Map<Integer, EnchantmentData>> registry = new HashMap<>();

    public static void addEnchant(ItemStack itemStack, EnchantmentData data)
    {
        if (itemStack != null && data != null && itemStack.getItem() != null)
        {
            Map<Integer, EnchantmentData> map = registry.get(itemStack.getItem());
            if (map == null)
                map = new TreeMap<>();
            map.put(itemStack.stackSize, data);
            registry.put(itemStack.getItem(), map);
        }
    }

    public static List<Map.Entry<Integer, EnchantmentData>> getPossibleEnchants(ItemStack itemStack)
    {
        List<Map.Entry<Integer, EnchantmentData>> data = new LinkedList<>();
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
        Enchantment protection = Enchantment.getEnchantmentByLocation("protection");
        if (protection != null)
        {
            addEnchant(new ItemStack(Items.LEATHER_CHESTPLATE, 1), new EnchantmentData(protection, 1));
            addEnchant(new ItemStack(Items.IRON_CHESTPLATE, 1), new EnchantmentData(protection, 2));
            addEnchant(new ItemStack(Items.GOLDEN_CHESTPLATE, 1), new EnchantmentData(protection, 3));
            addEnchant(new ItemStack(Items.DIAMOND_CHESTPLATE, 1), new EnchantmentData(protection, 4));
        }
        Enchantment featherFalling = Enchantment.getEnchantmentByLocation("feather_falling");
        if (featherFalling != null)
        {
            addEnchant(new ItemStack(Items.FEATHER, 8), new EnchantmentData(featherFalling, 1));
            addEnchant(new ItemStack(Items.FEATHER, 16), new EnchantmentData(featherFalling, 2));
            addEnchant(new ItemStack(Items.FEATHER, 32), new EnchantmentData(featherFalling, 3));
            addEnchant(new ItemStack(Items.FEATHER, 64), new EnchantmentData(featherFalling, 4));
        }
        Enchantment blastProtection = Enchantment.getEnchantmentByLocation("blast_protection");
        if (blastProtection != null)
        {
            addEnchant(new ItemStack(Blocks.TNT, 1), new EnchantmentData(blastProtection, 1));
            addEnchant(new ItemStack(Blocks.TNT, 4), new EnchantmentData(blastProtection, 2));
            addEnchant(new ItemStack(Blocks.TNT, 8), new EnchantmentData(blastProtection, 3));
            addEnchant(new ItemStack(Blocks.TNT, 12), new EnchantmentData(blastProtection, 4));
        }
        Enchantment thorns = Enchantment.getEnchantmentByLocation("thorns");
        if (thorns != null)
        {
            addEnchant(new ItemStack(Blocks.CACTUS, 16), new EnchantmentData(thorns, 1));
            addEnchant(new ItemStack(Blocks.CACTUS, 32), new EnchantmentData(thorns, 2));
            addEnchant(new ItemStack(Blocks.CACTUS, 64), new EnchantmentData(thorns, 3));
        }
    }
}
