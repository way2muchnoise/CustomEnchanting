package customenchanting.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class KoalaEnchant extends Enchantment
{
    public static KoalaEnchant createKoalaEnchant(int id)
    {
        KoalaEnchant koalaEnchant = new KoalaEnchant(id);
        return koalaEnchant;
    }

    private KoalaEnchant(int id)
    {
        super(id, 1, EnumEnchantmentType.armor);
        setName("customEnchanting.koalaEnchant");
    }
}
