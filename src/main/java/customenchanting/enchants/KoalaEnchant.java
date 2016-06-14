package customenchanting.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class KoalaEnchant extends Enchantment
{
    public static KoalaEnchant createKoalaEnchant(int id)
    {
        return new KoalaEnchant(id);
    }

    private KoalaEnchant(int id)
    {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET});
        setName("customEnchanting.koalaEnchant");
    }
}
