package mrthomas20121.rocksalt;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import net.dries007.tfc.api.types.Metal;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RockSalt.MODID, name = RockSalt.NAME, version = RockSalt.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
                + "required-after:tfc;")
public class RockSalt
{
    public static final String MODID = "rocksalt";
    public static final String NAME = "Rock Salt";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
