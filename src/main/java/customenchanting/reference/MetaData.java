package customenchanting.reference;

import net.minecraftforge.fml.common.ModMetadata;

import java.util.Arrays;

/**
 * Holds the metadata
 */
public class MetaData
{
    /**
     * Setup mod metadata
     *
     * @param metadata
     * @return edited metadata object
     */
    public static ModMetadata init(ModMetadata metadata)
    {
        metadata.modId = Reference.ID;
        metadata.name = Reference.NAME;
        metadata.description = Reference.NAME + " adds Enchanting with items";
        //metadata.url = "";
        //metadata.logoFile = "assets/" + Reference.ID + "/logo.png";
        metadata.version = Reference.V_MAJOR + "." + Reference.V_MINOR + "." + Reference.V_REVIS;
        metadata.authorList = Arrays.asList("way2muchnoise", "synkrone");
        //metadata.credits = "";
        metadata.autogenerated = false;
        return metadata;
    }
}
