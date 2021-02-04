package mrthomas20121.rocksalt;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

import net.dries007.tfc.world.classic.worldgen.vein.VeinRegistry;

import static net.dries007.tfc.TerraFirmaCraft.MOD_ID;

public class VeinLoader
{
    /**
     * load your vein loader
     * @param mod_id your mod id
     * @param dir Config Folder
     * @param jsonFile name of the json file. must contain .json
     */
    public static void preInit(String mod_id, File dir, String jsonFile)
    {
        File tfcDir = new File(dir, MOD_ID);
        if (!tfcDir.exists() && !tfcDir.mkdir())
        {
            throw new Error("Problem creating TFC extra config directory.");
        }
        File worldGenFile = new File(tfcDir, jsonFile);
        try
        {
            if (worldGenFile.createNewFile())
            {
                FileUtils.copyInputStreamToFile(Objects.requireNonNull(VeinRegistry.class.getClassLoader().getResourceAsStream("assets/"+mod_id+"/config/"+jsonFile)), worldGenFile);
            }
        }
        catch (IOException e)
        {
            throw new Error("Problem creating default ore vein config file.", e);
        }
    }
}