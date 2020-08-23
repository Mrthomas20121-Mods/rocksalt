package mrthomas20121.rocksalt.utils;

import mrthomas20121.rocksalt.RegistryHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.util.Helpers;
import net.minecraft.util.ResourceLocation;

public class OreUtils {

    public static Ore getOre(String name)
    {
        return TFCRegistries.ORES.getValue(TFCUtils.getLoc(name));
    }

    public static ResourceLocation getOreRegistryName(String name)
    {
        return getOre(name).getRegistryName();
    }

    public static ResourceLocation getOreRegistryName(Ore ore)
    {
        return ore.getRegistryName();
    }

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
