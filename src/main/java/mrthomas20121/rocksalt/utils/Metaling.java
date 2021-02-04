package mrthomas20121.rocksalt.utils;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;

public class Metaling {

    public static String getPath(Metal metal)
    {
        return metal.getRegistryName().getPath();
    }

    public static Metal getMetal(String name)
    {
        return TFCRegistries.METALS.getValue(TFC.get(name));
    }
}
