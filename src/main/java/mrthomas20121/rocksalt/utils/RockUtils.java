package mrthomas20121.rocksalt.utils;

import mrthomas20121.rocksalt.RegistryHandler;
import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.api.types.RockCategory;
import net.minecraft.util.ResourceLocation;
import static net.dries007.tfc.types.DefaultRocks.METAMORPHIC;
import static net.dries007.tfc.types.DefaultRocks.SEDIMENTARY;
import static net.dries007.tfc.types.DefaultRocks.IGNEOUS_INTRUSIVE;
import static net.dries007.tfc.types.DefaultRocks.IGNEOUS_EXTRUSIVE;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class RockUtils {

    public static void registerRock(String name, @Nonnull ResourceLocation rockCategory, boolean isFluxStone)
    {
        Rock rock = new Rock(TFCUtils.getLoc(name), rockCategory, isFluxStone);
        RegistryHandler.addRock(rock);
    }
    public static void registerMetamorphicRock(String name, boolean isFluxStone)
    {
        registerRock(name, METAMORPHIC, isFluxStone);
    }
    public static void registerSedimentaryRock(String name, boolean isFluxStone)
    {
        registerRock(name, SEDIMENTARY, isFluxStone);
    }
    public static void registerIgneousIntrusiveRock(String name, boolean isFluxStone)
    {
        registerRock(name, IGNEOUS_INTRUSIVE, isFluxStone);
    }
    public static void registerIgneousExtrusiveRock(String name, boolean isFluxStone)
    {
        registerRock(name, IGNEOUS_EXTRUSIVE, isFluxStone);
    }
}
