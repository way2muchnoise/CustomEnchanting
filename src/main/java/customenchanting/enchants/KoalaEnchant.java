package customenchanting.enchants;

import customenchanting.reference.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

public class KoalaEnchant extends Enchantment
{
    public static KoalaEnchant createKoalaEnchant(int id)
    {
        KoalaEnchant koalaEnchant = new KoalaEnchant(id);
        return koalaEnchant;
    }

    private KoalaEnchant(int id)
    {
        super(id, new ResourceLocation(Reference.ID, "koalaEnchant"), 1, EnumEnchantmentType.ARMOR);
        setName("customEnchanting.koalaEnchant");
    }
}
