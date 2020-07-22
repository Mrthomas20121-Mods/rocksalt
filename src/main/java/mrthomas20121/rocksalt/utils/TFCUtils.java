package mrthomas20121.rocksalt.utils;

import net.dries007.tfc.TerraFirmaCraft;
import net.minecraft.util.ResourceLocation;

public class TFCUtils {

    public static ResourceLocation getLoc(String name)
    {
        return new ResourceLocation(TerraFirmaCraft.MOD_ID, name);
    }
    public static String combine(String name)
    {
        return TerraFirmaCraft.MOD_ID + ":"+name;
    }
}
