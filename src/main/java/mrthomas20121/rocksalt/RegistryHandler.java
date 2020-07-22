package mrthomas20121.rocksalt;


import mrthomas20121.rocksalt.utils.MetalUtils;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.api.types.Rock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = RockSalt.MODID)
public class RegistryHandler {

    private static ArrayList<Rock> rocks = new ArrayList<>();

    public static void addRock(Rock rock)
    {
        rocks.add(rock);
    }
    public static ArrayList<Rock> getRocks() {
        return rocks;
    }

    private static ArrayList<Ore> ores = new ArrayList<>();

    public static void addOre(Ore ore)
    {
        ores.add(ore);
    }

    public static ArrayList<Ore> getOres() {
        return ores;
    }

    private static ArrayList<Metal> metals = new ArrayList<>();

    public static void addMetal(Metal metal)
    {
        metals.add(metal);
    }

    public static ArrayList<Metal> getMetals() {
        return metals;
    }

    @SubscribeEvent
    public static void onPreRegisterMetal(TFCRegistryEvent.RegisterPreBlock<Metal> event)
    {
        IForgeRegistry<Metal> r = event.getRegistry();
        for(Metal metal : getMetals())
        {
            r.register(metal);
        }
    }
    @SubscribeEvent
    public static void onPreRegisterRock(TFCRegistryEvent.RegisterPreBlock<Rock> event)
    {
        IForgeRegistry<Rock> r = event.getRegistry();
        for(Rock rock : getRocks())
        {
            r.register(rock);
        }
    }
}
