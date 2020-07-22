package mrthomas20121.rocksalt.utils;

import mrthomas20121.rocksalt.RegistryHandler;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.util.Helpers;

public class OreUtils {


    public static void registerOre(String name, Metal metal, boolean canMelt, double chunkChance, double panChance)
    {
        Ore ore = new Ore(TFCUtils.getLoc(name), metal, canMelt, chunkChance, panChance);
        RegistryHandler.addOre(ore);
    }
    public static void registerOre(String name, boolean canMelt, double chunkChance, double panChance)
    {
        registerOre(name, Helpers.getNull(), canMelt, chunkChance, panChance);
    }

}
