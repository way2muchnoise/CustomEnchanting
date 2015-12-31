package customenchanting.registry;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.IOException;
import java.util.Map;

public class EnchantmentRegistryAdapter extends TypeAdapter<Map<Item, Map<Integer, EnchantmentData>>>
{
    public static final EnchantmentRegistryAdapter ADAPTER = new EnchantmentRegistryAdapter();

    @Override
    public void write(JsonWriter out, Map<Item, Map<Integer, EnchantmentData>> value) throws IOException
    {
        out.beginArray();
        for (Map.Entry<Item, Map<Integer, EnchantmentData>> entry : value.entrySet())
        {
            out.beginObject();
            out.name("item").value(GameRegistry.findUniqueIdentifierFor(entry.getKey()).toString());
            out.name("enchants").beginArray();
            for (Map.Entry<Integer, EnchantmentData> enchantData : entry.getValue().entrySet())
                out.name("" + entry.getKey()).value(enchantData.getValue().enchantmentobj.getName() + ":" + enchantData.getValue().enchantmentLevel);
            out.endArray();
            out.endObject();
        }
    }

    @Override
    public Map<Item, Map<Integer, EnchantmentData>> read(JsonReader in) throws IOException
    {
        return null;
    }
}
