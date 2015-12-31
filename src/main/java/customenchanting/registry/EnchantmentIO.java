package customenchanting.registry;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import customenchanting.config.ConfigHandler;
import customenchanting.util.LogHelper;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class EnchantmentIO
{
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(EnchantmentRegistry.getRegistry().getClass(), EnchantmentRegistryAdapter.ADAPTER)
            .setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES).create();

    public static void writeToFile(String filename)
    {
        try {
            File file = new File(ConfigHandler.config.getConfigFile(), filename);
            if (!file.exists()) file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            GSON.toJson(EnchantmentRegistry.getRegistry(), new TypeToken<Map<Item, Map<Integer, EnchantmentData>>>(){}.getType(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            LogHelper.error("failed saving enchants to json");
        }
    }
}
